package br.edu.vgs.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.vgs.domain.Boleto;
import br.edu.vgs.domain.Compra;
import br.edu.vgs.domain.ItemCompra;
import br.edu.vgs.domain.enums.CompraStatus;
import br.edu.vgs.repositories.CompraRepository;
import br.edu.vgs.repositories.ItemCompraRepository;
import br.edu.vgs.repositories.PagamentoRepository;
import br.edu.vgs.services.exceptions.ObjectNotFoundException;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmailService emailService;
	
	public Compra find(Integer id) {
		Optional<Compra> compraService = compraRepository.findById(id);
		return compraService.orElseThrow(() -> new ObjectNotFoundException(
				"Compra não encontrada! Código: " + id + ", consulta: " + Compra.class.getName()));
	}
	
	@Transactional
	public Compra insert(Compra compra) {
		compra.setId(null);
		compra.setData(new Date());
		compra.setUsuario(usuarioService.find(compra.getUsuario().getId()));
		compra.getPagamento().setStatus(CompraStatus.PENDENTE);
		compra.getPagamento().setCompra(compra);
		
		if(compra.getPagamento() instanceof Boleto) {
			Boleto boleto = (Boleto) compra.getPagamento();
			boletoService.preencherBoleto(boleto, compra.getData());
		}
		compra = compraRepository.save(compra);
		pagamentoRepository.save(compra.getPagamento());
		
		for(ItemCompra item : compra.getItens()) {
			item.setJogo(jogoService.find(item.getJogo().getId()));
			item.setPreco(item.getJogo().getPreco());
			item.setCompra(compra);
		}
		itemCompraRepository.saveAll(compra.getItens());
		emailService.confirmacaoCompra(compra);
		return compra;
	}
}
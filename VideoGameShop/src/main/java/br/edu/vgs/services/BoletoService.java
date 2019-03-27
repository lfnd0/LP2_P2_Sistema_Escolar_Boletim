package br.edu.vgs.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.edu.vgs.domain.Boleto;

@Service
public class BoletoService {
	
	public void preencherBoleto(Boleto boleto, Date data) {
		Calendar validade = Calendar.getInstance();
		validade.setTime(data);
		validade.add(Calendar.DAY_OF_MONTH, 7);
		boleto.setVencimento(validade.getTime());
	}
}
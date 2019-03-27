package br.edu.vgs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.vgs.domain.Usuario;
import br.edu.vgs.domain.DTO.UsuarioDTO;
import br.edu.vgs.repositories.UsuarioRepository;
import br.edu.vgs.services.exceptions.DataIntegrityException;
import br.edu.vgs.services.exceptions.ObjectNotFoundException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario find(Integer id) {
		Optional<Usuario> usuarioService = usuarioRepository.findById(id);
		return usuarioService.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Código: " + id + ", consulta: " + Usuario.class.getName()));
	}
	
	@Transactional
	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		Usuario novoUsuario = find(usuario.getId());
		updateData(novoUsuario, usuario);
		return usuarioRepository.save(novoUsuario);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Ação cancelada, existe(m) compra(s) cadastrada(s) neste usuário.");
		}
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
	
	private void updateData(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());
	}
}
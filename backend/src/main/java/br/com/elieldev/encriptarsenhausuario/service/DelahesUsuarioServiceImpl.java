package br.com.elieldev.encriptarsenhausuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.elieldev.autenticacao.jwt.data.DetalhesUsuarioData;
import br.com.elieldev.encriptarsenhausuario.model.UsuarioModel;
import br.com.elieldev.encriptarsenhausuario.repository.UsuarioRepository;

@Component
public class DelahesUsuarioServiceImpl implements UserDetailsService {

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> usuario = usuarioRepository.findByLogin(username);

		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuario [" + username + "] não encontrado");
		}
		
		return new DetalhesUsuarioData(usuario);
	}

}

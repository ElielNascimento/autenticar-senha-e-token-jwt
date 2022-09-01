package br.com.elieldev.autenticacao.jwt.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.elieldev.encriptarsenhausuario.model.UsuarioModel;

public class DetalhesUsuarioData implements UserDetails {
	private static final long serialVersionUID = 1L;

	private final Optional<UsuarioModel> usuario;

	public DetalhesUsuarioData(Optional<UsuarioModel> usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.orElse(new UsuarioModel()).getPassword();
	}

	@Override
	public String getUsername() {

		return usuario.orElse(new UsuarioModel()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

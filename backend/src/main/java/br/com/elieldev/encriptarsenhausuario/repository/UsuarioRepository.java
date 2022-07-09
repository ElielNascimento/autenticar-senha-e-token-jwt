package br.com.elieldev.encriptarsenhausuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elieldev.encriptarsenhausuario.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<UsuarioModel> findByLogin(String login);
	

	
}

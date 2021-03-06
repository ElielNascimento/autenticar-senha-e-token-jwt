package br.com.elieldev.encriptarsenhausuario.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.elieldev.encriptarsenhausuario.model.UsuarioModel;
import br.com.elieldev.encriptarsenhausuario.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/listarTodos")
	public ResponseEntity<List<UsuarioModel>> listarTodos() {
		List<UsuarioModel> response = usuarioService.listarTodos();
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody UsuarioModel user) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		UsuarioModel response = usuarioService.criarUsuario(user);
		return ResponseEntity.created(uri).body(response);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuarioPeloId(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/validar")
	public boolean validar(@RequestParam String login, @RequestParam String password) {
		return usuarioService.validarLogin(login, password);
	}

}

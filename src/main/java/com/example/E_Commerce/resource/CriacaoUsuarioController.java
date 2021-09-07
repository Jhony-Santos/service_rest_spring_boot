/*

package com.example.sistemaControle.resource;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaControle.model.Perfis;
import com.example.sistemaControle.model.Usuarios;
import com.example.sistemaControle.repository.CriacaoUsuarioRepository;

@RestController
@RequestMapping("/criausuario")
public class CriacaoUsuarioController {

	final private CriacaoUsuarioRepository criacaoUsuarioRepository;

	public CriacaoUsuarioController(CriacaoUsuarioRepository criacaoUsuarioRepository) {
		this.criacaoUsuarioRepository = criacaoUsuarioRepository;
	}

	@PostMapping
	public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
		String email = body.get("email");
		if (criacaoUsuarioRepository.existsByEmail(email)) {
			throw new ValidationException();
		}
		String senha = body.get("senha");
		String senhaCodificada = new BCryptPasswordEncoder().encode(senha);
		String nome = body.get("nome");
		Usuarios usuarioNovo = new Usuarios(nome, email, senhaCodificada);
		usuarioNovo.adicionarPerfil(new Perfis(2L, "ROLE_CLIENTE"));
		criacaoUsuarioRepository.save(usuarioNovo);
		return true;
	}

}
*/
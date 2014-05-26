package br.com.fipgati.eventos.web.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.fipgati.eventos.domain.model.Usuario;
import br.com.fipgati.eventos.domain.repositorio.UsuarioRepositorio;
import br.com.fipgati.eventos.web.UsuarioWeb;

@Resource
public class UsuarioController {

	private UsuarioRepositorio usuarioRepositorio;
	private Result result;
	private UsuarioWeb usuarioWeb;
	private Validator validator;

	public UsuarioController(UsuarioRepositorio usuarioRepositorio, Result result, UsuarioWeb usuarioWeb, Validator validator) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.result = result;
		this.usuarioWeb = usuarioWeb;
		this.validator = validator;
	}

	@Path("/login")
	public void loginForm() {

	}

	@Post("/login/auth")
	public void login(Usuario usuario) {
		Usuario dbUsuario = usuarioRepositorio.carrega(usuario);
		if (dbUsuario == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();
		usuarioWeb.login(dbUsuario);
		result.redirectTo(EventoController.class).index();

	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(EventoController.class).index();
	}

}

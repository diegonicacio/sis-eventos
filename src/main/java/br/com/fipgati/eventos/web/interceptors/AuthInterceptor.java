package br.com.fipgati.eventos.web.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.fipgati.eventos.web.UsuarioWeb;
import br.com.fipgati.eventos.web.controllers.UsuarioController;

@Intercepts
public class AuthInterceptor implements Interceptor {

	private UsuarioWeb usuario;
	private Result result;

	public AuthInterceptor(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {
		return !usuario.isLogado() && method.containsAnnotation(Auth.class);
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuarioController.class).loginForm();
	}
}

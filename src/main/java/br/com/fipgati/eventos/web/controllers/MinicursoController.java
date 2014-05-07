package br.com.fipgati.eventos.web.controllers;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Minicurso;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.MinicursoRepositorio;

@Resource
public class MinicursoController {
	
	private Result result;
	private MinicursoRepositorio minicursoRepositorio;
	private EventoRepostorio eventoRepostorio;
	private Validator validator;
	
	public MinicursoController(Result result, MinicursoRepositorio minicursoRepositorio, EventoRepostorio eventoRepostorio, Validator validator) {
		this.result = result;
		this.minicursoRepositorio = minicursoRepositorio;
		this.eventoRepostorio = eventoRepostorio;
		this.validator = validator;
	}
	
	@Get("/evento/{evento.id}/newmini")
	public Minicurso newMinicurso(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Minicurso();
	}
	
	@Post("/evento/new/minicurso")
	public void create(Minicurso minicurso, Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		Hibernate.initialize(dbEvento.getListaMinicursos());
		dbEvento.addMinicurso(minicurso);
		validator.onErrorRedirectTo(this).newMinicurso(dbEvento);
		minicursoRepositorio.save(minicurso);
		System.out.println("Salvou Minicurso!");
		result.redirectTo(EventoController.class).gerenciaEvento(dbEvento);
	}

}

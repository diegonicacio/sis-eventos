package br.com.fipgati.eventos.web.controllers;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Patrocinador;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.PatrocinadorRepositorio;


@Resource
public class PatrocinadorController {
	
	private Result result;
	private PatrocinadorRepositorio patrocinadorRepositorio;
	private EventoRepostorio eventoRepostorio;
	
	public PatrocinadorController(Result result, PatrocinadorRepositorio patrocinadorRepositorio, EventoRepostorio eventoRepostorio) {
		this.result = result;
		this.patrocinadorRepositorio = patrocinadorRepositorio;
		this.eventoRepostorio = eventoRepostorio;
	}
	

	@Get("/evento/{evento.id}/patroc")
	public Patrocinador newPatrocinador(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Patrocinador();
	}
	
	@Post("/evento/new/patrocinador")
	public void create(Patrocinador patrocinador, Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		Hibernate.initialize(dbEvento.getListaMinicursos());
		dbEvento.addPatrocinador(patrocinador);
		patrocinadorRepositorio.save(patrocinador);
		System.out.println("Salvou Patrocinador!");
		result.redirectTo(EventoController.class).gerenciaEvento(dbEvento);
	}

}

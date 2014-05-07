package br.com.fipgati.eventos.web.controllers;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Palestra;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.PalestraRepositorio;

@Resource
public class PalestraController {
	
	private Result result;
	private PalestraRepositorio palestraRepositorio;
	private EventoRepostorio eventoRepostorio;
	
	public PalestraController(Result result, PalestraRepositorio palestraRepositorio, EventoRepostorio eventoRepostorio) {
		this.result = result;
		this.palestraRepositorio = palestraRepositorio;
		this.eventoRepostorio = eventoRepostorio;
	}
	
	@Get("/evento/{evento.id}/newpales")
	public Palestra newPalestra(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Palestra();
	}
	
	@Post("/evento/new/palestra")
	public void create(Palestra palestra, Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		Hibernate.initialize(dbEvento.getListaMinicursos());
		dbEvento.addPalestra(palestra);
		palestraRepositorio.save(palestra);
		System.out.println("Salvou Palestra!");
		result.redirectTo(EventoController.class).gerenciaEvento(dbEvento);
	}

}

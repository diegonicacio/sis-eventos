package br.com.fipgati.eventos.web.controllers;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Palestra;
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
	

	@Get("/evento/gerenciar/{evento.id}/patroc")
	public Patrocinador newPatrocinador(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Patrocinador();
	}
	
	@Post("/evento/gerenciar/new/patrocinador")
	public void create(Patrocinador patrocinador, Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		Hibernate.initialize(dbEvento.getListaMinicursos());
		dbEvento.addPatrocinador(patrocinador);
		patrocinadorRepositorio.save(patrocinador);
		result.redirectTo(this).list(dbEvento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/patrocinadores")
	public void list(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("patrocinadorList", patrocinadorRepositorio.listAll());
		result.include("evento", dbEvento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/patrocinador/delete/{patrocinador.id}")
	public void destroy(Evento evento, Patrocinador patrocinador) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.removePatrocinador(patrocinadorRepositorio.load(patrocinador.getId()));
		eventoRepostorio.update(dbEvento);
		patrocinadorRepositorio.delete(patrocinadorRepositorio.load(patrocinador.getId()));
		result.redirectTo(this).list(evento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/patrocinador/edit/{patrocinador.id}")
	public Patrocinador edit(Evento evento, Patrocinador patrocinador) {
		result.include("action", "edit");
		result.include("evento", eventoRepostorio.load(evento.getId()));
		return patrocinadorRepositorio.load(patrocinador.getId());
	}
	
	@Put("/evento/gerenciar/patrocinador/edit")
	public void update(Evento evento, Patrocinador patrocinador, String hora, String data) {
		Patrocinador dbPatrocinador = this.patrocinadorRepositorio.load(patrocinador.getId());
		dbPatrocinador.setNome(patrocinador.getNome());
		dbPatrocinador.setDescricao(patrocinador.getDescricao());
		patrocinadorRepositorio.update(dbPatrocinador);
		result.redirectTo(this).list(evento);
	}

}

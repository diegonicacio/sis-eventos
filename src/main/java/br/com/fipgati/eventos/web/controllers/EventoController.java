package br.com.fipgati.eventos.web.controllers;

import java.util.Calendar;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;

@Resource
public class EventoController {

	private EventoRepostorio eventoRepostorio;
	private Result result;
	private Validator validator;

	public EventoController(EventoRepostorio eventoRepostorio, Result result,
			Validator validator) {
		// TODO Auto-generated constructor stub
		this.eventoRepostorio = eventoRepostorio;
		this.result = result;
		this.validator = validator;
	}

	@Path("/evento/list")
	public void list() {
		result.include("eventoList", eventoRepostorio.listAll());
	}

	@Get("/evento/new")
	public Evento newEvento() {
		result.include("action", "new");
		return new Evento();
	}

	@Post("/evento/evento")
	public void create(Evento evento) {
		System.out.println(evento.toString());
		eventoRepostorio.save(evento);
		System.out.println("Entro aqui");
		result.redirectTo(this).list();
	}

	@Get("/evento/{evento.id}/edit")
	public Evento edit(Evento evento) {
		result.include("action", "edit");
		return eventoRepostorio.load(evento.getId());
	}

	// Ajeitar serDatainicio
	@Put("/eventoedit/evento")
	public void update(Evento evento) {
		System.out.println(evento.getId());
		Evento dbEvento = this.eventoRepostorio.load(evento.getId());
		dbEvento.setNome(evento.getNome());
		dbEvento.setLocal(evento.getLocal());
		dbEvento.setPreco(evento.getPreco());
		dbEvento.setVagas(evento.getVagas());
		dbEvento.setDescricao(evento.getDescricao());
		dbEvento.setDataInicio(Calendar.getInstance());
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).list();
	}

	@Get("/evento/{evento.id}/gerenciar")
	public void gerenciaEvento(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		// Hibernate.initialize(dbEvento.getListaMinicursos());
		// Hibernate.initialize(dbEvento.getListaPalestras());
		// Hibernate.initialize(dbEvento.getListaPatrocinadores());

		result.include("minicursoList", dbEvento.getListaMinicursos());
		result.include("palestraList", dbEvento.getListaPalestras());
		result.include("patrocinadorList", dbEvento.getListaPatrocinadores());
		result.include("evento", dbEvento);
	}

	@Get("/{evento.id}/index")
	public void indexEvento(Evento evento) {
		result.include("evento", eventoRepostorio.load(evento.getId()));
	}

	@Get("/{evento.id}/abrirevento")
	public void abrir(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setStatus(true);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).list();
	}

	@Get("/{evento.id}/fecharevento")
	public void fechar(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setStatus(false);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).list();
	}
	
	@Get("/{evento.id}/finalizarevento")
	public void finalizar(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setFinalizado(true);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).list();
	}

}

package br.com.fipgati.eventos.web.controllers;

import java.text.ParseException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Minicurso;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.MinicursoRepositorio;
import br.com.fipgati.eventos.domain.util.DataUtil;

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
	
	@Get("/evento/gerenciar/{evento.id}/newmini")
	public Minicurso newMinicurso(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Minicurso();
	}
	
	@Post("/evento/gerenciar/new/minicurso")
	public void create(Minicurso minicurso, Evento evento, String data, String hora) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.addMinicurso(minicurso);
		try {
			minicurso.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		validator.onErrorRedirectTo(this).newMinicurso(dbEvento);
		minicursoRepositorio.save(minicurso);
		result.redirectTo(this).list(dbEvento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/minicursos")
	public void list(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("minicursoList", dbEvento.getListaMinicursos());
		result.include("evento", dbEvento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/minicurso/delete/{minicurso.id}")
	public void destroy(Evento evento, Minicurso minicurso) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.removeMinicurso(minicursoRepositorio.load(minicurso.getId()));
		eventoRepostorio.update(dbEvento);
		minicursoRepositorio.delete(minicursoRepositorio.load(minicurso.getId()));
		result.redirectTo(this).list(evento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/minicurso/edit/{minicurso.id}")
	public Minicurso edit(Evento evento, Minicurso minicurso) {
		result.include("action", "edit");
		result.include("evento", eventoRepostorio.load(evento.getId()));
		return minicursoRepositorio.load(minicurso.getId());
	}
	
	@Put("/evento/gerenciar/minicurso/edit")
	public void update(Evento evento, Minicurso minicurso, String hora, String data) {
		Minicurso dbMinicurso = this.minicursoRepositorio.load(minicurso.getId());
		dbMinicurso.setTema(minicurso.getTema());
		dbMinicurso.setPalestrante(minicurso.getPalestrante());
		dbMinicurso.setLocal(minicurso.getLocal());
		dbMinicurso.setPrecoMinicurso(minicurso.getPrecoMinicurso());
		dbMinicurso.setVagas(minicurso.getVagas());
		dbMinicurso.setDescricao(minicurso.getDescricao());
		try {
			dbMinicurso.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minicursoRepositorio.update(dbMinicurso);
		result.redirectTo(this).list(evento);
	}
	
	@Get("/{evento.id}/minicursos")
	public void indexMinicurso(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("minicursoList", dbEvento.getListaMinicursos());
		result.include("evento", dbEvento);
	}
	
	@Get("/{evento.id}/gerenciar/{minicurso.id}/participantes")
	public void listaParticipantes(Evento evento, Minicurso minicurso){
		Minicurso dbMinicurso = minicursoRepositorio.load(minicurso.getId());
		result.include("participanteList", dbMinicurso.getListaInscritosMinicurso());
		result.include("minicurso", dbMinicurso);
		result.include("evento", eventoRepostorio.load(evento.getId()));
	}

}

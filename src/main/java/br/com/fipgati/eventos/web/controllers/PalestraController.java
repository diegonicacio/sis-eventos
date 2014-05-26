package br.com.fipgati.eventos.web.controllers;

import java.text.ParseException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Palestra;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.PalestraRepositorio;
import br.com.fipgati.eventos.domain.util.DataUtil;
import br.com.fipgati.eventos.web.interceptors.Auth;

@Resource
public class PalestraController {
	
	private Result result;
	private PalestraRepositorio palestraRepositorio;
	private EventoRepostorio eventoRepostorio;
	private Validator validator;
	
	public PalestraController(Result result, PalestraRepositorio palestraRepositorio, EventoRepostorio eventoRepostorio, Validator validator) {
		this.result = result;
		this.palestraRepositorio = palestraRepositorio;
		this.eventoRepostorio = eventoRepostorio;
		this.validator = validator;
	}
	
	@Auth
	@Get("/evento/gerenciar/{evento.id}/newpales")
	public Palestra newPalestra(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		System.out.println("Ta passando por aqui");
		return new Palestra();
	}
	
	@Auth
	@Post("/evento/gerenciar/new/palestra")
	public void create(Palestra palestra, Evento evento, String data, String hora) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.addPalestra(palestra);
		try {
			palestra.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validator.onErrorRedirectTo(this).newPalestra(dbEvento);
		palestraRepositorio.save(palestra);
		result.redirectTo(this).list(dbEvento);
	}
	
	@Get("/evento/gerenciar/{evento.id}/palestras")
	public void list(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("palestraList", dbEvento.getListaPalestras());
		result.include("evento", dbEvento);
	}
	
	@Auth
	@Get("/evento/gerenciar/{evento.id}/palestra/delete/{palestra.id}")
	public void destroy(Evento evento, Palestra palestra) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.removePalestra(palestraRepositorio.load(palestra.getId()));
		eventoRepostorio.update(dbEvento);
		palestraRepositorio.delete(palestraRepositorio.load(palestra.getId()));
		result.redirectTo(this).list(evento);
	}
	
	@Auth
	@Get("/evento/gerenciar/{evento.id}/palestra/edit/{palestra.id}")
	public Palestra edit(Evento evento, Palestra palestra) {
		result.include("action", "edit");
		result.include("evento", eventoRepostorio.load(evento.getId()));
		return palestraRepositorio.load(palestra.getId());
	}
	
	@Auth
	@Put("/evento/gerenciar/palestra/edit")
	public void update(Evento evento, Palestra palestra, String hora, String data) {
		Palestra dbPalestra = this.palestraRepositorio.load(palestra.getId());
		dbPalestra.setTema(palestra.getTema());
		dbPalestra.setPalestrante(palestra.getPalestrante());
		dbPalestra.setLocal(palestra.getLocal());
		dbPalestra.setPrecoMinicurso(palestra.getPrecoMinicurso());
		dbPalestra.setVagas(palestra.getVagas());
		dbPalestra.setDescricao(palestra.getDescricao());
		try {
			dbPalestra.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		palestraRepositorio.update(dbPalestra);
		result.redirectTo(this).list(evento);
	}
	
	@Auth
	@Get("/{evento.id}/palestras")
	public void indexPalestra(Evento evento){
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("palestraList", dbEvento.getListaPalestras());
		result.include("evento", dbEvento);
	}
	
	@Auth
	@Get("/{evento.id}/gerenciar/{palestra.id}/participantess")
	public void listaParticipantes(Evento evento, Palestra palestra){
		Palestra dbPalestra = palestraRepositorio.load(palestra.getId());
		result.include("participanteList", dbPalestra.getListaInscritosMinicurso());
		result.include("palestra", dbPalestra);
		result.include("evento", eventoRepostorio.load(evento.getId()));
	}

}

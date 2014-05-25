package br.com.fipgati.eventos.web.controllers;

import java.util.List;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Minicurso;
import br.com.fipgati.eventos.domain.model.Palestra;
import br.com.fipgati.eventos.domain.model.Participante;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.PalestraRepositorio;
import br.com.fipgati.eventos.domain.repositorio.ParticipanteRepositorio;
import br.com.fipgati.eventos.domain.repositorio.MinicursoRepositorio;

@Resource
public class ParticipanteController {

	private EventoRepostorio eventoRepostorio;
	private ParticipanteRepositorio participanteRepositorio;
	private Result result;
	private MinicursoRepositorio minicursoRepositorio;
	private PalestraRepositorio palestraRepositorio;
	
	public ParticipanteController(EventoRepostorio eventoRepostorio, ParticipanteRepositorio participanteRepositorio, Result result, MinicursoRepositorio minicursoRepositorio, PalestraRepositorio palestraRepositorio) {
	
		this.eventoRepostorio = eventoRepostorio;
		this.participanteRepositorio = participanteRepositorio;
		this.result = result;
		this.minicursoRepositorio = minicursoRepositorio;
		this.palestraRepositorio = palestraRepositorio;
	}
	
	@Get("/{evento.id}/inscricao")
	public Evento newInscricao(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		Hibernate.initialize(dbEvento);
		result.include("minicursoList", dbEvento.getListaMinicursos());
		return dbEvento;
	}

	@Post
	public void salvaInscricao(Evento evento, Participante participante, List<Minicurso> minicursoList, List<Palestra> palestraList) {
		participanteRepositorio.save(participante);
		for (int i = 0; i < minicursoList.size(); i++) {
			Minicurso dbMinicurso = minicursoRepositorio.load(minicursoList.get(i).getId());
			dbMinicurso.adicionarInscrito(participante);
		}
		for (int i = 0; i < palestraList.size(); i++) {
			Palestra dbPalestra = palestraRepositorio.load(palestraList.get(i).getId());
			dbPalestra.adicionarInscrito(participante);
		}
		result.redirectTo(EventoController.class).indexEvento(evento);
	}
	
}

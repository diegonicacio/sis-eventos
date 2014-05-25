package br.com.fipgati.eventos.web.controllers;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Participante;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.util.ArquivoUtil;
import br.com.fipgati.eventos.domain.util.DataUtil;

@Resource
public class EventoController {

	private ArquivoUtil arquivoUtil;
	private EventoRepostorio eventoRepostorio;
	private Result result;
	private Validator validator;

	public EventoController(EventoRepostorio eventoRepostorio, Result result, Validator validator, ArquivoUtil arquivoUtil) {
		// TODO Auto-generated constructor stub
		this.eventoRepostorio = eventoRepostorio;
		this.result = result;
		this.validator = validator;
		this.arquivoUtil = arquivoUtil;
	}

	@Path("/")
	public void index() {
		result.include("eventoList", eventoRepostorio.listAll());
	}

	@Get("/evento/new")
	public Evento newEvento() {
		result.include("action", "new");
		return new Evento();
	}

	@Post("/evento/evento")
	public void create(Evento evento, String data, String hora) {
		try {
			evento.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eventoRepostorio.save(evento);
		// arquivoUtil.salva(foto, "/eventos/fotos");
		result.redirectTo(this).index();
	}

	@Get("/evento/{evento.id}/edit")
	public Evento edit(Evento evento) {
		result.include("action", "edit");
		return eventoRepostorio.load(evento.getId());
	}

	// Ajeitar serDatainicio
	@Put("/eventoedit/evento")
	public void update(Evento evento, String hora, String data) {
		System.out.println(evento.getId());
		Evento dbEvento = this.eventoRepostorio.load(evento.getId());
		dbEvento.setAbreviacao(evento.getAbreviacao());
		dbEvento.setNome(evento.getNome());
		dbEvento.setLocal(evento.getLocal());
		dbEvento.setPreco(evento.getPreco());
		dbEvento.setVagas(evento.getVagas());
		dbEvento.setDescricao(evento.getDescricao());
		dbEvento.setDescricao2(evento.getDescricao2());
		try {
			dbEvento.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Get("/evento/gerenciar/{evento.id}")
	public void gerenciaEvento(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		result.include("evento", dbEvento);
		result.redirectTo(MinicursoController.class).list(dbEvento);
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
		result.redirectTo(this).index();
	}

	@Get("/{evento.id}/fecharevento")
	public void fechar(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setStatus(false);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Get("/{evento.id}/finalizarevento")
	public void finalizar(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setFinalizado(true);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Get("/evento/{evento.id}/delete")
	public void destroy(Evento evento) {
		eventoRepostorio.delete(eventoRepostorio.load(evento.getId()));
		result.redirectTo(this).index();
	}

}

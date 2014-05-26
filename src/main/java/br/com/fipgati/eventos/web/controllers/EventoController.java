package br.com.fipgati.eventos.web.controllers;

import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.util.ArquivoUtil;
import br.com.fipgati.eventos.domain.util.DataUtil;
import br.com.fipgati.eventos.web.interceptors.Auth;

@Resource
public class EventoController {

	private ArquivoUtil arquivoUtil;
	private EventoRepostorio eventoRepostorio;
	private Result result;
	private Validator validator;
	private ServletContext context;

	public EventoController(EventoRepostorio eventoRepostorio, Result result, Validator validator, ArquivoUtil arquivoUtil, ServletContext context) {
		// TODO Auto-generated constructor stub
		this.eventoRepostorio = eventoRepostorio;
		this.result = result;
		this.validator = validator;
		this.arquivoUtil = arquivoUtil;
		this.context = context;

	}

	@Path("/")
	public void index() {
		result.include("eventoList", eventoRepostorio.listAll());
	}

	@Auth
	@Get("/evento/new")
	public Evento newEvento() {
		result.include("action", "new");
		return new Evento();
	}

	@Auth
	@Post("/evento/evento")
	public void create(Evento evento, String data, String hora, List<UploadedFile> files) {
		try {
			evento.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (files != null) {
			evento.setImagens(true);
			for (int i = 0; i < files.size(); i++) {
				arquivoUtil.salva(files.get(i), context.getRealPath("/arquivos"), String.valueOf(evento.getNome()) + i + ".jpg");
			}
		}
		eventoRepostorio.save(evento);
		result.redirectTo(this).index();
	}

	@Auth
	@Get("/evento/{evento.id}/edit")
	public Evento edit(Evento evento) {
		result.include("action", "edit");
		return eventoRepostorio.load(evento.getId());
	}

	@Auth
	@Put("/eventoedit/evento")
	public void update(Evento evento, String hora, String data, List<UploadedFile> files) {
		System.out.println(evento.getId());
		Evento dbEvento = this.eventoRepostorio.load(evento.getId());
		dbEvento.setAbreviacao(evento.getAbreviacao());
		dbEvento.setNome(evento.getNome());
		dbEvento.setLocal(evento.getLocal());
		dbEvento.setPreco(evento.getPreco());
		dbEvento.setVagas(evento.getVagas());
		dbEvento.setDescricao(evento.getDescricao());
		dbEvento.setDescricao2(evento.getDescricao2());
		if (files != null) {
			evento.setImagens(true);
			for (int i = 0; i < files.size(); i++) {
				arquivoUtil.salva(files.get(i), context.getRealPath("/arquivos"), String.valueOf(evento.getNome()) + i + ".jpg");
			}
		}
		try {
			dbEvento.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Auth
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

	@Auth
	@Get("/{evento.id}/abrirevento")
	public void abrir(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setStatus(true);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Auth
	@Get("/{evento.id}/fecharevento")
	public void fechar(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setStatus(false);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Auth
	@Get("/{evento.id}/finalizarevento")
	public void finalizar(Evento evento) {
		Evento dbEvento = eventoRepostorio.load(evento.getId());
		dbEvento.setFinalizado(true);
		eventoRepostorio.update(dbEvento);
		result.redirectTo(this).index();
	}

	@Auth
	@Get("/evento/{evento.id}/delete")
	public void destroy(Evento evento) {
		eventoRepostorio.delete(eventoRepostorio.load(evento.getId()));
		result.redirectTo(this).index();
	}

}

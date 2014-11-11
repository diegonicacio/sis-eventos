package br.com.fipgati.eventos.web.controllers;

import java.text.ParseException;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(EventoController.class);
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
    public void create(Evento evento, String data, String hora, UploadedFile capa, UploadedFile frame, UploadedFile carrosel) {
        try {
            evento.setDataInicio(DataUtil.stringToCalendar(data + " " + hora));
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        eventoRepostorio.save(evento);
        Evento dbEvento = eventoRepostorio.load(evento.getId());
        String path = context.getRealPath("/arquivos");
        StringBuilder sb;

        if (capa != null) {
            evento.setCapa(true);
            sb = new StringBuilder();
            sb.append(dbEvento.getId()).append("capa.jpg");
            System.out.println(sb.toString());
            System.out.println(path + sb.toString());
            arquivoUtil.salva(capa, path, sb.toString());
        }

        if (frame != null) {
            evento.setFrame(true);
            sb = new StringBuilder();
            sb.append(dbEvento.getId()).append("frame.jpg");
            System.out.println(sb.toString());
            System.out.println(path + sb.toString());
            arquivoUtil.salva(frame, path, sb.toString());
        }

        if (carrosel != null) {
            evento.setCarrosel(true);
            sb = new StringBuilder();
            sb.append(dbEvento.getId()).append("carrosel.jpg");
            System.out.println(sb.toString());
            System.out.println(path + sb.toString());
            arquivoUtil.salva(carrosel, path, sb.toString());
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
    public void update(Evento evento, String hora, String data, UploadedFile capa, UploadedFile frame, UploadedFile carrosel) {

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
            logger.error(e.getMessage());
        }

        // String path = context.getRealPath("/arquivos");
        // StringBuilder sb;

        // if (capa != null) {
        // evento.setCapa(true);
        // sb = new StringBuilder();
        // sb.append(dbEvento.getId()).append("capa.jpg");
        // arquivoUtil.salva(capa, path, sb.toString());
        // } else {
        // dbEvento.setCapa(false);
        // }
        //
        // if (frame != null) {
        // evento.setFrame(true);
        // sb = new StringBuilder();
        // sb.append(dbEvento.getId()).append("frame.jpg");
        // arquivoUtil.salva(frame, path, sb.toString());
        // } else {
        // dbEvento.setFrame(false);
        // }
        //
        // if (carrosel != null) {
        // evento.setCarrosel(true);
        // sb = new StringBuilder();
        // sb.append(dbEvento.getId()).append("carrosel.jpg");
        // arquivoUtil.salva(carrosel, path, sb.toString());
        // } else {
        // dbEvento.setCarrosel(false);
        // }

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

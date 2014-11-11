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
import br.com.fipgati.eventos.web.interceptors.Auth;

@Resource
public class ParticipanteController {

    private EventoRepostorio eventoRepostorio;
    private ParticipanteRepositorio participanteRepositorio;
    private Result result;
    private MinicursoRepositorio minicursoRepositorio;
    private PalestraRepositorio palestraRepositorio;

    public ParticipanteController(EventoRepostorio eventoRepostorio, ParticipanteRepositorio participanteRepositorio, Result result,
            MinicursoRepositorio minicursoRepositorio, PalestraRepositorio palestraRepositorio) {

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
        result.include("palestraList", dbEvento.getListaPalestras());
        return dbEvento;
    }

    @Post
    public void salvaInscricao(Evento evento, Participante participante, List<Minicurso> minicursoList, List<Palestra> palestraList) {
        participanteRepositorio.save(participante);
        Evento dbEvento = eventoRepostorio.load(evento.getId());
        dbEvento.adicionarInscrito(participante);

        if (!(minicursoList == null || minicursoList.size() == 0)) {
            for (int i = 0; i < minicursoList.size(); i++) {
                Minicurso dbMinicurso = minicursoRepositorio.load(minicursoList.get(i).getId());
                dbMinicurso.adicionarInscrito(participante);
            }
        }

        if (!(palestraList == null || palestraList.size() == 0)) {
            for (int i = 0; i < palestraList.size(); i++) {
                Palestra dbPalestra = palestraRepositorio.load(palestraList.get(i).getId());
                dbPalestra.adicionarInscrito(participante);
            }
        }
        result.redirectTo(EventoController.class).indexEvento(evento);
    }

    @Get("/evento/{evento.id}/todosinscritos")
    public void participantesAll(Evento evento) {
        Evento dbEvento = eventoRepostorio.load(evento.getId());
        result.include("participantesList", dbEvento.getListaInscritos());
    }

    @Auth
    @Get("/evento/{evento.id}/minicurso/{minicurso.id}/participante/{participante.id}/deleteminicurso")
    public void destroyMinicurso(Evento evento, Minicurso minicurso, Participante participante) {
        Participante dbParticipante = participanteRepositorio.load(participante.getId());

        Minicurso dbMinicurso = minicursoRepositorio.load(minicurso.getId());
        dbMinicurso.removerInscrito(dbParticipante);
        minicursoRepositorio.update(dbMinicurso);
        result.redirectTo(MinicursoController.class).listaParticipantes(evento, dbMinicurso);

    }

    @Auth
    @Get("/evento/{evento.id}/minicurso/{palestra.id}/participante/{participante.id}/deletepalestra")
    public void destroyPalestra(Evento evento, Palestra palestra, Participante participante) {
        Participante dbParticipante = participanteRepositorio.load(participante.getId());

        Palestra dbPalestra = palestraRepositorio.load(palestra.getId());
        dbPalestra.removerInscrito(dbParticipante);
        palestraRepositorio.update(dbPalestra);
        result.redirectTo(PalestraController.class).listaParticipantes(evento, dbPalestra);

    }

}

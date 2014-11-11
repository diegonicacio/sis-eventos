package br.com.fipgati.eventos.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.AtLeast;
import org.mockito.internal.verification.Times;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.util.ArquivoUtil;

public class EventoControllerTest {

    @Mock
    private EventoRepostorio eventoRepostorio;
    @Mock
    private Result result;
    @Mock
    private Validator validator;
    @Mock
    private ServletContext context;
    @Mock
    private ArquivoUtil arquivoUtil;

    private EventoController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        result = new MockResult();
        validator = new MockValidator();
        controller = new EventoController(eventoRepostorio, result, validator, arquivoUtil, context);
    }

    private Evento criarEvento() {
        Evento evento = new Evento();
        evento.setId(1L);
        evento.setAbreviacao("SITI");
        evento.setNome("Semana interna");
        evento.setLocal("FIP");
        evento.setStatus(true);
        evento.setVagas(50);
        return evento;

    }

    @Test
    public void deveriaListarEventos() {
        List<Evento> eventos = new ArrayList<Evento>();
        Mockito.when(eventoRepostorio.listAll()).thenReturn(eventos);
        controller.index();
        Assert.assertTrue("Deveria listar eventos na index", result.included().containsKey("eventoList"));

    }

    @Test
    public void deveriaDeletarEvento() {
        Evento evento = criarEvento();
        controller.destroy(evento);
        Mockito.verify(eventoRepostorio).delete(Mockito.any(Evento.class));
    }

    @Test
    public void deveriaCriarEvento() {
        Evento evento = criarEvento();
        controller.create(evento, "01/01/2001", "08:41 PM", null, null, null);
        Mockito.verify(eventoRepostorio, new Times(2)).save(Mockito.any(Evento.class));
    }

}

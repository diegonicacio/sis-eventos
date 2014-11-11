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

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.model.Palestra;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.PalestraRepositorio;
import br.com.fipgati.eventos.domain.util.ArquivoUtil;

public class PalestraControllerTest {

    @Mock
    private Result result;
    @Mock
    private PalestraRepositorio palestraRepositorio;
    @Mock
    private EventoRepostorio eventoRepostorio;
    @Mock
    private Validator validator;
    @Mock
    private ServletContext context;
    @Mock
    private ArquivoUtil arquivoUtil;
    private Evento evento;

    private PalestraController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        result = new MockResult();
        validator = new MockValidator();
        controller = new PalestraController(result, arquivoUtil, palestraRepositorio, eventoRepostorio, validator, context);
        evento = new Evento();
        evento.setId(1L);
    }

    public Palestra criarPalestra() {
        Palestra palestra = new Palestra();
        palestra.setId(1L);
        palestra.setLocal("FIP");
        palestra.setTema("ANDROID");
        return palestra;

    }

    @Test
    public void deveriaListarPalestra() {
        List<Palestra> palestras = new ArrayList<Palestra>();
        Mockito.when(palestraRepositorio.listAll()).thenReturn(palestras);
        controller.indexPalestra(evento);
        Assert.assertTrue("Deveria listar palestras na index", result.included().containsKey("palestraList"));

    }

    @Test
    public void deveriaDeletarPalestra() {
        Palestra palestra = criarPalestra();
        controller.destroy(evento, palestra);
        Mockito.verify(palestraRepositorio).delete(Mockito.any(Palestra.class));
    }

    @Test
    public void deveriaCriarPalestra() {
        Palestra palestra = criarPalestra();
        controller.create(palestra, evento, "01/01/2001", "08:40 PM", null);
        Mockito.verify(palestraRepositorio).save(Mockito.any(Palestra.class));
    }

}

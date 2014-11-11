package br.com.fipgati.eventos.web.controllers;

import static org.junit.Assert.fail;

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
import br.com.fipgati.eventos.domain.model.Minicurso;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;
import br.com.fipgati.eventos.domain.repositorio.MinicursoRepositorio;
import br.com.fipgati.eventos.domain.util.ArquivoUtil;

public class MinicursoControllerTest {

    @Mock
    private Result result;
    @Mock
    private MinicursoRepositorio minicursoRepositorio;
    @Mock
    private EventoRepostorio eventoRepostorio;
    @Mock
    private Validator validator;
    @Mock
    private ServletContext context;
    @Mock
    private ArquivoUtil arquivoUtil;
    private Evento evento;

    private MinicursoController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        result = new MockResult();
        validator = new MockValidator();
        controller = new MinicursoController(result, arquivoUtil, minicursoRepositorio, eventoRepostorio, validator, context);
        evento = new Evento();
        evento.setId(1L);
    }

    public Minicurso criarMinicurso() {
        Minicurso minicurso = new Minicurso();
        minicurso.setId(1L);
        minicurso.setLocal("FIP");
        minicurso.setTema("ANDROID");
        return minicurso;

    }

    @Test
    public void deveriaListarMinicurso() {
        List<Minicurso> minicursos = new ArrayList<Minicurso>();
        Mockito.when(minicursoRepositorio.listAll()).thenReturn(minicursos);
        controller.indexMinicurso(evento);
        Assert.assertTrue("Deveria listar minicursos na index", result.included().containsKey("minicursoList"));

    }

    @Test
    public void deveriaDeletarMinicurso() {
        Minicurso minicurso = criarMinicurso();
        controller.destroy(evento, minicurso);
        Mockito.verify(minicursoRepositorio).delete(Mockito.any(Minicurso.class));
    }

    @Test
    public void deveriaCriarMinicurso() {
        Minicurso minicurso = criarMinicurso();
        controller.create(minicurso, evento, "01/01/2001", "08:40 PM", null);
        Mockito.verify(minicursoRepositorio).save(Mockito.any(Minicurso.class));
    }

}

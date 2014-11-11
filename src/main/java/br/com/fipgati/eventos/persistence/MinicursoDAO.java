package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Minicurso;
import br.com.fipgati.eventos.domain.repositorio.MinicursoRepositorio;

@Component
public class MinicursoDAO extends GenericDAO<Minicurso> implements MinicursoRepositorio {

    public MinicursoDAO(Session session) {
        super(Minicurso.class, session);
    }
}

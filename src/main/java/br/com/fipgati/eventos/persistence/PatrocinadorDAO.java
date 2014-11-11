package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Patrocinador;
import br.com.fipgati.eventos.domain.repositorio.PatrocinadorRepositorio;

@Component
public class PatrocinadorDAO extends GenericDAO<Patrocinador> implements PatrocinadorRepositorio {

    public PatrocinadorDAO(Session session) {
        super(Patrocinador.class, session);
    }

}

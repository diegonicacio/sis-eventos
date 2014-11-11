package br.com.fipgati.eventos.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fipgati.eventos.domain.model.Evento;
import br.com.fipgati.eventos.domain.repositorio.EventoRepostorio;

@Component
public class EventoDAO extends GenericDAO<Evento> implements EventoRepostorio {

    public EventoDAO(Session session) {
        super(Evento.class, session);
    }

}

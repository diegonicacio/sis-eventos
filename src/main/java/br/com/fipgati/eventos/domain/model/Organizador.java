package br.com.fipgati.eventos.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Organizador {
	
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String senha;
	@ManyToMany
	private List<Evento> eventos;
	private boolean masterAdmin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public boolean isMasterAdmin() {
		return masterAdmin;
	}
	public void setMasterAdmin(boolean masterAdmin) {
		this.masterAdmin = masterAdmin;
	}
	
	

}

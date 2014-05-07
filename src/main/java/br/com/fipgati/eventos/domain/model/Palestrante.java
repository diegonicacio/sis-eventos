package br.com.fipgati.eventos.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Palestrante {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String formacao;
	private String artigosPublicados;
	private String ocupacao;

	public Palestrante(String nome) {
		this.nome = nome;
	}
	
	public Palestrante() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getArtigosPublicados() {
		return artigosPublicados;
	}

	public void setArtigosPublicados(String artigosPublicados) {
		this.artigosPublicados = artigosPublicados;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

}

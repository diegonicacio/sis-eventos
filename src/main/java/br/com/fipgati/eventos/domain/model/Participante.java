package br.com.fipgati.eventos.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Participante {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String ocupacao;
	@ManyToMany
	private List<Minicurso> listaMinicurso;
	@ManyToMany
	private List<Palestra> listaPalestras;
	private boolean pagou;

	public Participante(String nome) {
		listaPalestras = new ArrayList<Palestra>();
		listaMinicurso = new ArrayList<Minicurso>();
		this.pagou = false;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionarMinicurso(Minicurso minicurso) {
		this.listaMinicurso.add(minicurso);
	}

	public void adicionarPalestra(Palestra palestra) {
		this.listaPalestras.add(palestra);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public boolean isPagou() {
		return pagou;
	}

	public void setPagou(boolean pagou) {
		this.pagou = pagou;
	}

	public List<Minicurso> getListaMinicurso() {
		return listaMinicurso;
	}

	public List<Palestra> getListaPalestras() {
		return listaPalestras;
	}

}

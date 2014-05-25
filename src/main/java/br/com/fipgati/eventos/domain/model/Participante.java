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
	@ManyToMany(mappedBy = "listaInscritosMinicurso")
	List<Minicurso> minicursos;
	@ManyToMany(mappedBy = "listaInscritosPalestra")
	List<Palestra> palestras;
	private String rg;
	private boolean pagou;

	public Participante() {
		minicursos = new ArrayList<Minicurso>();
		palestras = new ArrayList<Palestra>();
		pagou = true;
	}

	public void addMinicurso(Minicurso minicusro) {
		this.minicursos.add(minicusro);
	}

	public void addPalestra(Palestra palestra) {
		this.palestras.add(palestra);
	}

	public void delMinicurso(Minicurso minicurso) {
		this.minicursos.remove(minicurso);
	}

	public void delPalestra(Palestra palestra) {
		this.palestras.remove(palestra);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

}

package br.com.fipgati.eventos.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Minicurso {

	@Id
	@GeneratedValue
	private Long id;
	private String tema;
	@ManyToOne
	private Palestrante palestrante;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFinal;
	private BigDecimal precoMinicurso;
	private int vagas;
	@ManyToMany
	private List<Participante> listaInscritosMinicurso;

	public Minicurso(String tema, Palestrante palestrante) {
		listaInscritosMinicurso = new ArrayList<Participante>();

		this.tema = tema;
		this.palestrante = palestrante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionarInscrito(Participante inscrito) {
		this.listaInscritosMinicurso.add(inscrito);
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public BigDecimal getPrecoMinicurso() {
		return precoMinicurso;
	}

	public void setPrecoMinicurso(BigDecimal precoMinicurso) {
		this.precoMinicurso = precoMinicurso;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public List<Participante> getListaInscritosMinicurso() {
		return listaInscritosMinicurso;
	}

}

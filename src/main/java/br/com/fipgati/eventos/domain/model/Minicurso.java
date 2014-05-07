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
	private String palestrante;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFinal;
	private BigDecimal precoMinicurso;
	private int vagas;
	@ManyToMany
	private List<Participante> listaInscritosMinicurso;
	private String descricao;

	public Minicurso() {
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
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

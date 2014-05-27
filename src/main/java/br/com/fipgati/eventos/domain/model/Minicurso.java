package br.com.fipgati.eventos.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe modelo responsavel por representar a entidade Minicurso.
 * 
 * @author Diego
 * 
 * @version 0.1
 * 
 * @see Palestrante
 *
 */
@Entity
public class Minicurso {

	@Id
	@GeneratedValue
	private Long id;
	private String tema;
	private String palestrante;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	private BigDecimal precoMinicurso;
	private int vagas;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Participante> listaInscritosMinicurso;
	@Column(length = 100000)
	private String descricao;

	private boolean capa;

	public boolean isCapa() {
		return capa;
	}

	public void setCapa(boolean capa) {
		this.capa = capa;
	}

	private String local;

	public Minicurso() {
		
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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
	
	public void removerInscrito(Participante participante){
		this.listaInscritosMinicurso.remove(participante);
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

package br.com.fipgati.eventos.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evento {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name="dataInicio")
	private Calendar dataInicio;
	private String local;
	@OneToMany
	private List<Minicurso> listaMinicursos;
	@OneToMany
	private List<Palestra> listaPalestras;
	private BigDecimal preco;
	@ManyToMany
	private List<Patrocinador> listaPatrocinadores;
	private int vagas;
	@OneToMany
	private List<Participante> listaInscritos;

	public Evento(String nome, Calendar data) {
		listaMinicursos = new ArrayList<Minicurso>();
		listaPalestras = new ArrayList<Palestra>();
		listaPatrocinadores = new ArrayList<Patrocinador>();
		listaInscritos = new ArrayList<Participante>();

		this.nome = nome;
		dataInicio = data;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionarMinicurso(Minicurso minicurso) {
		this.listaMinicursos.add(minicurso);
	}

	public void adicionarPalestra(Palestra palestra) {
		this.listaPalestras.add(palestra);
	}

	public void adicionarPatrocinador(Patrocinador patrocinador) {
		this.listaPatrocinadores.add(patrocinador);
	}

	public void adicionarInscrito(Participante inscrito) {
		this.listaInscritos.add(inscrito);
	}

	public List<Minicurso> getListaMinicursos() {
		return listaMinicursos;
	}

	public List<Palestra> getListaPalestras() {
		return listaPalestras;
	}

	public List<Patrocinador> getListaPatrocinadores() {
		return listaPatrocinadores;
	}

	public List<Participante> getListaInscritos() {
		return listaInscritos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

}

package com.bruno.desafio2.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Double preco;
	
	@OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name = "tb_atividade_participante",
	   		   joinColumns = @JoinColumn(name = "atividade_id"),
	   		   inverseJoinColumns = @JoinColumn(name = "participante_id"))
	
	private Set<Participante> participantes = new HashSet<>();
	
	public Atividade() {		
	}

	public Atividade(Integer id, String nome, String email, String descricao, Double preco, Categoria categoria, Set<Bloco> blocos, Set<Participante> participantes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.blocos = blocos;
		this.participantes = participantes;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Bloco> getBlocos() {
		return blocos;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}
	
	
	
    

	
	

	
	

	
	
	
	
	

}

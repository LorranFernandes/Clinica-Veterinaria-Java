package br.cefet.clinicaveterinaria.model;

public class Veterinario {
	private int id;
	private String nome;
	private String especialidade;
	
	public Veterinario(int id, String nome, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	public Veterinario(int id) {
		super();
		this.id = id;
	}

	public Veterinario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}

package br.cefet.clinicaveterinaria.model;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	private int id;
	private Date data;
	private Time hora;
	private float valor;
	private Animal animal;
	private Veterinario veterinario;
	
	public Consulta(int id, Date data, Time hora, float valor, Animal animal, Veterinario veterinario) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora; 
		this.valor = valor;
		this.animal = animal;
		this.veterinario = veterinario;
	}

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	
}

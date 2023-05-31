package com.curso.model;

public class Curso {

	private int codCurso;
	private String nombre;
	private int duracion;
	private int precio;
	
	public Curso(int codCurso, String nombre, int duracion, int precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	
	public Curso(int codCurso, String nombre, int precio) {
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.precio = precio;
	}


	public Curso() {
		super();
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}

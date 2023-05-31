package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionesServiceImp;

@RestController
public class FormacionesController {

	@Autowired
	FormacionesServiceImp service;
	
	// http://localhost:9090/formacion/
	@PostMapping(value="formacion/{curso}/{asignaturas}/{precio}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void nuevoCurso(
			@PathVariable ("curso") String curso,
			@PathVariable ("asignaturas") int asignaturas,
			@PathVariable ("precio") double precio
			){
		Formacion form = new Formacion (curso, asignaturas, precio);
		service.altaCurso(form);
	}
	
	//http://localhost:9090/formacion
	@GetMapping(value="formacion", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listadoDeCursos(){
		return service.listaCursos();
	}
	
}

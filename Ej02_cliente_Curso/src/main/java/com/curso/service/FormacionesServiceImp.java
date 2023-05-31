package com.curso.service;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionesServiceImp implements FormacionesService {

	@Autowired(required=true)
	RestTemplate template;
	
	private String url = "http://localhost:8080/cursos";
	
	@Override
	public List<Formacion> listaCursos() {
		
		
		List <Formacion> formaciones = new ArrayList<Formacion>();
		List <Curso> cursos= Arrays.asList(template.getForObject(url, Curso[].class));
		
		for(Curso cur: cursos) {
			Formacion form = new Formacion();
			form.setCurso(cur.getNombre());
			form.setPrecio(cur.getPrecio());
			if(cur.getDuracion()>=50) {
				form.setAsignaturas(10);
			}
			else {
				form.setAsignaturas(5);
			}
			formaciones.add(form);
		}
		return formaciones;
	}

	@Override
	public void altaCurso (Formacion form) {
		
		Curso curso = new Curso();
		curso.setDuracion(form.getAsignaturas()*10);
		//curso.setCodCurso(curso.getCodCurso());
		curso.setNombre(form.getCurso());
		curso.setPrecio((int) form.getPrecio());
		
		List<Curso> listaCur = Arrays.asList(template.getForObject(url, Curso[].class));
		for(Curso curso2: listaCur) {
			if(curso2.getNombre().equals(curso.getNombre())) {
				return;
			}
		}
		
		template.postForLocation(url, curso);
		
	}
}

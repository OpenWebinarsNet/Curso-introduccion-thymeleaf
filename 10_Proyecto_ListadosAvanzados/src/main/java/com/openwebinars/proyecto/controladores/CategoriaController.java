	package com.openwebinars.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openwebinars.proyecto.servicios.CategoriaService;

@Controller
@RequestMapping("/admin/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
		
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		return "admin/list-categoria";
	}
			
	

}

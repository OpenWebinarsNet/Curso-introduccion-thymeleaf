package com.openwebinars.primerproyecto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	/*
	 * Creamos un servicio que nos provea de algunos de los objetos que vamos a utilizar
	 */
	@Autowired
	private DummyService service;
	
	@GetMapping({"/", "/welcome"})
	public String welcome(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", nombre);
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", new Date());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores		
		model.addAttribute("producto2", service.getProductoSinAlgunosValores());
		
		return "index";
	}

}

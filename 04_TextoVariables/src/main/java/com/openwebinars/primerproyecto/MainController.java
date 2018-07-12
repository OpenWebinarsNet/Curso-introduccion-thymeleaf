package com.openwebinars.primerproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping({"/", "/welcome"})
	public String welcome(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("saludo", "Un saludo para todos los programadores del mundo");
		model.addAttribute("boton", "Ir a...");
		model.addAttribute("mensaje", "<strong>Sed bienvenidos todos aquellos que tengáis ganas de aprender a desarrollar aplicaciones web usando <em>Thymeleaf</em></strong>");
		return "index";
	}
	
	@GetMapping("/producto/{id}")
	public String verProducto(Model model) {
		Producto producto = new Producto("Camiseta oficial de Openwebinars","¡No puedes dejar de tenerla! Se trata de la camiseta oficial de Openwebinars. Aquella que usan todos los programadores que han aprendido cualquier lenguaje de programación con alguno de nuestros cursos. ¿Te vas a quedar sin ella? Será la moda esta temporada :)",15.0f, 87, 91.1f);
		model.addAttribute("producto", producto);
		return "producto";
	}

}

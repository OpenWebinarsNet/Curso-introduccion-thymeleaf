package com.openwebinars.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openwebinars.proyecto.modelo.Producto;
import com.openwebinars.proyecto.servicios.CategoriaService;
import com.openwebinars.proyecto.servicios.ProductoService;

@Controller
public class MainController {

	private static final int NUM_PRODUCTOS_ALEATORIOS = 8;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProductoService productoService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("categorias", categoriaService.findAll());

		List<Producto> productos;

		productos = productoService.obtenerProductosAleatorios(NUM_PRODUCTOS_ALEATORIOS);

		model.addAttribute("productos", productos);

		return "index";
	}

}

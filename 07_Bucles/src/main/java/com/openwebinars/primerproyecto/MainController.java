package com.openwebinars.primerproyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	private DummyService service;
	
	@GetMapping({"/", "/list"})
	public String list(@RequestParam(name="iterstat", required=false, defaultValue="no") String iterstat, Model model) {
		model.addAttribute("productos", service.getLista());
		if (iterstat.equalsIgnoreCase("no"))
			return "index";
		else
			return "index-stat";
	}
	
	@GetMapping({"/array"})
	public String array(Model model) {
		model.addAttribute("productos", service.getArray());		
		return "index";
	}
	
	@GetMapping({"/collection"})
	public String collection(Model model) {	
		model.addAttribute("productos", service.getCollection());		
		return "index";
	}

	@GetMapping({"/set"})
	public String set(Model model) {	
		model.addAttribute("productos", service.getSet());		
		return "index";
	}
	

	@GetMapping({"/map"})
	public String map(Model model) {	
		model.addAttribute("carrito", service.getMap());		
		return "index-map";
	}
	
	

}

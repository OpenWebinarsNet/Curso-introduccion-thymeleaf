package com.openwebinars.primerproyecto;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
	
	private List<Producto> lista;
	
	@PostConstruct
	private void init() {
		lista = Arrays.asList(
				new Producto("Producto 1", "Descripción 1", 1.0f),
				new Producto("Producto 2", "Descripción 2", 2.0f),
				new Producto("Producto 3", "Descripción 3", 3.0f)
				);
	}
	
	public List<Producto> getLista() {
		return lista;
	}
	
	public Producto[] getArray() {
		return (Producto[])(lista.toArray());
	}
	
	public Collection<Producto> getCollection() {
		return lista;
	}
	
	public Set<Producto> getSet() {
		Set<Producto> set = new HashSet<Producto>();
		set.addAll(lista);
		return set;
	}
	
	public Map<Producto, Integer> getMap() {
		Map<Producto, Integer> map = new HashMap<Producto, Integer>();
		
		for(int i=0; i < lista.size();i++) {
			map.put(lista.get(i), i+1);
		}
		
		
		return map;
	}
	
	
	

}

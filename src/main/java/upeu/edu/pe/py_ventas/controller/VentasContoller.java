package upeu.edu.pe.py_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.py_ventas.entity.Ventas;
import upeu.edu.pe.py_ventas.service.VentasService;

@RestController
@RequestMapping("/api/ventas")
public class VentasContoller {
	
	@Autowired
	private VentasService service;
    
	@GetMapping("/all")
	public List<Ventas> readAll(){
		return service.reAll();
	}
	
	@GetMapping("/{id}")
	public Ventas read(@PathVariable int id) {
		return service.read(id);
		
	}
	
	
	@PostMapping("/save")
	public int save(@RequestBody Ventas venta) {
		return service.create(venta);
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Ventas venta) {
		
		Ventas v = service.read(id);
		v.setFecha("2022-09-18");
		return service.update(v);
		
	}
	
	@DeleteMapping(("/del/{id}"))
	public int save(@PathVariable int id){
		return service.delete(id);
	}
		
	
}

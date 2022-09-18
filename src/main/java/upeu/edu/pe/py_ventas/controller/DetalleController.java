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

import upeu.edu.pe.py_ventas.entity.Detalle;
import upeu.edu.pe.py_ventas.service.DetalleService;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {
	@Autowired
	private DetalleService detalleService;
	
	@GetMapping("/all")
	public List<Detalle> readAll(){
		return detalleService.reAll();
	}
	
	@GetMapping("/{id}")
	public Detalle read(@PathVariable int id){
		return detalleService.read(id);
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Detalle detalle) {
		return detalleService.create(detalle);
		
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Detalle detalle){
		
		Detalle d = detalleService.read(id);
		d.setPrecio(200);
		return detalleService.update(detalle);
	}
	
	@DeleteMapping(("/del/{id}"))
	public int save(@PathVariable int id){
		return detalleService.delete(id);
		}
    }

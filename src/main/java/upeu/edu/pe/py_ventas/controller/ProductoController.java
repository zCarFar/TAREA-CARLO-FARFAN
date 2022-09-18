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

import upeu.edu.pe.py_ventas.entity.Producto;
import upeu.edu.pe.py_ventas.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/all")
	public List<Producto> readAll(){
		return productoService.reAll();
	}
	
	@GetMapping("/{id}")
	public Producto read(@PathVariable int id) {
		return productoService.read(id);
	}
	
	@PostMapping("/save")
	public int save (@RequestBody Producto producto) {
		return productoService.create(producto);
		
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Producto producto){
		Producto Prod = productoService.read(id);
		Prod.setNombre("teclado");
		return productoService.update(Prod);
	}
	
	@DeleteMapping(("/del/{id}"))
	public int save(@PathVariable int id) {
		return productoService.delete(id);
		
	}
}

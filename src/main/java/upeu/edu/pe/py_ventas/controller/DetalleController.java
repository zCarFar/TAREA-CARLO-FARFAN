package upeu.edu.pe.py_ventas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.py_ventas.service.DetalleService;

@RestController
@RequestMapping("/api/detalles")
public class DetalleController {
	@Autowired
	private DetalleService detalleService;
	
	@GetMapping("/all")
	public List<Map<String, Object>> readAll(){
		
		return detalleService.readAll2();
	}

}

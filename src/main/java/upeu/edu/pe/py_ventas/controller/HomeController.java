package upeu.edu.pe.py_ventas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HomeController {
	
	@GetMapping("/")
	public String index() {
	return "Bienvenidos a Ventas";
	}
}

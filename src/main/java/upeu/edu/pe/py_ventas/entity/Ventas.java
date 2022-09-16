package upeu.edu.pe.py_ventas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ventas {
	
	private int idventas;
	private String fecha;

}

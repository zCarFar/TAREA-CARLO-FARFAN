package upeu.edu.pe.py_ventas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detalle {
	
	private int iddetalle;
	private int idventas;
	private int idproducto;
	private double precio;
	private double cantidad;
	

}

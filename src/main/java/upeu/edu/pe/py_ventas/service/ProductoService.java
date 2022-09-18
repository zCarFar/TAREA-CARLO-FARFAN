package upeu.edu.pe.py_ventas.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.py_ventas.dao.Operaciones;
import upeu.edu.pe.py_ventas.daoimpl.ProductoDaoimpl;
import upeu.edu.pe.py_ventas.entity.Producto;

@Service
public class ProductoService implements Operaciones<Producto>{
	
	@Autowired
	private ProductoDaoimpl daoimpl;
	
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		return daoimpl.create(t);
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return daoimpl.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daoimpl.delete(id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return daoimpl.read(id);
	}

	@Override
	public List<Producto> reAll() {
		// TODO Auto-generated method stub
		return daoimpl.reAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return daoimpl.readAll2();
	}
	
}

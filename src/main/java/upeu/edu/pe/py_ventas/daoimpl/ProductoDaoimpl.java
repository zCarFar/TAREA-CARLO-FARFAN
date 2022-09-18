package upeu.edu.pe.py_ventas.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.py_ventas.dao.Operaciones;
import upeu.edu.pe.py_ventas.entity.Producto;
@Component
public class ProductoDaoimpl implements Operaciones<Producto> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "INERT INTO producto(nombre, precio, cantidad) VALUES(?,?,?)";
		return jdbcTemplate.update(SQL, t.getNombre(), t.getPrecio(), t.getCantidad());
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "INERT INTO producto(nombre, precio, cantidad) VALUES(?,?,?)";
		return jdbcTemplate.update(SQL, t.getNombre(), t.getPrecio(), t.getCantidad());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM productos WHERE idproductos=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
	try { 
	Producto Prod = jdbcTemplate.queryForObject("SELECT * FROM productos WHERE idproductos=?",
	BeanPropertyRowMapper.newInstance(Producto.class), id);
	return Prod;
		}catch(IncorrectResultSizeDataAccessException e){
			return null;
		}
	}

	@Override
	public List<Producto> reAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM producto",
		BeanPropertyRowMapper.newInstance(Producto.class));
	}
	
	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}

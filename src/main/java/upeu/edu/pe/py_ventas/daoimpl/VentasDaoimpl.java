package upeu.edu.pe.py_ventas.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.py_ventas.dao.Operaciones;
import upeu.edu.pe.py_ventas.entity.Ventas;

@Component
public class VentasDaoimpl implements Operaciones<Ventas> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Ventas t) {
		// TODO Auto-generated method stub
		String SQL ="INSERT INTO ventas(fecha) VALUES(now())";
		return jdbcTemplate.update(SQL);
	}

	@Override
	public int update(Ventas t) {
		// TODO Auto-generated method stub
		String SQL ="UPDATE ventas SET fecha = ? WHERE idventas=?"; 
		return jdbcTemplate.update(SQL, t.getFecha(), t.getIdventas());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM ventas WHERE idventas=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Ventas read(int id) {
		// TODO Auto-generated method stub
		try{
		Ventas v = jdbcTemplate.queryForObject("SELECT * FROM ventas WHERE idventas=?", 
		BeanPropertyRowMapper.newInstance(Ventas.class), id);
		return v;
		}catch(IncorrectResultSizeDataAccessException e) {
			
			return null;
		}
		
	}

	@Override
	public List<Ventas> reAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM ventas",
		BeanPropertyRowMapper.newInstance(Ventas.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	
	}
	

}

package upeu.edu.pe.py_ventas.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.py_ventas.dao.Operaciones;
import upeu.edu.pe.py_ventas.entity.Detalle;

@Component
public class DetalleDaoimpl implements Operaciones<Detalle> {

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		String SQL ="INSERT INTO detalle(idventas, idproducto, precio, cantidad) VALUES(?,?,?)";
		return jdbcTemplate.update(SQL, t.getIdventas(), t.getIdproducto(), t.getPrecio(),t.getCantidad());
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		String SQL="UPDATE detalle SET cantidad = ? WHERE(iddetalle=?)";
		return jdbcTemplate.update(SQL, t.getCantidad(), t.getPrecio(),t.getIddetalle());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL="DELETE FROM detalle WHERE iddetalle = ?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		try {
		Detalle Det = jdbcTemplate.queryForObject("SELECT * FROM detalle WHERE iddetalle=?",
	    BeanPropertyRowMapper.newInstance(Detalle.class), id);
		return Det;
		}catch(IncorrectResultSizeDataAccessException e){
			return null;
		}
		
	}

	@Override
	public List<Detalle> reAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM detalle",
		BeanPropertyRowMapper.newInstance(Detalle.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		String SQL ="SELECT v.idventas, v.fecha, p.idproducto, p.nombre, p.precio, p.cantidad, d.precio, d.cantidad FROM detalle as d"
		+ "inner join ventas as v on d.idventas= v.idventas"
		+ "inner join producto as p on d.idproducto= p.idproducto ";
		return jdbcTemplate.queryForList(SQL);
	}

}

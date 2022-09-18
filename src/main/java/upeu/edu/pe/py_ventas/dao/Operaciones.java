package upeu.edu.pe.py_ventas.dao;

import java.util.List;
import java.util.Map;

public interface Operaciones<T>{
	
	int create(T t);
	int update(T t);
	int delete(int id);
	T read(int id);
    List<T> reAll();
    List<Map<String,Object>> readAll2();
}

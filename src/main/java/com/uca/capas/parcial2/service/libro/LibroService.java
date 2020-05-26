package com.uca.capas.parcial2.service.libro;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;

public interface LibroService {
		
	public List<Libro> getAll() throws DataAccessException;
	
	public void save(Libro libro) throws DataAccessException;

}

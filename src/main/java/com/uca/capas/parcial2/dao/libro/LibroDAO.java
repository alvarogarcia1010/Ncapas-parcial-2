package com.uca.capas.parcial2.dao.libro;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;

public interface LibroDAO 
{
	public List<Libro> getAll() throws DataAccessException;
	
	public void save(Libro libro) throws DataAccessException;

}

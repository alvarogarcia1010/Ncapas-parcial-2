package com.uca.capas.parcial2.service.libro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.libro.LibroDAO;
import com.uca.capas.parcial2.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService 
{
	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> getAll() throws DataAccessException 
	{
		return libroDAO.getAll();
	}
	
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		libroDAO.save(libro);		
	}
	
}

package com.uca.capas.parcial2.dao.categoria;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Categoria;

public interface CategoriaDAO 
{
	public List<Categoria> getAll() throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;

}

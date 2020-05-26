package com.uca.capas.parcial2.service.categoria;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.categoria.CategoriaDAO;
import com.uca.capas.parcial2.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService 
{
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> getAll() throws DataAccessException 
	{
		return categoriaDAO.getAll();
	}
	
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		categoriaDAO.save(categoria);		
	}
	
}

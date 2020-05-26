package com.uca.capas.parcial2.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Categoria> getAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		try {
			if(categoria.getCodigoCategoria() == null) 
			{
				entityManager.persist(categoria);
			}
			else 
			{
				entityManager.merge(categoria);
				entityManager.flush();
			}
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}
}

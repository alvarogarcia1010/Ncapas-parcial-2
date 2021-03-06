package com.uca.capas.parcial2.dao.libro;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Libro> getAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		try {
			if(libro.getCodigoLibro() == null) 
			{
				long millis=System.currentTimeMillis();  
				libro.setFechaIngreso(new Timestamp(Calendar.getInstance().getTime().getTime()));
				entityManager.persist(libro);
			}
			else 
			{
				entityManager.merge(libro);
				entityManager.flush();
			}
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}
}

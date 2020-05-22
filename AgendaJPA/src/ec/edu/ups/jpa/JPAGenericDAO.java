package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.GenericDAO;

public class JPAGenericDAO<T,ID> implements GenericDAO<T, ID> {

	public JPAGenericDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

public class JPATelefonoDAO  extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{

	public JPATelefonoDAO() {
		// TODO Auto-generated constructor stub
		super(Telefono.class);
	}

	@Override
	public List<Telefono> findAllByID(String ID) {
		Usuario usuario = JPADAOFactory.getFactory().getUsuarioDAO().read(ID);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		
		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);
		
		Predicate predicado = criteriaBuilder.equal(telefonoRoot.get("cedulaU"), usuario);
		
		criteriaQuery.select(telefonoRoot).where(predicado);
		
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Telefono> findALLByEmail(String correo) {
		Usuario usuario = JPADAOFactory.getFactory().getUsuarioDAO().finUsuarioByMail(correo);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Telefono> creCriteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		
		Root<Telefono> telefonoRoot = creCriteriaQuery.from(Telefono.class);
		
		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("cedulaU"),usuario);
		
		creCriteriaQuery.select(telefonoRoot).where(predicate);
		
		return em.createQuery(creCriteriaQuery).getResultList();
	}
	
	

}

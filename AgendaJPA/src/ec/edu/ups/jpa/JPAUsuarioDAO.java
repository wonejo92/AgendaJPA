package ec.edu.ups.jpa;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		// TODO Auto-generated constructor stub
		super(Usuario.class);
	}

	@Override
	public Usuario finUsuarioByMail(String correo) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		
		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("correo"), correo);
		
		criteriaQuery.select(usuarioRoot).where(predicate);
		
		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		}catch(NoResultException e) {
			return new Usuario();
		}
		
	}
	
	

}

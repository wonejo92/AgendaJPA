package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		// TODO Auto-generated constructor stub
		super(Usuario.class);
	}

}

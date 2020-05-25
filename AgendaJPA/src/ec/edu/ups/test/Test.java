package ec.edu.ups.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

import org.apache.tomcat.util.buf.UDecoder;

import com.mysql.cj.Query;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.jpa.JPADAOFactory;
import ec.edu.ups.jpa.JPAGenericDAO;
import ec.edu.ups.jpa.JPATelefonoDAO;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(JPADAOFactory.getFactory().getTelefonoDAO().findALLByEmail("kevin12"));
	}
	

}

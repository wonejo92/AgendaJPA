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
import ec.edu.ups.jpa.JPAGenericDAO;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = new Telefono();
		
		
		//Creacion del Usuario.
		
		Usuario usuario = new Usuario();
		//usuarioDAO.create(usuario);
		usuario.setCedula("0105904313");
		usuario.setNombre("Kevin");
		usuario.setApellido("Cordero");
		usuario.setCorreo("kevin12");
		usuario.setContrasena("kevin12");
		//usuarioDAO.create(usuario);
		
		//System.out.println("Sentencia JPQL");
		
		//System.out.println(usuarioDAO.BCedula("0105904312"));
		
		//System.out.println(usuarioDAO.findAll());
		
		
		//System.out.println(usuario.toString());
		
		//Creacion del telefono
		int codigo =1;
		//telefono.setCodigo(codigo);
		telefono.setNumero("0991269100");
		telefono.setTipo("Movil");
		telefono.setOperadora("Claro");
		telefono.setCedulaU(usuario);
		//telefonoDAO.create(telefono);
		//System.out.println(usuario.toString().indexOf(1));
		//telefonoDAO.create(telefono);
		
		telefonoDAO.BCedula("0105904313");
		System.out.println(telefonoDAO.BCedula("0105904313"));
	
		
		
		//System.out.println(telefono.toString());
		
		

		

	}
	

}

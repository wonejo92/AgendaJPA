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
		usuario.setCedula("0105652747");
		usuario.setNombre("Leonardo");
		usuario.setApellido("Alvarado");
		usuario.setCorreo("leo12@hotmail.com");
		usuario.setContrasena("12leonardo");
		
		System.out.println("Sentencia JPQL");
		
		System.out.println(usuarioDAO.BCedula("0105904312"));
		
		//System.out.println(usuarioDAO.findAll());
		
		
		//System.out.println(usuario.toString());
		
		//Creacion del telefono
		int codigo =1;
		//telefono.setCodigo(codigo);
		telefono.setNumero("0979395838");
		telefono.setTipo("Movil");
		telefono.setOperadora("Claro");
		telefono.setCedulaU(usuario);
		//System.out.println(usuario.toString().indexOf(1));
		//telefonoDAO.create(telefono);
		
		
	
		
		
		//System.out.println(telefono.toString());
		
		

		

	}
	

}

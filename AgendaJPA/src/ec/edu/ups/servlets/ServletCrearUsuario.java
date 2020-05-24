package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class ServletCrearUsuario
 */
@WebServlet("/ServletCrearUsuario")
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Usuario usu = new Usuario();
       UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cedula = request.getParameter("cedula");
		System.out.println(cedula);
		String nombre=request.getParameter("nombre");
		System.out.println(nombre);
		String apellido=request.getParameter("apellido");
		System.out.println(apellido);
		String correo=request.getParameter("correo");
		System.out.println(correo);
		String contrasena=request.getParameter("contrasena");
		System.out.println(contrasena);
		
		usu.setCedula(cedula);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setCorreo(correo);
		usu.setContrasena(contrasena);
		System.out.println("Nuevo Usuario: "+usu.toString());
		usuDAO.create(usu);
		String sesion="T";
		
		HttpSession session=request.getSession(true);
		session.setAttribute("cedula", cedula);
		session.setAttribute("sesion", sesion);
		System.out.println("Accediendo a la BD-->");
		request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
		doGet(request, response);
	}

}

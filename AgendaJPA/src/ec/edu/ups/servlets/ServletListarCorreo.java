package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class ServletListarCorreo
 */
@WebServlet("/ServletListarCorreo")
public class ServletListarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
	UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
	Telefono telf = new Telefono();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarCorreo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Se Imprimen los numeros segun el correo.");
		String cedula = request.getParameter("Cedula");
		String correo = request.getParameter("correo");
		System.out.println(correo);
		System.out.println(cedula);
		
		
		List<Telefono>lista=telfDAO.BCorreo(cedula, correo);
		System.out.println(lista);
		request.setAttribute("lst_telefonos", lista);
		
		request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
		doGet(request, response);
	}

}

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
import ec.edu.ups.jpa.JPATelefonoDAO;

/**
 * Servlet implementation class ServletListarCedula
 */
@WebServlet("/ServletListarCedula")
public class ServletListarCedula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Telefono telf;
	private TelefonoDAO telfDAO;
    private Usuario usu;
    private UsuarioDAO usuDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarCedula() {
        super();
        telfDAO=DAOFactory.getFactory().getTelefonoDAO();
        telf = new Telefono();
        usuDAO=DAOFactory.getFactory().getUsuarioDAO();
        usu = new Usuario();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Se Buscara por Cedula.");
		String cedula = request.getParameter("cedula");
		System.out.println(cedula);
		System.out.println("Accediendo a la BD-->");
		
		
		List<Telefono> lista=telfDAO.BCedula(cedula);
		System.out.println(lista);
		
		request.setAttribute("lst_telefonos", lista);
		
		request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
		
		doGet(request, response);
	}

}

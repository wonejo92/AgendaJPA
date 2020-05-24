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
import ec.edu.ups.entidades.Telefono;

/**
 * Servlet implementation class ServletListarTelefonos
 */
@WebServlet("/ServletListarTelefonos")
public class ServletListarTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TelefonoDAO telfDAO= DAOFactory.getFactory().getTelefonoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarTelefonos() {
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
		System.out.println("Se listan todos los telefonos del usuario que se logeo.");
		String cedula=request.getParameter("Cedula");
		System.out.println(cedula);
		
		List<Telefono>lista=telfDAO.BTelefonos(cedula);
		System.out.println(lista);
		request.setAttribute("lst_telefonos", lista);
		request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
		doGet(request, response);
	}

}

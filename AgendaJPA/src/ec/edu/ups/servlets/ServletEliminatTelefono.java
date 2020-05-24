package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;

/**
 * Servlet implementation class ServletEliminatTelefono
 */
@WebServlet("/ServletEliminatTelefono")
public class ServletEliminatTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TelefonoDAO telfDAO =DAOFactory.getFactory().getTelefonoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminatTelefono() {
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
		int codigo =0;
		System.out.println("Se pricede a eliminar el usuario");
		String codigoT = request.getParameter("codigo");
		System.out.println("Accediendo a la BD-->");
		System.out.println(codigoT);
		codigo = Integer.parseInt(codigoT);
		System.out.println(codigo);
	//Se manda buscar antes de eliminar 
		System.out.println(telfDAO.read(codigo));
		Telefono telefonoE=telfDAO.read(codigo);
		telfDAO.delete(telefonoE);
		
		request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
		doGet(request, response);
	}

}

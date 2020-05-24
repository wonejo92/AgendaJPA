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
 * Servlet implementation class ServletLogin
 * Se crea los servlts Correspondientes.
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usu;
	private UsuarioDAO usuDAO;
       
	
    public ServletLogin() {
        super();
        usuDAO = DAOFactory.getFactory().getUsuarioDAO();
        usu = new Usuario();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("user");
		String contra=request.getParameter("passwd");
		System.out.println(user);
		System.out.println(contra);
	
		//System.out.println(usuDAO.validar(user, contra));
		Usuario user2 =usuDAO.validar(user, contra);
		System.out.println(user2.toString());
		if(user2 != null) {
			String codigo=user2.getCedula();
			System.out.println(codigo);	
			String sesion ="T";
			HttpSession session=request.getSession(true);
			session.setAttribute("cedula", codigo);
			session.setAttribute("sesion", sesion);
			System.out.println(" sesion: " + session.getAttribute("cedula"));
			if(user2.getCorreo()!= null) {
				response.sendRedirect(request.getContextPath()+"/JSPs/Privado/Sentencias.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/JSPs/publico/Login.html");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/JSPs/publico/Login.html");
		}
	}
		
		
		//doGet(request, response);
	}



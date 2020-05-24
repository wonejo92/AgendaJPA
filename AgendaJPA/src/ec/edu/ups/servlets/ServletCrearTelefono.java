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
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class ServletCrearTelefono
 */
@WebServlet("/ServletCrearTelefono")
public class ServletCrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Se crea los servlts Correspondientes.
     */
    public ServletCrearTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigof=0;
		Usuario usu = new Usuario();
		Telefono telf = new Telefono();
		
		TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
		String action=request.getParameter("action");
		switch (action) {
		case "Crear":
			System.out.println("Se crea un telefono");
			String cedula=request.getParameter("Cedula");
			System.out.println(cedula);
			String codigoC=request.getParameter("codigoN");
			codigof = Integer.valueOf(codigoC);
			System.out.println(codigof);
			String numeroC=request.getParameter("numeroN");
			System.out.println(numeroC);
			String tipoC =request.getParameter("tipoN");
			System.out.println(tipoC);
			String operadoraC=request.getParameter("operadoraN");
			System.out.println(operadoraC);
			//Se setea la cedula recivida
			usu.setCedula(cedula);
			//Se crea el telefono
			telf.setNumero(numeroC);
			telf.setTipo(tipoC);
			telf.setOperadora(operadoraC);
			telf.setCedulaU(usu);
			//Se inserta en la BD
			telfDAO.create(telf);
			request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
			break;
		case "Modificar":
			System.out.println("Se Modifica  el telefono");
			
			
			String codigo=request.getParameter("codigoN");
			codigof = Integer.parseInt(codigo);
			
			Telefono telefono=telfDAO.read(codigof);
			System.out.println(codigof);
			String numero=request.getParameter("numeroN");
			System.out.println(numero);
			String tipo =request.getParameter("tipoN");
			System.out.println(tipo);
			String operadora=request.getParameter("operadoraN");
			System.out.println(operadora);
			telefono.setNumero(numero);
			telefono.setTipo(tipo);
			telefono.setOperadora(operadora);
			
			telfDAO.update(telefono);
			request.getRequestDispatcher("/JSPs/Privado/Sentencias.jsp").forward(request, response);
			break;

		default:
			break;
		
	}
		doGet(request, response);
	}
}

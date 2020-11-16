package br.com.biblioteca.servlets.obra;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.models.Autor;
import br.com.biblioteca.models.AutorObra;
import br.com.biblioteca.models.Colecao;
import br.com.biblioteca.models.Obra;

/**
 * Servlet implementation class ListaAutorServlet
 */
@WebServlet("/obras/listaObra")
public class ListaObrasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaObrasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Obra obra = new Obra();
		Collection<Obra> obras= null;
		try {
			obras = obra.listar();
			request.setAttribute("obras", obras);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				RequestDispatcher rd = request.getRequestDispatcher("/obras/listaObra.jsp");
		rd.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("codigo");
		int idObra = Integer.parseInt(codigo);
		
		try {
			AutorObra au = new AutorObra();
			au.delete(idObra);
			
			Obra obra = new Obra();
			obra.delete(idObra);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/biblioteca/obras/listaObra");
	}

}

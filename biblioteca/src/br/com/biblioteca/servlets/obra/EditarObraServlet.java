package br.com.biblioteca.servlets.obra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.models.Autor;
import br.com.biblioteca.models.Obra;

/**
 * Servlet implementation class EditarAutorServlet
 */
@WebServlet("/obras/editarObra")
public class EditarObraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarObraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Obra> obras = new ArrayList<>();
    	
    	try {
			obras = Obra.listar();
			
			RequestDispatcher rd = request.getRequestDispatcher("/obras/editarObra.jsp");
			request.setAttribute("obras", obras);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String novaDescricao = request.getParameter("novaDescricao");
		String codigo = request.getParameter("codigo");
		
		try {
			
			Obra.atualizar(Integer.parseInt(codigo), novaDescricao);
		} catch (NumberFormatException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/obras/listaObra");
	}

}

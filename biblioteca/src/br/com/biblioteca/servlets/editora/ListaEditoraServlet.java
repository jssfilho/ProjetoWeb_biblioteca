package br.com.biblioteca.servlets.editora;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.biblioteca.models.Editora;

/**
 * Servlet implementation class ExcluirEditoraServlet
 */
@WebServlet("/editoras/listaEditoras")
public class ListaEditoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEditoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		List<Editora> lista = null;
   		try {
   			lista = Editora.listar();
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		RequestDispatcher rd = request.getRequestDispatcher("/editoras/listaEditoraView.jsp");
   		request.setAttribute("editoras", lista);
   		rd.forward(request, response);
   	}
   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		String codigo = request.getParameter("codigo");
   		
   		
   		try {
   			Editora.delete(Integer.parseInt(codigo));
   		} catch (NumberFormatException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		response.sendRedirect("/editoras/listaEditoras");
   	}

}

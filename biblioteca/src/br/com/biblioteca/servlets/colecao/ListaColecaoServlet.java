package br.com.biblioteca.servlets.colecao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.biblioteca.models.Colecao;

/**
 * Servlet implementation class ExcluirColecaoServlet
 */
@WebServlet("/colecoes/listaColecoes")
public class ListaColecaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaColecaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		List<Colecao> lista = null;
   		try {
   			lista = Colecao.listar();
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		RequestDispatcher rd = request.getRequestDispatcher("/biblioteca/colecoes/listaColecoesView.jsp");
   		request.setAttribute("colecoes", lista);
   		rd.forward(request, response);
   	}
   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		String codigo = request.getParameter("codigo");
   		
   		
   		try {
   			Colecao.delete(Integer.parseInt(codigo));
   		} catch (NumberFormatException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		response.sendRedirect("/biblioteca/colecoes/listaColecoes");
   	}

}

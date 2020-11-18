package br.com.biblioteca.servlets.editora;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.biblioteca.models.Editora;

/**
 * Servlet implementation class NovaEditoraServlet
 */
@WebServlet("/editoras/novaEditora")
public class NovaEditoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEditoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		Editora novo = new Editora(nome,cnpj);
		
		try {
			novo.salve();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/editoras/listaEditoras");
	}

}

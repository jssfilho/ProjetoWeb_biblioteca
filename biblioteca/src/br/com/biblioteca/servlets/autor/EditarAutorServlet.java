package br.com.biblioteca.servlets.autor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.models.Autor;

/**
 * Servlet implementation class EditarAutorServlet
 */
@WebServlet("/autores/editarAutor")
public class EditarAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAutorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autor> listaAutor = null;
		try {
			listaAutor = Autor.listar();
			System.out.println("teste");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<listaAutor.size();i++) {
			System.out.println(listaAutor.get(i).getNome() + "editar");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/autores/formEditaAutor.jsp");
		request.setAttribute("autores", listaAutor);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("codigo");
		String novoNome = request.getParameter("novoNome");
		String novoEmail = request.getParameter("novoEmail");
		
		try {
			Autor.atualizar(Integer.parseInt(codigo),novoNome,novoEmail);
		} catch (NumberFormatException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/autores/listaAutores");
	}

}

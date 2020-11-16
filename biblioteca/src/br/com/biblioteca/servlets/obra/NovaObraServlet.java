package br.com.biblioteca.servlets.obra;

import java.awt.List;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.models.Autor;
import br.com.biblioteca.models.AutorObra;
import br.com.biblioteca.models.Colecao;
import br.com.biblioteca.models.Editora;
import br.com.biblioteca.models.Obra;

/**
 * Servlet implementation class NovaObraServlet
 */
@WebServlet("/obras/formNovaObra")

public class NovaObraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaObraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Autor> listaAutor = null;
		Autor autor = new Autor();
		try {
			listaAutor = autor.listar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Editora editora = new Editora();
		Collection<Editora> editoras = null;
		
		try {
			editoras = editora.listar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Colecao> colecoes = null;
		Colecao colecao = new Colecao();
		
		try {
			colecoes = colecao.listar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/obras/formNovaObra.jsp");
		request.setAttribute("autores", listaAutor);
		request.setAttribute("editoras", editoras);
		request.setAttribute("colecoes", colecoes);
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String idAutor = request.getParameter("lista");
		
		String idEditora = request.getParameter("idEditora");
		String idColecao = request.getParameter("idColecao");
		
		String[] hidden=request.getParameterValues("lista");
		
		
		Obra obra = new Obra();
		
		obra.setCod_editora(Integer.parseInt(idEditora));
		obra.setTitulo(titulo);
		obra.setDescricao(descricao);
		obra.setCod_colecao(Integer.parseInt(idColecao));
				
		try {
			
			int idObra = obra.salveRetorno();
			
			try {
			Stream.of(hidden).forEach((id) ->{
				AutorObra autorObra = new AutorObra();
				
				autorObra.setFkAutor(Integer.parseInt(id));
				autorObra.setFkObra(idObra);
				try {
					autorObra.salve();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				});
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("/biblioteca/obras/listaObra");
	}

}

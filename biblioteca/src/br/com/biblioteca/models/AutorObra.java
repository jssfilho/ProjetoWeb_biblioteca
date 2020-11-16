package br.com.biblioteca.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Statement;

import br.com.biblioteca.config.ConexaoBanco;

public class AutorObra implements Model {
	
	private int id;
	
	private int fkAutor;
	
	private int fkObra;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkAutor() {
		return fkAutor;
	}

	public void setFkAutor(int fkAutor) {
		this.fkAutor = fkAutor;
	}

	public int getFkObra() {
		return fkObra;
	}


	public void setFkObra(int fkObra) {
		this.fkObra = fkObra;
	}

	public boolean salve() throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("INSERT INTO obra_autor ( cod_autor, cod_obra) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
           // stmt.setInt(1, this.id);
            stmt.setInt(1, this.fkAutor);
            stmt.setInt(2, this.fkObra);
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
            	System.err.println(keys.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
	public Collection<Autor> consultarAutoresPorObra(int obra) throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
		Collection<Autor> autores = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet result = null;
		try {
			
            stmt = con.prepareStatement("SELECT a.cod, a.email, a.nome "
            		+ "FROM biblioteca.obra_autor oa JOIN "
            		+ "biblioteca.autor a on oa.cod_autor = a.cod "
            		+ "JOIN biblioteca.obra o on oa.cod_obra = o.cod WHERE a.cod = ?");
            stmt.setInt(1, obra);
            result =  stmt.executeQuery();
            while(result.next()) {
            	Autor autor = new Autor();
            	autor.setCodigo(result.getInt("cod"));
            	autor.setNome(result.getString("nome"));
            	autor.setEmail(result.getString("email"));
            	autores.add(autor);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return autores;
	}

	public Collection<Obra> consultarObraPorAutor(int autor) throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
		Collection<Obra> obras = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet result = null;
		try {
			
            stmt = con.prepareStatement("SELECT o.cod, o.titulo, o.descricao, o.cod_editora, o.cod_colecao "
            		+ "FROM biblioteca.obra_autor oa JOIN "
            		+ "biblioteca.autor a on oa.cod_autor = a.cod "
            		+ "JOIN biblioteca.obra o on oa.cod_obra = o.cod WHERE o.cod = ?");
            stmt.setInt(1, autor);
            result =  stmt.executeQuery();
            while(result.next()) {
            	Obra obra = new Obra();
            	obra.setCodigo(result.getInt("cod"));
            	obra.setDescricao(result.getString("descricao"));;
            	obra.setTitulo(result.getString("titulo"));
            	obras.add(obra);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return obras;
	}
	
	public static boolean delete(int codigo) throws ClassNotFoundException{
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("DELETE FROM biblioteca.obra_autor WHERE cod_obra = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
	/*public Collection<Obra> listarObrasAutor() throws ClassNotFoundException {
	
	SELECT o.cod, o.titulo, o.descricao, o.cod_editora, o.cod_colecao, a.nome, c.nome, c.genero
	 FROM biblioteca.obra_autor oa JOIN biblioteca.autor a on oa.cod_autor = a.cod 
	 JOIN biblioteca.obra o on oa.cod_obra = o.cod 
	 JOIN biblioteca.colecao c on c.cod = o.cod_colecao
	
	
	}
	*/
	public static void main(String[] args) {
		
		AutorObra autorObra = new AutorObra();
		autorObra.setFkAutor(1);
		autorObra.setFkObra(1);
		try {
			autorObra.salve();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

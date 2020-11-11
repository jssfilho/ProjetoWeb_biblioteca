package br.com.biblioteca.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.config.ConexaoBanco;

public class Autor implements Model{
	private int codigo;
	private String nome;
	private String email;
	
	
	public Autor() {
		
	}
	public Autor(String nome,String email) {
		this.codigo=1;
		this.nome=nome;
		this.email=email;
	}
	
	//Metodos de Objeto
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//Metodos de Modelo CRUD
	public boolean salve() throws ClassNotFoundException {
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("INSERT INTO autor (nome, email) VALUES(?,?)");
            stmt.setString(1, this.nome);
            stmt.setString(2, this.email);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
	public static List<Autor> listar() throws ClassNotFoundException{
		List<Autor> lista = new ArrayList<>();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.autor");
            
            result =  stmt.executeQuery();
            while(result.next()) {
            	Autor autor = new Autor();
            	autor.setCodigo(result.getInt("cod"));
            	autor.setNome(result.getString("nome"));
            	autor.setEmail(result.getString("email"));
            	lista.add(autor);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return lista;
	}
	public static Autor getOne(int codigo) throws ClassNotFoundException{
		Autor autor = new Autor();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.autor");
            
            result =  stmt.executeQuery();
            
            if(result.next()) {	
            	autor.setCodigo(result.getInt("cod"));
            	autor.setNome(result.getString("nome"));
            	autor.setEmail(result.getString("email"));
            }else
            	System.out.println("Autor não existe!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return autor;
	}
	
	public static boolean atualizar(int codigo, String novoNome,String novoEmail) throws ClassNotFoundException{
		
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("UPDATE autor SET nome = ? , email = ? WHERE cod = ?");
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
            stmt.setInt(3, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
	public static boolean delete(int codigo) throws ClassNotFoundException{
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("DELETE FROM autor WHERE cod = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
}

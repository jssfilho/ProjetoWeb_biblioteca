package br.com.biblioteca.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.config.ConexaoBanco;

public class Colecao {
	
	private int codigo;
	private String nome;
	private String genero;
	
	public Colecao() {
		
	}
	
	
	public Colecao(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
	}


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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	//Metodos de Modelo CRUD
	public boolean salve() throws ClassNotFoundException {
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("INSERT INTO colecao (nome, genero) VALUES(?,?)");
            stmt.setString(1, this.nome);
            stmt.setString(2, this.genero);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }ConexaoBanco.closeConnection(con);
		return true;
	}
	
	public static List<Colecao> listar() throws ClassNotFoundException{
		List<Colecao> lista = new ArrayList<>();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.colecao");
            
            result =  stmt.executeQuery();
            while(result.next()) {
            	Colecao colecao = new Colecao();
            	colecao.setCodigo(result.getInt("cod"));
            	colecao.setNome(result.getString("nome"));
            	colecao.setGenero(result.getString("genero"));
            	lista.add(colecao);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }ConexaoBanco.closeConnection(con);
		return lista;
	}
	public static Colecao getOne(int codigo) throws ClassNotFoundException{
		Colecao colecao = new Colecao();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.colecao");
            
            result =  stmt.executeQuery();
            
            if(result.next()) {	
            	colecao.setCodigo(result.getInt("cod"));
            	colecao.setNome(result.getString("nome"));
            	colecao.setGenero(result.getString("genero"));
            }else
            	System.out.println("Colecao não existe!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }ConexaoBanco.closeConnection(con);
		return colecao;
	}
	
	public static boolean atualizar(int codigo, String novoNome,String novoGenero) throws ClassNotFoundException{
		
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("UPDATE colecao SET nome = ?, genero = ? WHERE cod = ?");
            stmt.setString(1, novoNome);
            stmt.setString(2, novoGenero);
            stmt.setInt(3, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }ConexaoBanco.closeConnection(con);
		return true;
	}
	
	public static boolean delete(int codigo) throws ClassNotFoundException{
		
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("DELETE FROM colecao WHERE cod = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }ConexaoBanco.closeConnection(con);
		return true;
	}

}

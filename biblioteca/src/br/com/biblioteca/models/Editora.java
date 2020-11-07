package br.com.biblioteca.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.config.ConexaoBanco;

public class Editora implements Model{
	private int codigo;
	private String nome;
	private String cnpj; 
	
	
	public Editora () {
		
	}
	

	public Editora(int codigo, String nome, String cnpj) {
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
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


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	//Metodos de Modelo CRUD
	@Override
	public boolean salve() throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("INSERT INTO editora (nome, cnpj) VALUES(?,?)");
            stmt.setString(1, this.nome);
            stmt.setString(2, this.cnpj);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
	public static List<Editora> listar() throws ClassNotFoundException {
		List<Editora> lista = new ArrayList<>();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.editora");
            
            result =  stmt.executeQuery();
            while(result.next()) {
            	Editora editora = new Editora();
            	editora.setCodigo(result.getInt("cod"));
            	editora.setNome(result.getString("nome"));
            	editora.setCnpj(result.getString("cnpj"));
            	lista.add(editora);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return lista;
	}
	
	
	public static Editora getOne(int codigo) throws ClassNotFoundException{
		Editora editora = new Editora();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.autor");
            
            result =  stmt.executeQuery();
            
            if(result.next()) {	
            	editora.setCodigo(result.getInt("cod"));
            	editora.setNome(result.getString("nome"));
            	editora.setCnpj(result.getString("cnpj"));
            }else
            	System.out.println("Editora não existe!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return editora;
	}
	

	public static boolean atualizar(int codigo, String novoNome,String novoCnpj) throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("UPDATE editora SET nome = ? AND cnpj = ? WHERE cod = ?");
            stmt.setString(1, novoNome);
            stmt.setString(2, novoCnpj);
            stmt.setInt(3, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	public static boolean delete(int codigo) throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("DELETE FROM editora WHERE cod = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	
}

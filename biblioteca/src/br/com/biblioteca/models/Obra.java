package br.com.biblioteca.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.config.ConexaoBanco;

public class Obra implements Model{
	private int codigo;
	private String titulo;
	private String descricao;
	private List<Integer> cod_autores;
	private int cod_editora;
	private int cod_colecao;
	
	public Obra(){}
	
	
	public Obra(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	
	public int getCod_colecao() {
		return cod_colecao;
	}


	public void setCod_colecao(int cod_colecao) {
		this.cod_colecao = cod_colecao;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public List<Integer> getCod_autores() {
		return cod_autores;
	}


	public void setCod_autores(int cod_autor) {
		this.cod_autores.add(cod_autor);
	}


	public int getCod_editora() {
		return cod_editora;
	}


	public void setCod_editora(int cod_editora) {
		this.cod_editora = cod_editora;
	}

	//Metodos de Modelo CRUD

	//Metodo Incompleto
	@Override
	public boolean salve() throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("INSERT INTO obra (nome, email, cod_editora, cod_colecao) VALUES(?,?,?,?)");
            stmt.setString(1, this.titulo);
            stmt.setString(2, this.descricao);
            stmt.setInt(3, this.cod_editora);
            stmt.setInt(4, this.cod_colecao);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}
	//Metodo Incompleto
	public static List<Obra> listar() throws ClassNotFoundException {
		List<Obra> lista = new ArrayList<>();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.obra");
            
            result =  stmt.executeQuery();
            while(result.next()) {
            	Obra obra = new Obra();
            	obra.setCodigo(result.getInt("cod"));
            	obra.setTitulo(result.getString("titulo"));
            	obra.setDescricao(result.getString("descricao"));
            	obra.setCod_editora(result.getInt("cod_editora"));
            	obra.setCod_colecao(result.getInt("cod_colecao"));
            	lista.add(obra);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return lista;
	}
	
	//Metodo Incompleto
	public static Obra getOne(int codigo) throws ClassNotFoundException{
		Obra obra = new Obra();
		ResultSet result =null;
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("SELECT * FROM biblioteca.obra");
            
            result =  stmt.executeQuery();
            
            if(result.next()) {	
            	obra.setCodigo(result.getInt("cod"));
            	obra.setTitulo(result.getString("titulo"));
            	obra.setDescricao(result.getString("descricao"));
            	obra.setCod_editora(result.getInt("cod_editora"));
            	obra.setCod_colecao(result.getInt("cod_colecao"));
            }else
            	System.out.println("Obra não existe!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return obra;
	}
	

	public static boolean atualizar(int codigo, String novoTitulo,String novaDescricao) throws ClassNotFoundException {
		Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
		try {
			
            stmt = con.prepareStatement("UPDATE obra SET titulo = ?, descricao = ? WHERE cod = ?");
            stmt.setString(1, novoTitulo);
            stmt.setString(2, novaDescricao);
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
			
            stmt = con.prepareStatement("DELETE FROM obra WHERE cod = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
		return true;
	}



}

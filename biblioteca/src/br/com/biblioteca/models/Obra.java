package br.com.biblioteca.models;

import java.util.List;

public class Obra implements Model{
	private int codigo;
	private String titulo;
	private String descricao;
	private String nome_autores;
	private String nome_editora;
	
	public Obra(){}
	
	
	public Obra(String titulo, String descricao, String nome_autores) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.nome_autores = nome_autores;
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
	public String getNome_autores() {
		return nome_autores;
	}
	public void setNome_autores(String nome_autores) {
		this.nome_autores = nome_autores;
	}
	
	public String getNome_editora() {
		return nome_editora;
	}
	public void setNome_editora(String nome_editora) {
		this.nome_editora = nome_editora;
	}


	//Metodos de Modelo CRUD
	
	@Override
	public boolean salve() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static List<Model> listar() throws ClassNotFoundException {
		return null;
	}

	public static boolean atualizar(int codigo, String novoAtri,String novoAtri2) throws ClassNotFoundException {
		return false;
	}
	public static boolean delete(int codigo) throws ClassNotFoundException {
		return false;
	}



}

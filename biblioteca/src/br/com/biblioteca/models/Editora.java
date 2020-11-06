package br.com.biblioteca.models;

import java.util.List;

public class Editora implements Model{
	private int codigo;
	private String nome;
	private String cnpj; 
	
	
	public Editora () {
		
	}
	

	public Editora(int codigo, String nome, String cnpj) {
		super();
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

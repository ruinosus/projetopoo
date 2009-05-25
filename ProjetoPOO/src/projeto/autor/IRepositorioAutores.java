package projeto.autor;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioAutores {	
	public void inserir(Autor autor) throws ExcecaoNegocio;	
	public Autor consultar(int identidade) throws ExcecaoNegocio;
	public ArrayList<Autor> consultar(String nome) throws ExcecaoNegocio;	
	public void alterar(Autor autor) throws ExcecaoNegocio;	
	public void remover(int identidade) throws ExcecaoNegocio;
	public boolean existe(int identidade) throws ExcecaoNegocio;	
	public ArrayList<Autor> consultar() throws ExcecaoNegocio;	

}

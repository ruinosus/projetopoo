package projeto.livro;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioLivros {
	
	public void inserir(Livro livro)throws ExcecaoNegocio;	
	public Livro consultar(int isbn)throws ExcecaoNegocio;	
	public void alterar(Livro livro)throws ExcecaoNegocio;	
	public void remover(int isbn)throws ExcecaoNegocio;	
	public boolean existe(int isbn)throws ExcecaoNegocio;	
	public ArrayList<Livro> consultar() throws ExcecaoNegocio;
	public ArrayList<Livro> consultar(String titulo) throws ExcecaoNegocio;
	
	public void inserirLivroAutor(int isbn, int identidade)throws ExcecaoNegocio;
	public void removerLivroAutor(int isbn)throws ExcecaoNegocio;

}

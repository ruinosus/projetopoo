package projeto.livro;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioLivros {
	
	public void inserir(Livro novoLivro)throws ExcecaoNegocio;	
	public Livro consultar(int isbn)throws ExcecaoNegocio;	
	public void atualizar(Livro novoLivro)throws ExcecaoNegocio;	
	public void remover(int isbn)throws ExcecaoNegocio;	
	public boolean existe(int isbn)throws ExcecaoNegocio;	
	public ArrayList<Livro> consultarTodos() throws ExcecaoNegocio;

}

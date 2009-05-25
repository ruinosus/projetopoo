package projeto.editora;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioEditoras {
	
	public void inserir(Editora editora) throws ExcecaoNegocio;
	public void alterar(Editora editora) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public Editora consultar(int codigo)throws ExcecaoNegocio;
	public ArrayList<Editora> consultar(String nome) throws ExcecaoNegocio;
	public ArrayList<Editora> consultar() throws ExcecaoNegocio;

}
	
package projeto.autor;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioAutores {	
	public void inserir(Autor novoAutor) throws ExcecaoNegocio;	
	public Autor consultarCodigo(int identidade) throws ExcecaoNegocio;
	public ArrayList<Autor> consultarNome(String nome) throws ExcecaoNegocio;	
	public void atualizar(Autor novoAutor) throws ExcecaoNegocio;	
	public void remover(int identidade) throws ExcecaoNegocio;
	public boolean existe(int identidade) throws ExcecaoNegocio;	

}

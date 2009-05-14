package projeto.editora;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioEditoras {
	
	public void inserir(Editora editora) throws ExcecaoNegocio;
	public void alterar(Editora editora) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public Editora consultarCodigo(int codigo)throws ExcecaoNegocio;
	public ArrayList<Editora> consultarNome(String nome) throws ExcecaoNegocio;

}
	
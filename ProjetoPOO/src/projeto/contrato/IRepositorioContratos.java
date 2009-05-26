package projeto.contrato;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioContratos {
	public Contrato inserir(Contrato contrato) throws ExcecaoNegocio;
	public void alterar(Contrato contrato) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public Contrato consultar(int codigo)throws ExcecaoNegocio;
	public ArrayList<Contrato> consultar(String nome) throws ExcecaoNegocio;
	public ArrayList<Contrato> consultar() throws ExcecaoNegocio;
}

package projeto.contrato;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioContratos {
	public void inserir(Contrato contrato) throws ExcecaoNegocio;
	public void alterar(Contrato contrato) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public Contrato consultarCodigo(int codigo)throws ExcecaoNegocio;
	public ArrayList<Contrato> consultarNome(String nome) throws ExcecaoNegocio;
}

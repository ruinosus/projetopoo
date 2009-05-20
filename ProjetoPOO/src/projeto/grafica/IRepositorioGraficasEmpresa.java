package projeto.grafica;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioGraficasEmpresa {
	public void inserir(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio;
	public void alterar(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio;
	public void remover(int numIdentificacao)throws ExcecaoNegocio;
	public GraficaEmpresa consultarCodigo(int num_identificacao)throws ExcecaoNegocio;
	public ArrayList<GraficaEmpresa> consultarNome(String nome) throws ExcecaoNegocio;
	public ArrayList<GraficaEmpresa> consultarTodos() throws ExcecaoNegocio;
}

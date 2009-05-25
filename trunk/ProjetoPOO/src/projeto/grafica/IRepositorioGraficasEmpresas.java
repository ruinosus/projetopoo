package projeto.grafica;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioGraficasEmpresas {
	public GraficaEmpresa inserir(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio;
	public void alterar(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public GraficaEmpresa consultar(int codigo)throws ExcecaoNegocio;
	public ArrayList<Grafica> consultar(String nome) throws ExcecaoNegocio;
	public ArrayList<Grafica> consultar() throws ExcecaoNegocio;
}

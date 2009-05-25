package projeto.grafica;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioGraficasTerceirizadas {
	public void inserir(GraficaTerceirizada graficaTerceirizada) throws ExcecaoNegocio;
	public void alterar(GraficaTerceirizada graficaTerceirizada) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public GraficaTerceirizada consultar(int codigo)throws ExcecaoNegocio;

}

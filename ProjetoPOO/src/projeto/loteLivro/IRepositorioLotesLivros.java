package projeto.loteLivro;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioLotesLivros {
	public void inserir(LoteLivro loteLivro) throws ExcecaoNegocio;
	public void alterar(LoteLivro loteLivro) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public LoteLivro consultar(int codigo)throws ExcecaoNegocio;
}

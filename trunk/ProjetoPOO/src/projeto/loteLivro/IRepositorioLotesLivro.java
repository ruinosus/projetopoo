package projeto.loteLivro;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioLotesLivro {
	public void inserir(LoteLivro loteLivro) throws ExcecaoNegocio;
	public void alterar(LoteLivro loteLivro) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public LoteLivro consultarCodigo(int codigo)throws ExcecaoNegocio;
}

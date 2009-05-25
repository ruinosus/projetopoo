package projeto.endereco;

import projeto.excecao.ExcecaoNegocio;

public interface IRepositorioEnderecos {
	public Endereco inserir(Endereco endereco) throws ExcecaoNegocio;
	public void alterar(Endereco endereco) throws ExcecaoNegocio;
	public void remover(int codigo)throws ExcecaoNegocio;
	public Endereco consultar(int codigo)throws ExcecaoNegocio;
}

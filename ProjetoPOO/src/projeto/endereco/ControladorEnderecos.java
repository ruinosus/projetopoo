package projeto.endereco;



import projeto.excecao.ExcecaoNegocio;

public class ControladorEnderecos {
private IRepositorioEnderecos repEnderecos;
	
	public ControladorEnderecos(IRepositorioEnderecos repEnderecos) {
		this.repEnderecos = repEnderecos;
	}
	
	public Endereco inserir(Endereco endereco)throws ExcecaoNegocio {
		if(endereco != null)
			return this.repEnderecos.inserir(endereco);
		else
			throw new ExcecaoNegocio("Valor inválido");
	}
	
	public Endereco consultar(int codigo)throws ExcecaoNegocio {
		Endereco endereco = repEnderecos.consultar(codigo);
		if(endereco == null)
			throw new ExcecaoNegocio("Endereço não existente.");
		return endereco;
	}	

	
	public void remover(int codigo)throws ExcecaoNegocio{
		this.consultar(codigo);
		this.repEnderecos.remover(codigo);
	}
	
	public void alterar(Endereco endereco)throws ExcecaoNegocio {
		this.consultar(endereco.getCodigo());
		this.repEnderecos.alterar(endereco);
	}
}

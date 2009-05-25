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
			throw new ExcecaoNegocio("Valor inv�lido");
	}
	
	public Endereco consultar(int codigo)throws ExcecaoNegocio {
		Endereco contrato = repEnderecos.consultar(codigo);
		if(contrato == null)
			throw new ExcecaoNegocio("Endere�o n�o existente.");
		return contrato;
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

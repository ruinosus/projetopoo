package projeto.endereco;



import projeto.excecao.ExcecaoNegocio;

public class ControladorEndereco {
private IRepositorioEnderecos repEnderecos;
	
	public ControladorEndereco(IRepositorioEnderecos repEnderecos) {
		this.repEnderecos = repEnderecos;
	}
	
	public Endereco cadastrar(Endereco endereco)throws ExcecaoNegocio {
		if(endereco != null)
			return this.repEnderecos.inserir(endereco);
		else
			throw new ExcecaoNegocio("Valor inválido");
	}
	
	public Endereco consultar(int codigo)throws ExcecaoNegocio {
		Endereco contrato = repEnderecos.consultarCodigo(codigo);
		if(contrato == null)
			throw new ExcecaoNegocio("Endereço não existente.");
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

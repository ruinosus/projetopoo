package projeto.contrato;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;


public class ControladorContrato {
	
	private IRepositorioContratos repContratos;
	
	public ControladorContrato(IRepositorioContratos repContratos) {
		this.repContratos = repContratos;
	}
	
	public void cadastrar(Contrato contrato)throws ExcecaoNegocio {
		if(contrato != null)
			this.repContratos.inserir(contrato);
		else
			throw new ExcecaoNegocio("Valor inválido");
	}
	
	public Contrato consultar(int codigo)throws ExcecaoNegocio {
		Contrato contrato = repContratos.consultarCodigo(codigo);
		if(contrato == null)
			throw new ExcecaoNegocio("Contrato não existente.");
		return contrato;
	}
	
	public ArrayList<Contrato> consultar(String nome)throws ExcecaoNegocio {
		ArrayList<Contrato> contratos = repContratos.consultarNome(nome);
		if(contratos.isEmpty())
			throw new ExcecaoNegocio("Contrato não existente.");
		return contratos;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		this.consultar(codigo);
		this.repContratos.remover(codigo);
	}
	
	public void alterar(Contrato contrato)throws ExcecaoNegocio {
		this.consultar(contrato.getCodigo());
		this.repContratos.alterar(contrato);
	}
}

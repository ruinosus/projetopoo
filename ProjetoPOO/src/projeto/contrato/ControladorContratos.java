package projeto.contrato;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;


public class ControladorContratos {
	
	private IRepositorioContratos repContratos;
	
	public ControladorContratos(IRepositorioContratos repContratos) {
		this.repContratos = repContratos;
	}
	
	public Contrato inserir(Contrato contrato)throws ExcecaoNegocio {
		if(contrato != null)
			return this.repContratos.inserir(contrato);
		else
			throw new ExcecaoNegocio("Valor inválido");
	}
	
	public Contrato consultar(int codigo)throws ExcecaoNegocio {
		Contrato contrato = repContratos.consultar(codigo);
		if(contrato == null)
			throw new ExcecaoNegocio("Contrato não existente.");
		return contrato;
	}
	
	public ArrayList<Contrato> consultar(String nome)throws ExcecaoNegocio {
		ArrayList<Contrato> contratos = repContratos.consultar(nome);
		if(contratos.isEmpty())
			throw new ExcecaoNegocio("Contrato não existente.");
		return contratos;
	}
	
	public ArrayList<Contrato> consultar()throws ExcecaoNegocio {
		ArrayList<Contrato> contratos = repContratos.consultar();
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

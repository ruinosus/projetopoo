package projeto.grafica;

import projeto.contrato.Contrato;
import projeto.endereco.Endereco;

public class GraficaTerceirizada extends Grafica {

	private Endereco endereco;
	private Contrato contrato;
	
	public GraficaTerceirizada(int codigo, String nome, Endereco endereco, Contrato contrato) {
		super(codigo, nome);
	
		this.contrato = contrato;
		this.endereco = endereco;
	}	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}	

}

package projeto;

import java.util.ArrayList;

import projeto.contrato.Contrato;
import projeto.contrato.ControladorContrato;
import projeto.contrato.IRepositorioContratos;
import projeto.contrato.RepositorioContratos;
import projeto.excecao.ExcecaoNegocio;


public class Fachada {
	private static Fachada instancia;
	
	  private ControladorContrato controladorContrato;
	
	  private Fachada() {
	    initControladores();
	  }
	  
	  private void initControladores() {
		  //controlador contratos
		  IRepositorioContratos irepContratos = new RepositorioContratos();
		  this.controladorContrato = new ControladorContrato(irepContratos);	    
	  }
	  
	  public static Fachada obterInstancia() {
	    if (instancia == null) {
	      instancia = new Fachada();
	    }
	    return instancia;
	  }
	  
	  //FACHADA PARA CONTRATO
	  public void cadastrarContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContrato.cadastrar(contrato);
	  }
	  
	  public void removerContrato(int codigo) throws ExcecaoNegocio{
		 this.controladorContrato.remover(codigo);
	  }
	  
      public void alterarContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContrato.atualizar(contrato);
	  }
      
      public ArrayList<Contrato> consultarContrato(String nome)throws ExcecaoNegocio{
    	 return this.controladorContrato.consultar(nome);
      }
      
      public Contrato consultarContrato(int codigo)throws ExcecaoNegocio{
     	 return this.controladorContrato.consultar(codigo);
       }
	  
	  
}

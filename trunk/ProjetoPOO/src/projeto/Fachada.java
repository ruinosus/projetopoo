package projeto;

import java.util.ArrayList;

import projeto.contrato.Contrato;
import projeto.contrato.ControladorContratos;
import projeto.contrato.IRepositorioContratos;
import projeto.contrato.RepositorioContratos;
import projeto.excecao.ExcecaoNegocio;


public class Fachada {
	private static Fachada instancia;
	
	  private ControladorContratos controladorContratos;
	
	  private Fachada() {
	    initControladores();
	  }
	  
	  private void initControladores() {
		  //controlador contratos
		  IRepositorioContratos irepContratos = new RepositorioContratos();
		  this.controladorContratos = new ControladorContratos(irepContratos);	    
	  }
	  
	  public static Fachada obterInstancia() {
	    if (instancia == null) {
	      instancia = new Fachada();
	    }
	    return instancia;
	  }
	  
	  //FACHADA PARA CONTRATO
	  public void inserirContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContratos.inserir(contrato);
	  }
	  
	  public void removerContrato(int codigo) throws ExcecaoNegocio{
		 this.controladorContratos.remover(codigo);
	  }
	  
      public void alterarContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContratos.alterar(contrato);
	  }
      
      public ArrayList<Contrato> consultarContrato(String nome)throws ExcecaoNegocio{
    	 return this.controladorContratos.consultar(nome);
      }
      
      public Contrato consultarContrato(int codigo)throws ExcecaoNegocio{
     	 return this.controladorContratos.consultar(codigo);
       }
	  
	  
}

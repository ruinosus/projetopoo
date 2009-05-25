package projeto.grafica;

import java.util.ArrayList;

import projeto.contrato.Contrato;
import projeto.contrato.ControladorContratos;
import projeto.contrato.IRepositorioContratos;
import projeto.endereco.ControladorEnderecos;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;


public class ControladorGraficas {

	private IRepositorioGraficasEmpresas repGraficasEmpresas;
	private IRepositorioGraficasTerceirizadas repGraficasTerceirizadas;
	private ControladorEnderecos contEnderecos;
	private ControladorContratos contContratos;
	
	public ControladorGraficas(IRepositorioGraficasEmpresas repGraficasEmpresas,
			IRepositorioGraficasTerceirizadas repGraficasTerceirizada,
			IRepositorioEnderecos repEnderecos,IRepositorioContratos repContratos) {
		this.repGraficasEmpresas = repGraficasEmpresas;
		this.repGraficasTerceirizadas = repGraficasTerceirizada;
		this.contEnderecos = new ControladorEnderecos(repEnderecos);
		this.contContratos = new ControladorContratos(repContratos);

	}
	
	public void inserir(Grafica grafica)throws ExcecaoNegocio {
		if(grafica instanceof GraficaEmpresa){
			GraficaEmpresa graficaEmpresa = (GraficaEmpresa) grafica;
			this.repGraficasEmpresas.inserir(graficaEmpresa);
		}
		if(grafica instanceof GraficaTerceirizada){
			
			GraficaTerceirizada graficaTerceirizada = (GraficaTerceirizada) grafica;
			
			GraficaEmpresa graficaEmpresa = new GraficaEmpresa(graficaTerceirizada.getCodigo(),graficaTerceirizada.getNome());
			graficaEmpresa  = this.repGraficasEmpresas.inserir(graficaEmpresa);
			graficaTerceirizada.setCodigo(graficaEmpresa.getCodigo());
			
			graficaTerceirizada.setEndereco(this.contEnderecos.inserir(graficaTerceirizada.getEndereco()));
			graficaTerceirizada.setContrato(this.contContratos.inserir(graficaTerceirizada.getContrato()));
			this.repGraficasTerceirizadas.inserir(graficaTerceirizada);
		}
	}
	
	public Grafica consultar(int codigo)throws ExcecaoNegocio {
		Grafica grafica;
		grafica = this.repGraficasEmpresas.consultar(codigo);
		
		if(grafica != null){
			grafica = this.repGraficasTerceirizadas.consultar(codigo);
			
			if(grafica != null){
				grafica=this.montarGraficaTerceirizada((GraficaTerceirizada)grafica);
			}
		}else{
			throw new ExcecaoNegocio("Gráfica informada não exisite no sistema.");
		}
		
		return grafica;
	}
	public ArrayList<Grafica> consultar(String nome)throws ExcecaoNegocio {
		ArrayList<Grafica> graficas = this.repGraficasEmpresas.consultar(nome);
		
		for(int i = 0; i <graficas.size(); i++){
			GraficaTerceirizada graficaTerceirizada = this.repGraficasTerceirizadas.consultar(graficas.get(i).getCodigo());
			if(graficaTerceirizada!= null){
				graficaTerceirizada = this.montarGraficaTerceirizada(graficaTerceirizada);
				graficas.set(i, graficaTerceirizada);
			}else{
				GraficaEmpresa graficaEmpresa = this.repGraficasEmpresas.consultar(graficas.get(i).getCodigo());
				graficas.set(i, graficaEmpresa);
			}
		}		
		
		return graficas ;
	}
	
	public ArrayList<Grafica> consultar()throws ExcecaoNegocio {
		ArrayList<Grafica> graficas = this.repGraficasEmpresas.consultar();
		
		for(int i = 0; i <graficas.size(); i++){
			GraficaTerceirizada graficaTerceirizada = this.repGraficasTerceirizadas.consultar(graficas.get(i).getCodigo());
			if(graficaTerceirizada!= null){
				graficaTerceirizada = this.montarGraficaTerceirizada(graficaTerceirizada);
				graficas.set(i, graficaTerceirizada);
			}else{
				GraficaEmpresa graficaEmpresa = this.repGraficasEmpresas.consultar(graficas.get(i).getCodigo());
				graficas.set(i, graficaEmpresa);
			}
		}		
		
		return graficas ;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		Grafica grafica = this.consultar(codigo);
		if(grafica instanceof GraficaEmpresa){
			this.repGraficasEmpresas.remover(codigo);
		}
		if(grafica instanceof GraficaTerceirizada){
			GraficaTerceirizada graficaTerceirizada = (GraficaTerceirizada) grafica;
			this.repGraficasTerceirizadas.remover(codigo);
			this.repGraficasEmpresas.remover(codigo);
			this.contEnderecos.remover(graficaTerceirizada.getEndereco().getCodigo());
			this.contContratos.remover(graficaTerceirizada.getContrato().getCodigo());
		}
		
	}
	
	public void alterar(Grafica grafica)throws ExcecaoNegocio {
		@SuppressWarnings("unused")
		Grafica g = this.consultar(grafica.getCodigo());
		if(grafica instanceof GraficaEmpresa){
			GraficaEmpresa graficaEmpresa = (GraficaEmpresa) grafica;
			this.repGraficasEmpresas.alterar(graficaEmpresa);
		}
		if(grafica instanceof GraficaTerceirizada){
			GraficaTerceirizada graficaTerceirizada = (GraficaTerceirizada) grafica;
			
			GraficaEmpresa graficaEmpresa = new GraficaEmpresa(graficaTerceirizada.getCodigo(),graficaTerceirizada.getNome());
			this.repGraficasEmpresas.alterar(graficaEmpresa);
			this.contEnderecos.alterar(graficaTerceirizada.getEndereco());
			this.contContratos.alterar(graficaTerceirizada.getContrato());
			this.repGraficasTerceirizadas.alterar(graficaTerceirizada);
		}
	}

	
	@SuppressWarnings("unused")
	private GraficaTerceirizada montarGraficaTerceirizada(GraficaTerceirizada graficaTerceirizada) throws ExcecaoNegocio{
		
		GraficaEmpresa graficaEmpresa = new GraficaEmpresa(graficaTerceirizada.getCodigo(),graficaTerceirizada.getNome());
		Endereco endereco = this.contEnderecos.consultar(graficaTerceirizada.getEndereco().getCodigo());
		Contrato contrato = this.contContratos.consultar(graficaTerceirizada.getContrato().getCodigo());

		graficaTerceirizada.setEndereco(endereco);
		graficaTerceirizada.setContrato(contrato);
		graficaTerceirizada.setCodigo(graficaEmpresa.getCodigo());
		graficaTerceirizada.setNome(graficaEmpresa.getNome());		
		
		return graficaTerceirizada;
	}
}

package projeto.editora;

import java.util.ArrayList;

import projeto.endereco.ControladorEnderecos;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;


public class ControladorEditoras {
	
	private IRepositorioEditoras repEditoras;
	private ControladorEnderecos contEnderecos;
	
	public ControladorEditoras(IRepositorioEditoras repEditoras,IRepositorioEnderecos repEnderecos) {
		this.repEditoras = repEditoras;
		this.contEnderecos = new ControladorEnderecos(repEnderecos);
	}
	
	public void inserir(Editora editora)throws ExcecaoNegocio {		
		editora.setEndereco(contEnderecos.inserir(editora.getEndereco()));
		repEditoras.inserir(editora);		
	}
	
	public Editora consultar(int codigo) throws ExcecaoNegocio {
		Editora editora = repEditoras.consultar(codigo);
		if(editora==null){
			throw new ExcecaoNegocio("Nenhuma editora encontrada");
		}
		Endereco endereco = contEnderecos.consultar(editora.getEndereco().getCodigo());		
		editora.setEndereco(endereco);
		
		
		return editora;
	}
	
	public ArrayList<Editora> consultar(String nome) throws ExcecaoNegocio {
		ArrayList<Editora> editoras = repEditoras.consultar(nome);
		
		for(int i = 0; i< editoras.size(); i++){
			Endereco endereco = contEnderecos.consultar(editoras.get(i).getEndereco().getCodigo());		
			editoras.get(i).setEndereco(endereco); 
		}
	
		return editoras;
	}
	
	public ArrayList<Editora> consultar() throws ExcecaoNegocio {
		ArrayList<Editora> editoras = repEditoras.consultar();
		
		for(int i = 0; i< editoras.size(); i++){
			Endereco endereco = contEnderecos.consultar(editoras.get(i).getEndereco().getCodigo());		
			editoras.get(i).setEndereco(endereco); 
		}
	
		return editoras;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		Editora editora = repEditoras.consultar(codigo);
		if(editora==null){
			throw new ExcecaoNegocio("Nenhuma editora encontrada");
		}
		repEditoras.remover(codigo);			
		contEnderecos.remover(editora.getEndereco().getCodigo());
	}
	
	public void alterar(Editora editora) throws ExcecaoNegocio {
		Editora e = this.consultar(editora.getCodigo());
		editora.getEndereco().setCodigo(e.getEndereco().getCodigo());
		contEnderecos.alterar(editora.getEndereco());
		repEditoras.alterar(editora);
	}

}

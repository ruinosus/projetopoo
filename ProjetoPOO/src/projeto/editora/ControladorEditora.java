package projeto.editora;

import java.util.ArrayList;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;


public class ControladorEditora {
	
	private IRepositorioEditoras repEditoras;
	private IRepositorioEnderecos repEnderecos;
	
	public ControladorEditora(IRepositorioEditoras repEditoras,IRepositorioEnderecos repEnderecos) {
		this.repEditoras = repEditoras;
		this.repEnderecos = repEnderecos;
	}
	
	public void cadastrar(Editora editora)throws ExcecaoNegocio {		
		editora.setEndereco(repEnderecos.inserir(editora.getEndereco()));
		repEditoras.inserir(editora);		
	}
	
	public Editora consultar(int codigo) throws ExcecaoNegocio {
		Editora editora = repEditoras.consultarCodigo(codigo);
		Endereco endereco = repEnderecos.consultarCodigo(editora.getEndereco().getCodigo());		
		editora.setEndereco(endereco);
		
		if(editora==null){
			throw new ExcecaoNegocio("Nenhuma editora encontrada");
		}
		return editora;
	}
	
	public ArrayList<Editora> consultarNome(String nome) throws ExcecaoNegocio {
		ArrayList<Editora> editoras = repEditoras.consultarNome(nome);
		
		for(int i = 0; i< editoras.size(); i++){
			Endereco endereco = repEnderecos.consultarCodigo(editoras.get(i).getEndereco().getCodigo());		
			editoras.get(i).setEndereco(endereco); 
		}
	
		return editoras;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		Editora editora = repEditoras.consultarCodigo(codigo);
		repEditoras.remover(codigo);			
		repEnderecos.remover(editora.getEndereco().getCodigo());
	}
	
	public void atualizar(Editora editora) throws ExcecaoNegocio {
		repEnderecos.alterar(editora.getEndereco());
		repEditoras.alterar(editora);
		
	}

}

package projeto.autor;

import java.util.ArrayList;

import projeto.endereco.ControladorEnderecos;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;



public class ControladorAutores {
	
	private IRepositorioAutores repAutores;
	private ControladorEnderecos contEnderecos;
	
	public ControladorAutores(IRepositorioAutores repAutores,IRepositorioEnderecos repEnderecos) {
		this.repAutores = repAutores;
		this.contEnderecos = new ControladorEnderecos(repEnderecos);
	}
	
	public void inserir(Autor autor)throws ExcecaoNegocio {	
		if(!repAutores.existe(autor.getIdentidade())){
			autor.setEndereco(contEnderecos.inserir(autor.getEndereco()));
			repAutores.inserir(autor);	
		}else{
			throw new ExcecaoNegocio("Autor j� cadastrado");
		}				
	}
	
	public Autor consultar(int identidade) throws ExcecaoNegocio {
		Autor autor = repAutores.consultar(identidade);
		Endereco endereco = contEnderecos.consultar(autor.getEndereco().getCodigo());		
		autor.setEndereco(endereco);
		
		if(autor==null){
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
		return autor;
	}
	
	public ArrayList<Autor> consultar() throws ExcecaoNegocio {
		ArrayList<Autor> autores = repAutores.consultar();
		
		for(int i = 0; i< autores.size(); i++){
			Endereco endereco = contEnderecos.consultar(autores.get(i).getEndereco().getCodigo());		
    		autores.get(i).setEndereco(endereco); 
		}
	
		return autores;
	}
	
	public ArrayList<Autor> consultar(String nome) throws ExcecaoNegocio {
		ArrayList<Autor> autores = repAutores.consultar(nome);
		
		for(int i = 0; i< autores.size(); i++){
			Endereco endereco = contEnderecos.consultar(autores.get(i).getEndereco().getCodigo());		
    		autores.get(i).setEndereco(endereco); 
		}
	
		return autores;
	}
	
	public void remover(int identidade)throws ExcecaoNegocio{			
		if (this.repAutores.existe(identidade)) {		
			Autor autor = repAutores.consultar(identidade);
			repAutores.remover(identidade);			
			contEnderecos.remover(autor.getEndereco().getCodigo());
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}
	
	public void alterar(Autor autor) throws ExcecaoNegocio {		
		if (this.repAutores.existe(autor.getIdentidade())) {
			contEnderecos.alterar(autor.getEndereco());
			repAutores.alterar(autor);
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}

}

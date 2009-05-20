package projeto.autor;

import java.util.ArrayList;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;



public class ControladorAutores {
	
	private IRepositorioAutores repAutores;
	private IRepositorioEnderecos repEnderecos;
	
	public ControladorAutores(IRepositorioAutores repAutores,IRepositorioEnderecos repEnderecos) {
		this.repAutores = repAutores;
		this.repEnderecos = repEnderecos; 
	}
	
	public void cadastrar(Autor novoAutor)throws ExcecaoNegocio {	
		if(!repAutores.existe(novoAutor.getIdentidade())){
			novoAutor.setEndereco(repEnderecos.inserir(novoAutor.getEndereco()));
			repAutores.inserir(novoAutor);	
		}else{
			throw new ExcecaoNegocio("Autor já cadastrado");
		}				
	}
	
	public Autor consultarCodigo(int identidade) throws ExcecaoNegocio {
		Autor autor = repAutores.consultarCodigo(identidade);
		Endereco endereco = repEnderecos.consultarCodigo(autor.getEndereco().getCodigo());		
		autor.setEndereco(endereco);
		
		if(autor==null){
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
		return autor;
	}
	
	public ArrayList<Autor> consultarNome(String nome) throws ExcecaoNegocio {
		ArrayList<Autor> autores = repAutores.consultarNome(nome);
		
		for(int i = 0; i< autores.size(); i++){
			Endereco endereco = repEnderecos.consultarCodigo(autores.get(i).getEndereco().getCodigo());		
    		autores.get(i).setEndereco(endereco); 
		}
	
		return autores;
	}
	
	public void remover(int identidade)throws ExcecaoNegocio{			
		if (this.repAutores.existe(identidade)) {		
			repAutores.remover(identidade);
			Autor autor = repAutores.consultarCodigo(identidade);
			repEnderecos.remover(autor.getEndereco().getCodigo());
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}
	
	public void atualizar(Autor autor) throws ExcecaoNegocio {		
		if (this.repAutores.existe(autor.getIdentidade())) {
			repEnderecos.alterar(autor.getEndereco());
			repAutores.atualizar(autor);
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}

}

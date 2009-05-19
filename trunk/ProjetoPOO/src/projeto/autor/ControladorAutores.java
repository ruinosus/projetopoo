package projeto.autor;

import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;


public class ControladorAutores {
	
	private IRepositorioAutores repAutores;
	
	public ControladorAutores(IRepositorioAutores repAutores) {
		this.repAutores = repAutores;
	}
	
	public void cadastrar(Autor novoAutor)throws ExcecaoNegocio {	
		if(!repAutores.existe(novoAutor.getIdentidade())){
			repAutores.inserir(novoAutor);	
		}else{
			throw new ExcecaoNegocio("Autor já cadastrado");
		}				
	}
	
	public Autor consultarCodigo(int identidade) throws ExcecaoNegocio {
		Autor autor = repAutores.consultarCodigo(identidade);
		if(autor==null){
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
		return autor;
	}
	
	public ArrayList<Autor> consultarNome(String nome) throws ExcecaoNegocio {
		return repAutores.consultarNome(nome);
	}
	
	public void remover(int identidade)throws ExcecaoNegocio{	
		if (this.repAutores.existe(identidade)) {
			repAutores.remover(identidade);
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}
	
	public void atualizar(Autor autor) throws ExcecaoNegocio {		
		if (this.repAutores.existe(autor.getIdentidade())) {
			repAutores.atualizar(autor);
		}else{
			throw new ExcecaoNegocio("Nenhum autor encontrado");
		}
	}

}

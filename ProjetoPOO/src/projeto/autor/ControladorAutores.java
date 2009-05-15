package projeto.autor;

import projeto.excecao.ExcecaoNegocio;


public class ControladorAutores {
	
	private IRepositorioAutores repautores;
	
	public ControladorAutores(IRepositorioAutores repautores) {
		this.repautores = repautores;
	}
	
	public void cadastrar(Autor novoAutor)throws ExcecaoNegocio {
		if(!repautores.existe(novoAutor.getIdentidade())){
			repautores.inserir(novoAutor);
		}else{
			throw new ExcecaoNegocio ("Erro: Autor ja Existe no Sistema.");
		}
		 }
	
	public Autor consultar(String id) {
		return repautores.consultar(id);
	}
	
	public void remover(String id)throws ExcecaoNegocio{
		if(this.repautores.existe(id)) {
			repautores.remover(id);
		}else{
			throw new ExcecaoNegocio("Erro: Autor informado não existe no cadastro de Autores.");
		  }
	}
	
	public void atualizar(Autor autor) {
		repautores.atualizar(autor);
	}

}

package projeto.editora;

import projeto.autor.Autor;
import projeto.excecao.ExcecaoNegocio;


public class ControladorEditora {
	
	private IRepositorioEditoras repEditoras;
	
	public ControladorEditora(IRepositorioEditoras repEditoras) {
		this.repEditoras = repEditoras;
	}
	
	public void cadastrar(Editora editora)throws ExcecaoNegocio {
		/*if(!repLotesLivro.existe(novoAutor.getIdentidade())){
			repLotesLivro.inserir(novoAutor);
		}else{
			throw new ExcecaoNegocio ("Erro: Autor ja Existe no Sistema.");
		}*/
		 }
	
	public Autor consultar(int codigo) {
		return null ;//repLotesLivro.consultar(id);
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		/*if(this.repLotesLivro.existe(id)) {
			repLotesLivro.remover(id);
		}else{
			throw new ExcecaoNegocio("Erro: Autor informado não existe no cadastro de Autores.");
		  }*/
	}
	
	public void atualizar(Editora editora) {
		//repLotesLivro.atualizar(autor);
	}

}

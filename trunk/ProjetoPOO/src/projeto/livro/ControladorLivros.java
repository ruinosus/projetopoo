package projeto.livro;

import projeto.excecao.ExcecaoNegocio;

public class ControladorLivros {
	
	private IRepositorioLivros replivros;
	
	public ControladorLivros(IRepositorioLivros replivros) {
		this.replivros = replivros;
	}
	
	public void cadastrar(Livro novoLivro)throws ExcecaoNegocio {
		if(!replivros.existe(novoLivro.getIsbn())){
			 replivros.inserir(novoLivro);
		}else{
			throw new ExcecaoNegocio ("Erro: Livro ja Existe no Sistema.");
		}
		 }
	
	public Livro consultar(String isbn) {
		return replivros.consultar(isbn);
	}
	
	public void remover(String isbn)throws ExcecaoNegocio{
		if(this.replivros.existe(isbn)) {
			replivros.remover(isbn);
		}else{
			throw new ExcecaoNegocio("Erro: Livro informado não existe no cadastro de Livros.");
		  }
	}

	public void atualizar(Livro livros) {
		replivros.atualizar(livros);
	}

}

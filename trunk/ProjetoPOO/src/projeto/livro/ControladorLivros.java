package projeto.livro;

import java.util.ArrayList;

import projeto.autor.Autor;
import projeto.autor.ControladorAutores;
import projeto.autor.IRepositorioAutores;
import projeto.editora.ControladorEditoras;
import projeto.editora.IRepositorioEditoras;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;

public class ControladorLivros {
	
	private IRepositorioLivros repLivros;
	private ControladorAutores contAutores;
	private ControladorEditoras contEditoras;	
	
	public ControladorLivros(IRepositorioLivros replivros,
			IRepositorioAutores repAutores,
			IRepositorioEditoras repEditoras,
			IRepositorioEnderecos repEnderecos) {
		this.repLivros = replivros;
		this.contAutores = new ControladorAutores(repAutores,repEnderecos) ;
		this.contEditoras = new ControladorEditoras(repEditoras,repEnderecos) ;;
	}
	
	public void inserir(Livro livro)throws ExcecaoNegocio {
		if(!repLivros.existe(livro.getIsbn())){
			 repLivros.inserir(livro);
			 if(livro.getAutor().size() > 0){
				 for(int i=0; i <livro.getAutor().size(); i++ ){
					 int identidade = livro.getAutor().get(i).getIdentidade();
					 int isbn = livro.getIsbn();
					 this.repLivros.inserirLivroAutor(isbn, identidade);
				 }
			 }
		}else{
			throw new ExcecaoNegocio ("Erro: Livro ja Existe no Sistema.");
		}
	}
	
	public Livro consultar(int isbn) throws ExcecaoNegocio {
		return repLivros.consultar(isbn);
	}
	public ArrayList<Livro> consultar(String titulo) throws ExcecaoNegocio {
		ArrayList<Livro> livros = repLivros.consultar(titulo);
		
		for(int i = 0; i< livros.size(); i++){
			Livro livro = livros.get(i);		
			livros.set(i, this.montarLivro(livro)); 
		}
	
		return livros;
	}
	
	public ArrayList<Livro> consultar() throws ExcecaoNegocio {
		ArrayList<Livro> livros = repLivros.consultar();
		
		for(int i = 0; i< livros.size(); i++){
			Livro livro = livros.get(i);		
			livros.set(i, this.montarLivro(livro)); 
		}
	
		return livros;
	}
	
	public void remover(int isbn)throws ExcecaoNegocio{
		if(this.repLivros.existe(isbn)) {
			repLivros.remover(isbn);
		}else{
			throw new ExcecaoNegocio("Erro: Livro informado não existe no cadastro de Livros.");
		  }
	}

	public void alterar(Livro livros) throws ExcecaoNegocio {
		repLivros.alterar(livros);
	}
	
	@SuppressWarnings("unused")
	private Livro montarLivro(Livro livro) throws ExcecaoNegocio{
		
		for (int i = 0; i < livro.getAutor().size(); i++) {
			int identidade = livro.getAutor().get(i).getIdentidade();
			Autor autor = this.contAutores.consultar(identidade);
			livro.getAutor().set(i, autor);				
		}
		livro.setEditora(this.contEditoras.consultar(livro.getEditora().getCodigo()));
		return livro;
	}

}

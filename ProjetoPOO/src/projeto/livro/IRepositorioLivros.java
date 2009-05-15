package projeto.livro;

public interface IRepositorioLivros {
	
	public void inserir(Livro novoLivro);
	
	public Livro consultar(String isbn);
	
	public void atualizar(Livro novoLivro);
	
	public void remover(String isbn);
	
	public boolean existe(String isbn);

}

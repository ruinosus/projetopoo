package projeto.livro;

public interface IRepositorioLivros {
	
	public void inserir(Livro novoLivro);
	
	public Livro consultar(int isbn);
	
	public void atualizar(Livro novoLivro);
	
	public void remover(int isbn);
	
	public boolean existe(int isbn);

}

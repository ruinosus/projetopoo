package projeto.autor;

public interface IRepositorioAutores {
	
	public void inserir(Autor novoAutor);
	
	public Autor consultar(String id);
	
	public void atualizar(Autor novoAutor);
	
	public void remover(String id);
	
	public boolean existe(String id);

}

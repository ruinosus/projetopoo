package projeto.loteLivro;

import projeto.autor.Autor;
import projeto.excecao.ExcecaoNegocio;

public class ControladorLoteLivro {

	private IRepositorioLotesLivro repLotesLivro;
	
	public ControladorLoteLivro(IRepositorioLotesLivro repLotesLivro) {
		this.repLotesLivro = repLotesLivro;
	}
	
	public void cadastrar(LoteLivro loteLivro)throws ExcecaoNegocio {
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
	
	public void atualizar(LoteLivro loteLivro) {
		//repLotesLivro.atualizar(autor);
	}
}

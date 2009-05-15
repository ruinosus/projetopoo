package projeto.grafica;

import projeto.autor.Autor;
import projeto.excecao.ExcecaoNegocio;

public class ControladorGraficaEmpresa {

	private IRepositorioGraficasEmpresa repGraficasEmpresa;
	
	public ControladorGraficaEmpresa(IRepositorioGraficasEmpresa repGraficasEmpresa) {
		this.repGraficasEmpresa = repGraficasEmpresa;
	}
	
	public void cadastrar(GraficaEmpresa graficaEmpresa)throws ExcecaoNegocio {
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
	
	public void atualizar(GraficaEmpresa graficaEmpresa) {
		//repLotesLivro.atualizar(autor);
	}

}

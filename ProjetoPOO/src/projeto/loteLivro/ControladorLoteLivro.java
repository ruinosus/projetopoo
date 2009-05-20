package projeto.loteLivro;

import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;
import projeto.grafica.IRepositorioGraficasEmpresa;
import projeto.livro.IRepositorioLivros;
import projeto.livro.Livro;

public class ControladorLoteLivro {

	private IRepositorioLotesLivro repLotesLivro;
	private IRepositorioGraficasEmpresa repGraficas;
	private IRepositorioLivros repLivros;
	
	public ControladorLoteLivro(IRepositorioLotesLivro repLotesLivro,IRepositorioGraficasEmpresa repGraficas,IRepositorioLivros repLivros) {
		this.repLotesLivro = repLotesLivro;
		this.repLivros = repLivros;
		this.repGraficas = repGraficas;		
	}
	
	public void cadastrar(LoteLivro loteLivro)throws ExcecaoNegocio {
			repLotesLivro.inserir(loteLivro);
		 }
	
	public LoteLivro consultar(int codigo) throws ExcecaoNegocio {
		
		LoteLivro loteLivro = this.repLotesLivro.consultarCodigo(codigo);		
		
		return this.montarLoteLivro(loteLivro) ;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		this.repLotesLivro.remover(codigo);	
	}
	
	public void atualizar(LoteLivro loteLivro) throws ExcecaoNegocio {
		this.repLotesLivro.alterar(loteLivro);
	}
	
	public LoteLivro montarLoteLivro(LoteLivro loteLivro) throws ExcecaoNegocio{
		
		Grafica grafica = this.repGraficas.consultarCodigo(loteLivro.getGrafica().getCodigo());
		Livro livro = this.repLivros.consultar(loteLivro.getLivro().getIsbn());
		loteLivro.setGrafica(grafica);
		loteLivro.setLivro(livro);
		
		return loteLivro;
	}
}

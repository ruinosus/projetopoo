package projeto.loteLivro;

import java.util.ArrayList;

import projeto.autor.Autor;
import projeto.autor.IRepositorioAutores;


import projeto.contrato.IRepositorioContratos;
import projeto.editora.IRepositorioEditoras;

import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.ControladorGraficas;
import projeto.grafica.Grafica;

import projeto.grafica.IRepositorioGraficasEmpresas;
import projeto.grafica.IRepositorioGraficasTerceirizadas;
import projeto.livro.ControladorLivros;
import projeto.livro.IRepositorioLivros;
import projeto.livro.Livro;

public class ControladorLotesLivros {

	private IRepositorioLotesLivros repLotesLivro;
	private ControladorGraficas contGrafica;
	private ControladorLivros contLivro;	
	
	public ControladorLotesLivros(IRepositorioLotesLivros repLotesLivro,
			IRepositorioGraficasEmpresas repGraficasEmpresa,
			IRepositorioGraficasTerceirizadas repGraficasTerceirizada,
			IRepositorioLivros repLivros,
			IRepositorioEnderecos repEndereco,
			IRepositorioAutores repAutor,
			IRepositorioEditoras repEditora,
			IRepositorioContratos repContrato) {
		
		this.repLotesLivro = repLotesLivro;			
		this.contGrafica = new ControladorGraficas(repGraficasEmpresa,repGraficasTerceirizada,repEndereco,repContrato);
		this.contLivro = new ControladorLivros(repLivros,repAutor,repEditora,repEndereco);
		
	}
	
	public void inserir(LoteLivro loteLivro)throws ExcecaoNegocio {
			repLotesLivro.inserir(loteLivro);
		 }
	
	public LoteLivro consultar(int codigo) throws ExcecaoNegocio {
		
		LoteLivro loteLivro = this.repLotesLivro.consultar(codigo);		
		if(loteLivro==null)
			throw new ExcecaoNegocio("Lote não encontrado no sistema.");
		
		
		return this.montarLoteLivro(loteLivro) ;
	}
	
	public void remover(int codigo)throws ExcecaoNegocio{
		this.consultar(codigo);
		this.repLotesLivro.remover(codigo);	
	}
	
	public void alterar(LoteLivro loteLivro) throws ExcecaoNegocio {
		this.consultar(loteLivro.getCodigo());
		this.repLotesLivro.alterar(loteLivro);
	}
	
	private LoteLivro montarLoteLivro(LoteLivro loteLivro) throws ExcecaoNegocio{		
		Grafica grafica = this.contGrafica.consultar(loteLivro.getGrafica().getCodigo());
		
		Livro livro = this.contLivro.consultar(loteLivro.getLivro().getIsbn());
		loteLivro.setGrafica(grafica);
		loteLivro.setLivro(livro);
		
		return loteLivro;
	}
	
	public ArrayList<LoteLivro> consultar() throws ExcecaoNegocio {
		ArrayList<LoteLivro> lotesLivro = repLotesLivro.consultar();
		
		for(int i = 0; i< lotesLivro.size(); i++){
			LoteLivro loteLivro = lotesLivro.get(i);		
			lotesLivro.set(i, this.montarLoteLivro(loteLivro)); 

		}
	
		return lotesLivro;
	}
	

}

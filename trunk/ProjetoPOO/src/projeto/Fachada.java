package projeto;

import java.util.ArrayList;

import projeto.autor.Autor;
import projeto.autor.ControladorAutores;
import projeto.autor.IRepositorioAutores;
import projeto.autor.RepositorioAutores;
import projeto.contrato.Contrato;
import projeto.contrato.ControladorContratos;
import projeto.contrato.IRepositorioContratos;
import projeto.contrato.RepositorioContratos;
import projeto.editora.ControladorEditoras;
import projeto.editora.Editora;
import projeto.editora.IRepositorioEditoras;
import projeto.editora.RepositorioEditoras;
import projeto.endereco.ControladorEnderecos;
import projeto.endereco.Endereco;
import projeto.endereco.IRepositorioEnderecos;
import projeto.endereco.RepositorioEnderecos;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.ControladorGraficas;
import projeto.grafica.Grafica;
import projeto.grafica.IRepositorioGraficasEmpresas;
import projeto.grafica.IRepositorioGraficasTerceirizadas;
import projeto.grafica.RepositorioGraficasEmpresas;
import projeto.grafica.RepositorioGraficasTerceirizadas;
import projeto.livro.ControladorLivros;
import projeto.livro.IRepositorioLivros;
import projeto.livro.Livro;
import projeto.livro.RepositorioLivros;
import projeto.loteLivro.ControladorLotesLivros;
import projeto.loteLivro.IRepositorioLotesLivros;
import projeto.loteLivro.LoteLivro;
import projeto.loteLivro.RepositorioLotesLivros;


public class Fachada {
	private static Fachada instancia;
	
	  private ControladorContratos controladorContratos;
	  private ControladorAutores controladorAutores;
	  private ControladorEnderecos controladorEnderecos;
	  private ControladorEditoras controladorEditoras;
	  private ControladorGraficas controladorGraficas;
	  private ControladorLivros controladorLivros;
	  private ControladorLotesLivros controladorLotesLivros;
	
	  private Fachada() {
	    initControladores();
	  }
	  
	  private void initControladores() {
		  //controlador contrato
		  IRepositorioContratos IRepContratos = new RepositorioContratos();
		  this.controladorContratos = new ControladorContratos(IRepContratos);	
		  //controlador endereco
		  IRepositorioEnderecos IRepEnderecos = new RepositorioEnderecos();
		  this.controladorEnderecos = new ControladorEnderecos(IRepEnderecos);
		  //controlador autore
		  IRepositorioAutores IRepAutores = new RepositorioAutores();
		  this.controladorAutores = new ControladorAutores(IRepAutores,IRepEnderecos);
		  //controlador editora
		  IRepositorioEditoras IRepEditoras = new RepositorioEditoras();
		  this.controladorEditoras = new ControladorEditoras(IRepEditoras,IRepEnderecos);
		  //controlador grafica
		  IRepositorioGraficasEmpresas IRepGraficasEmpresas = new RepositorioGraficasEmpresas();
		  IRepositorioGraficasTerceirizadas IRepGraficasTerceirizadas = new RepositorioGraficasTerceirizadas();
		  this.controladorGraficas = new ControladorGraficas(IRepGraficasEmpresas,IRepGraficasTerceirizadas,IRepEnderecos,IRepContratos);
		  //controlador livro
		  IRepositorioLivros IRepLivros = new RepositorioLivros();		
		  this.controladorLivros = new ControladorLivros(IRepLivros,IRepAutores,IRepEditoras,IRepEnderecos);
		  //controlador lote livro
		  IRepositorioLotesLivros IRepLotesLivros = new RepositorioLotesLivros();		
		  this.controladorLotesLivros = new ControladorLotesLivros(IRepLotesLivros,IRepGraficasEmpresas,IRepGraficasTerceirizadas,IRepLivros,IRepEnderecos,IRepAutores,IRepEditoras,IRepContratos);
	  }
	  
	  public static Fachada obterInstancia() {
	    if (instancia == null) {
	      instancia = new Fachada();
	    }
	    return instancia;
	  }
	  
	  //FACHADA PARA CONTRATO
	  public void inserirContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContratos.inserir(contrato);
	  }
	  
	  public void removerContrato(int codigo) throws ExcecaoNegocio{
		 this.controladorContratos.remover(codigo);
	  }
	  
      public void alterarContrato(Contrato contrato) throws ExcecaoNegocio{
		  this.controladorContratos.alterar(contrato);
	  }
      
      public ArrayList<Contrato> consultarContrato(String nome)throws ExcecaoNegocio{
    	 return this.controladorContratos.consultar(nome);
      }
      public ArrayList<Contrato> consultarContrato()throws ExcecaoNegocio{
     	 return this.controladorContratos.consultar();
       }
      
      public Contrato consultarContrato(int codigo)throws ExcecaoNegocio{
     	 return this.controladorContratos.consultar(codigo);
      }
      //FACHADA PARA AUTOR
	  public void inserirAutor(Autor autor) throws ExcecaoNegocio{
		  this.controladorAutores.inserir(autor);
	  }
	  
	  public void removerAutor(int codigo) throws ExcecaoNegocio{
		 this.controladorAutores.remover(codigo);
	  }
	  
      public void alterarAutor(Autor autor) throws ExcecaoNegocio{
		  this.controladorAutores.alterar(autor);
	  }
      
      public ArrayList<Autor> consultarAutor(String nome)throws ExcecaoNegocio{
    	 return this.controladorAutores.consultar(nome);
      }
      public ArrayList<Autor> consultarAutor()throws ExcecaoNegocio{
     	 return this.controladorAutores.consultar();
       }
      
      public Autor consultarAutor(int codigo)throws ExcecaoNegocio{
     	 return this.controladorAutores.consultar(codigo);
      }
      //FACHADA PARA ENDERECO
	  public void inserirEndereco(Endereco endereco) throws ExcecaoNegocio{
		  this.controladorEnderecos.inserir(endereco);
	  }
	  
	  public void removerEndereco(int codigo) throws ExcecaoNegocio{
		 this.controladorEnderecos.remover(codigo);
	  }
	  
      public void alterarEndereco(Endereco endereco) throws ExcecaoNegocio{
		  this.controladorEnderecos.alterar(endereco);
	  }      
      
      public Endereco consultarEndereco(int codigo)throws ExcecaoNegocio{
     	 return this.controladorEnderecos.consultar(codigo);
      }
      //FACHADA PARA EDITORA
	  public void inserirEditora(Editora editora) throws ExcecaoNegocio{
		  this.controladorEditoras.inserir(editora);
	  }
	  
	  public void removerEditora(int codigo) throws ExcecaoNegocio{
		 this.controladorEditoras.remover(codigo);
	  }
	  
      public void alterarEditora(Editora editora) throws ExcecaoNegocio{
		  this.controladorEditoras.alterar(editora);
	  }
      
      public ArrayList<Editora> consultarEditora(String nome)throws ExcecaoNegocio{
    	 return this.controladorEditoras.consultar(nome);
      }
      public ArrayList<Editora> consultarEditora()throws ExcecaoNegocio{
     	 return this.controladorEditoras.consultar();
       }
      
      public Editora consultarEditora(int codigo)throws ExcecaoNegocio{
     	 return this.controladorEditoras.consultar(codigo);
      }
      //FACHADA PARA GRAFICA
	  public void inserirGrafica(Grafica grafica) throws ExcecaoNegocio{
		  this.controladorGraficas.inserir(grafica);
	  }
	  
	  public void removerGrafica(int codigo) throws ExcecaoNegocio{
		 this.controladorGraficas.remover(codigo);
	  }
	  
      public void alterarGrafica(Grafica grafica) throws ExcecaoNegocio{
		  this.controladorGraficas.alterar(grafica);
	  }
      
      public ArrayList<Grafica> consultarGrafica(String nome)throws ExcecaoNegocio{
    	 return this.controladorGraficas.consultar(nome);
      }
      public ArrayList<Grafica> consultarGrafica()throws ExcecaoNegocio{
     	 return this.controladorGraficas.consultar();
      }
      
      public Grafica consultarGrafica(int codigo)throws ExcecaoNegocio{
     	 return this.controladorGraficas.consultar(codigo);
      }
   	  //FACHADA PARA LIVRO
	  public void inserirLivro(Livro livro) throws ExcecaoNegocio{
		  this.controladorLivros.inserir(livro);
	  }
	  
	  public void removerLivro(int codigo) throws ExcecaoNegocio{
		 this.controladorLivros.remover(codigo);
	  }
	  
      public void alterarLivro(Livro livro) throws ExcecaoNegocio{
		  this.controladorLivros.alterar(livro);
	  }
      
      public ArrayList<Livro> consultarLivro(String nome)throws ExcecaoNegocio{
    	 return this.controladorLivros.consultar(nome);
      }
      public ArrayList<Livro> consultarLivro()throws ExcecaoNegocio{
     	 return this.controladorLivros.consultar();
      }
      
      public Livro consultarLivro(int codigo)throws ExcecaoNegocio{
     	 return this.controladorLivros.consultar(codigo);
      }
    //FACHADA PARA LOTE LIVRO
	  public void inserirLoteLivro(LoteLivro loteLivro) throws ExcecaoNegocio{
		  this.controladorLotesLivros.inserir(loteLivro);
	  }
	  
	  public void removerLoteLivro(int codigo) throws ExcecaoNegocio{
		 this.controladorLotesLivros.remover(codigo);
	  }
	  
      public void alterarLoteLivro(LoteLivro livro) throws ExcecaoNegocio{
		  this.controladorLotesLivros.alterar(livro);
	  }      
     
      public LoteLivro consultarLoteLivro(int codigo)throws ExcecaoNegocio{
     	 return this.controladorLotesLivros.consultar(codigo);
      }
	  
}

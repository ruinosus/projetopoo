package projeto.livro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.autor.Autor;
import projeto.editora.Editora;
import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioLivros implements IRepositorioLivros{

	private static final String QUERY_INSERT = "INSERT INTO LIVRO (COD_LIVRO,COD_EDITORA,TITULO,DATA_PUBLICACAO) VALUES (?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE LIVRO SET (COD_EDITORA = ?,TITULO = ?,DATA_PUBLICACAO = ?) WHERE COD_LIVRO = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_LIVRO,COD_EDITORA,TITULO,DATA_PUBLICACAO FROM LIVRO WHERE COD_LIVRO = ?";
	private static final String QUERY_SELECT_TITULO = "SELECT COD_LIVRO,COD_EDITORA,TITULO,DATA_PUBLICACAO FROM LIVRO WHERE TITULO LIKE ?" ;
	private static final String QUERY_SELECT_ALL = "SELECT COD_LIVRO,COD_EDITORA,TITULO,DATA_PUBLICACAO FROM LIVRO " ;
	private static final String QUERY_DELETE = "DELETE FROM LIVRO WHERE COD_LIVRO = ?";
	private static final String QUERY_INSERT_LIVRO_AUTOR = "INSERT INTO AUTOR_LIVRO (COD_LIVRO,COD_AUTOR) VALUES (?,?)";
	private static final String QUERY_DELETE_LIVRO_AUTOR = "DELETE FROM AUTOR_LIVRO WHERE COD_LIVRO = ? AND COD_AUTOR = ?";
	private static final String QUERY_SELECT_CODIGO_LIVRO_AUTOR = "SELECT COD_LIVRO,COD_AUTOR FROM AUTOR_LIVRO WHERE COD_LIVRO = ?";
	
	public void alterar(Livro novoLivro)throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setString(1, novoLivro.getTitulo());
			comando.setDate(2, (Date) novoLivro.getDataPublicacao());
			comando.setInt(3, novoLivro.getIsbn());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	
	@SuppressWarnings("finally")
	public Livro consultar(int isbn)throws ExcecaoNegocio {
		Livro livro = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, isbn);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				livro = this.criarLivro(rs) ;
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return livro;
		}
	}

	
	public boolean existe(int isbn)throws ExcecaoNegocio {
		boolean resultado = false;
		
		if(this.consultar(isbn)!= null){
			resultado = true;
		}
		
		return resultado;
	}

	
	public void inserir(Livro novoLivro)throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, novoLivro.getIsbn());		
			comando.setInt(2, novoLivro.getEditora().getCodigo());
			comando.setString(3, novoLivro.getTitulo());
			comando.setDate(4, (Date) novoLivro.getDataPublicacao());
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	
	public void remover(int isbn)throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_DELETE);
			comando.setInt(1, isbn);
			comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}


	@SuppressWarnings("finally")
	public ArrayList<Livro> consultar() throws ExcecaoNegocio {
		ArrayList<Livro>  livros = new ArrayList<Livro> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_ALL);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				livros.add(this.criarLivro(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return livros;
		}
	}


	public void inserirLivroAutor(int isbn, int identidade) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT_LIVRO_AUTOR); 
			comando.setInt(1, isbn);		
			comando.setInt(2, identidade);
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}


	public void removerLivroAutor(int isbn) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_DELETE_LIVRO_AUTOR);
			comando.setInt(1, isbn);
			comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}
	
	@SuppressWarnings("unused")
	private Livro criarLivro(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int isbn = rs.getInt("COD_LIVRO");
		int codEditora = rs.getInt("COD_EDITORA");
		String titulo = rs.getString("TITULO");
		Date datapublicacao = rs.getDate("COD_LIVRO");
		Editora editora = new Editora();
		editora.setCodigo(codEditora);

		ArrayList<Autor>  autores = this.consultarPorLivro(isbn);
		
		return new Livro(isbn,titulo,editora,datapublicacao,autores);
	}
	
	@SuppressWarnings("finally")
	private ArrayList<Autor> consultarPorLivro(int isbn) throws ExcecaoNegocio {
		ArrayList<Autor>  autores = new ArrayList<Autor> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO_LIVRO_AUTOR);
			comando.setInt(1,isbn);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				Autor autor = new Autor();
				int identidade = rs.getInt("COD_AUTOR");
				autor.setIdentidade(identidade);
				autores.add(autor);
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return autores;
		}
	}


	@SuppressWarnings("finally")
	public ArrayList<Livro> consultar(String titulo) throws ExcecaoNegocio {
		ArrayList<Livro>  livros = new ArrayList<Livro> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_TITULO);
			comando.setString(1,"%"+titulo+"%");
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				livros.add(this.criarLivro(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return livros;
		}
	}

}

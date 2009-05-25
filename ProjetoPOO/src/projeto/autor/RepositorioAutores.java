package projeto.autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioAutores implements IRepositorioAutores{

	private static final String QUERY_INSERT = "INSERT INTO AUTOR (COD_AUTOR,COD_ENDERECO,NOME) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE AUTOR SET (COD_ENDERECO = ?, NOME = ?) WHERE COD_AUTOR = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_AUTOR,COD_ENDERECO,NOME FROM AUTOR WHERE COD_AUTOR = ?";
	private static final String QUERY_SELECT_NOME = "SELECT COD_AUTOR,COD_ENDERECO,NOME FROM AUTOR WHERE NOME LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM AUTOR WHERE COD_AUTOR = ?";
	private static final String QUERY_SELECT_ALL = "SELECT COD_AUTOR,COD_ENDERECO,NOME FROM AUTOR" ;
	
	
	public void alterar(Autor autor) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setInt(1, autor.getEndereco().getCodigo());
			comando.setString(2, autor.getNome());
			comando.setInt(3, autor.getIdentidade());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}

	@SuppressWarnings("finally")
	public Autor consultar(int identidade) throws ExcecaoNegocio {
		Autor autor = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, identidade);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				autor = this.criarAutor(rs) ;
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return autor;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Autor> consultar(String nome) throws ExcecaoNegocio {
		ArrayList<Autor>  autores = new ArrayList<Autor> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_NOME);
			comando.setString(1,"%"+nome+"%");
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				autores.add(this.criarAutor(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return autores;
		}
	}

	public void inserir(Autor autor) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, autor.getIdentidade());		
			comando.setInt(2, autor.getEndereco().getCodigo());
			comando.setString(3, autor.getNome());
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	public void remover(int identidade) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_DELETE);
			comando.setInt(1, identidade);
			comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	private Autor criarAutor(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codAutor = rs.getInt("COD_AUTOR");
		int codEndereco = rs.getInt("COD_ENDERECO");
		String nome = rs.getString("NOME");
		Endereco endereco = new Endereco();
		endereco.setCodigo(codEndereco);	
		
		return new Autor(codAutor,nome,endereco);
	}

	public boolean existe(int identidade) throws ExcecaoNegocio {
		boolean resultado = false;
		
		if(this.consultar(identidade)!= null){
			resultado = true;
		}
		
		return resultado;
	}

	@SuppressWarnings("finally")
	public ArrayList<Autor> consultar() throws ExcecaoNegocio {
		ArrayList<Autor>  autores = new ArrayList<Autor> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_ALL);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				autores.add(this.criarAutor(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return autores;
		}
	}
	
	
}

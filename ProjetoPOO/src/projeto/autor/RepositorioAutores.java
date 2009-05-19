package projeto.autor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.contrato.Contrato;
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;
import projeto.livro.Livro;
import projeto.loteLivro.LoteLivro;
import projeto.util.UtilBD;

public class RepositorioAutores implements IRepositorioAutores{

	private static final String QUERY_INSERT = "INSERT INTO AUTOR (COD_AUTOR,COD_ENDERECO,NOME) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE AUTOR SET (COD_ENDERECO = ?, NOME = ?) WHERE COD_AUTOR = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_AUTOR,COD_ENDERECO,NOME FROM AUTOR WHERE COD_AUTOR = ?";
	//private static final String QUERY_MAXIMO_CODIGO = "SELECT MAX(COD_CONTRATO) MAXCOD FROM CONTRATO";
	private static final String QUERY_SELECT_NOME = "SELECT COD_AUTOR,COD_ENDERECO,NOME FROM AUTOR WHERE NOME LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM AUTOR WHERE COD_AUTOR = ?";
	
	
	public void atualizar(Autor novoAutor) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setInt(1, novoAutor.getEndereco().getCodigo());
			comando.setString(2, novoAutor.getNome());
			comando.setInt(3, novoAutor.getIdentidade());
			comando.executeUpdate();
			System.out.println("Altera��o com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}

	@SuppressWarnings("finally")
	public Autor consultarCodigo(int identidade) throws ExcecaoNegocio {
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
	public ArrayList<Autor> consultarNome(String nome) throws ExcecaoNegocio {
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

	public void inserir(Autor novoAutor) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, novoAutor.getIdentidade());		
			comando.setInt(2, novoAutor.getEndereco().getCodigo());
			comando.setString(3, novoAutor.getNome());
			comando.executeUpdate();
			System.out.println("Inser��o com Sucesso!");
			
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
			int linhasAlteradas = comando.executeUpdate();			
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
		
		if(this.consultarCodigo(identidade)!= null){
			resultado = true;
		}
		
		return resultado;
	}
	
	
}

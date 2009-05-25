package projeto.loteLivro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;
import projeto.livro.Livro;
import projeto.util.UtilBD;

public class RepositorioLotesLivros implements IRepositorioLotesLivros {

	private static final String QUERY_INSERT = "INSERT INTO IMPRESSAO (COD_GRAFICA,COD_LIVRO,NUMERO_COPIAS,DATA_ENTREGA) VALUES (?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE IMPRESSAO SET (COD_GRAFICA=?,COD_LIVRO=?,NUMERO_COPIAS=?,DATA_ENTREGA=?) WHERE COD_IMPRESSAO = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_IMPRESSAO,COD_GRAFICA,COD_LIVRO,NUMERO_COPIAS,DATA_ENTREGA FROM IMPRESSAO WHERE COD_IMPRESSAO = ?";
	//private static final String QUERY_MAXIMO_CODIGO = "SELECT MAX(COD_CONTRATO) MAXCOD FROM CONTRATO";
	private static final String QUERY_DELETE = "DELETE FROM IMPRESSAO WHERE COD_IMPRESSAO = ?";
	
	
	public void alterar(LoteLivro loteLivro) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setInt(1, loteLivro.getGrafica().getCodigo());
			comando.setInt(2, loteLivro.getLivro().getIsbn());
			comando.setInt(3, loteLivro.getNumeroCopias());
			comando.setDate(4, (Date) loteLivro.getDataEntrega());
			comando.setInt(5, loteLivro.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}

	
	@SuppressWarnings("finally")
	public LoteLivro consultar(int codigo) throws ExcecaoNegocio {
		LoteLivro loteLivro = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				loteLivro = this.criarLoteLivro(rs) ;
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return loteLivro;
		}
	}

	
	public void inserir(LoteLivro loteLivro) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, loteLivro.getGrafica().getCodigo());
			comando.setInt(2, loteLivro.getLivro().getIsbn());
			comando.setInt(3, loteLivro.getNumeroCopias());
			comando.setDate(4, (Date) loteLivro.getDataEntrega());
			
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}

	
	public void remover(int codigo) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_DELETE);
			comando.setInt(1, codigo);
			comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}
	
	@SuppressWarnings("unused")
	private LoteLivro criarLoteLivro(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codLoteLivro = rs.getInt("COD_IMPRESSAO");
		int codLivro = rs.getInt("COD_LIVRO");
		int codGrafica = rs.getInt("COD_GRAFICA");
		int numeroCopias = rs.getInt("NUMERO_COPIAS");
		Date d = rs.getDate("DATA_ENTREGA");
		
		Livro livro = new Livro();
		livro.setIsbn(codLivro);
		Grafica grafica = new Grafica();
		grafica.setCodigo(codGrafica);		
		
		return new LoteLivro(codLoteLivro,livro,grafica,d,numeroCopias);
	}

}

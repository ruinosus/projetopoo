package projeto.grafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioGraficasEmpresa implements IRepositorioGraficasEmpresa {
	private static final String QUERY_INSERT = "INSERT INTO GRAFICA (COD_GRAFICA,NOME) VALUES (?,?)";
	private static final String QUERY_UPDATE = "UPDATE GRAFICA SET (NOME = ?) WHERE COD_GRAFICA = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT * FROM GRAFICA WHERE COD_GRAFICA = ?";
	private static final String QUERY_SELECT_NOME = "SELECT * FROM GRAFICA WHERE NOME LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM GRAFICA WHERE COD_GRAFICA = ?";
	@Override
	
	public void alterar(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setString(1, graficaEmpresa.getNome() );
			comando.setInt(2, graficaEmpresa.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}

	@Override
	public GraficaEmpresa consultarCodigo(int num_identificacao)
			throws ExcecaoNegocio {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GraficaEmpresa> consultarNome(String nome)
			throws ExcecaoNegocio {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, graficaEmpresa.getCodigo());
			comando.setString(2, graficaEmpresa.getNome());
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}

	@Override
	public void remover(int codigo) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_DELETE);
			comando.setInt(1, codigo);
			int linhasAlteradas = comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}

	private GraficaEmpresa criarGraficaEmpresa(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codGraficaEmpresa = rs.getInt("COD_GRAFICA");		
		String nome = rs.getString("NOME");

		return new GraficaEmpresa(codGraficaEmpresa,nome);	
	}
}

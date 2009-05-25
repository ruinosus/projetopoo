package projeto.grafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioGraficasEmpresas implements IRepositorioGraficasEmpresas {

	private static final String QUERY_INSERT = "INSERT INTO GRAFICA (NOME) VALUES (?)";
	private static final String QUERY_UPDATE = "UPDATE GRAFICA SET NOME = ? WHERE COD_GRAFICA = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_GRAFICA,NOME FROM GRAFICA WHERE COD_GRAFICA = ?";
	private static final String QUERY_ULTIMO_CODIGO = "SELECT MAX(COD_GRAFICA) MAXCOD FROM GRAFICA";	
	private static final String QUERY_SELECT_NOME = "SELECT COD_GRAFICA,NOME FROM GRAFICA WHERE NOME LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM GRAFICA WHERE COD_GRAFICA = ?";
	private static final String QUERY_SELECT_ALL = "SELECT COD_GRAFICA,NOME FROM GRAFICA";
	
	
	public void alterar(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setString(1, graficaEmpresa.getNome());
			comando.setInt(2, graficaEmpresa.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	
	@SuppressWarnings("finally")
	public GraficaEmpresa consultar(int codigo)
			throws ExcecaoNegocio {
		GraficaEmpresa graficaEmpresa = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				graficaEmpresa = this.criarGraficaEmpresa(rs); 
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return graficaEmpresa;
		}
	}

	
	@SuppressWarnings("finally")
	public ArrayList<Grafica> consultar(String nome)
			throws ExcecaoNegocio {
		ArrayList<Grafica>  graficas = new ArrayList<Grafica> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_NOME);
			comando.setString(1,"%"+nome+"%");
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				graficas.add(this.criarGraficaEmpresa(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return graficas;
		}
	}

	
	@SuppressWarnings("finally")
	public GraficaEmpresa inserir(GraficaEmpresa graficaEmpresa) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		GraficaEmpresa resultado = null;
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setString(1, graficaEmpresa.getNome());
			comando.executeUpdate();
			System.out.println("Inserção com Sucesso!");
			resultado = this.consultar(this.obterUltimoCodigo());
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
			return resultado;
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


	@SuppressWarnings("finally")
	public ArrayList<Grafica> consultar() throws ExcecaoNegocio {
		ArrayList<Grafica>  graficas = new ArrayList<Grafica> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_ALL);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				graficas.add(this.criarGraficaEmpresa(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return graficas;
		}
	}
	
	@SuppressWarnings("unused")
	private GraficaEmpresa criarGraficaEmpresa(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codGraficaEmpresa = rs.getInt("COD_GRAFICA");
		String nome = rs.getString("NOME");		
		
		return new GraficaEmpresa(codGraficaEmpresa, nome);
	}
	
	@SuppressWarnings("finally")
	private int obterUltimoCodigo() throws ExcecaoNegocio{
		int codRetorno = 0;
		Connection conexao = UtilBD.obterConexao();
		try {
			PreparedStatement comando = conexao.prepareStatement(QUERY_ULTIMO_CODIGO);
			ResultSet linhas = comando.executeQuery();
			if (linhas.next()){
				codRetorno = linhas.getInt("MAXCOD");
			} 
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return codRetorno;
		}
				
	}

}

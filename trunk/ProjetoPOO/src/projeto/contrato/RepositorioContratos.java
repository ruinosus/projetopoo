package projeto.contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;


public class RepositorioContratos implements IRepositorioContratos {

	private static final String QUERY_INSERT = "INSERT INTO CONTRATO (NOME_RESPONSAVEL,VALOR) VALUES (?,?)";
	private static final String QUERY_UPDATE = "UPDATE CONTRATO SET NOME_RESPONSAVEL = ?, VALOR = ? WHERE COD_CONTRATO = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_CONTRATO,NOME_RESPONSAVEL,VALOR FROM CONTRATO WHERE COD_CONTRATO = ?";
	private static final String QUERY_ULTIMO_CODIGO = "SELECT MAX(COD_CONTRADO) MAXCOD FROM CONTRATO";	
	private static final String QUERY_SELECT_NOME = "SELECT COD_CONTRATO,NOME_RESPONSAVEL,VALOR FROM CONTRATO WHERE NOME_RESPONSAVEL LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM CONTRATO WHERE COD_CONTRATO = ?";
	private static final String QUERY_SELECT_ALL = "SELECT COD_CONTRATO,NOME_RESPONSAVEL,VALOR FROM CONTRATO" ;	
	
	public void alterar(Contrato contrato) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setString(1, contrato.getNome());
			comando.setDouble(2, contrato.getValor());
			comando.setInt(3, contrato.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}

	@SuppressWarnings("finally")
	public Contrato consultar(int codigo) throws ExcecaoNegocio {
		Contrato contrato = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				contrato = this.criarContrato(rs); 
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return contrato;
		}
		
	}

	@SuppressWarnings("finally")
	public ArrayList<Contrato> consultar(String nome) throws ExcecaoNegocio {
		ArrayList<Contrato>  contratos = new ArrayList<Contrato> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_NOME);
			comando.setString(1,"%"+nome+"%");
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				contratos.add(this.criarContrato(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return contratos;
		}
	}

	
	@SuppressWarnings("finally")
	public Contrato inserir(Contrato contrato) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		Contrato resultado = null;
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setString(1, contrato.getNome());
			comando.setDouble(2, contrato.getValor());
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
	
	private Contrato criarContrato(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codContrato = rs.getInt("COD_CONTRATO");
		String nome = rs.getString("NOME_RESPONSAVEL");
		double valor = rs.getDouble("VALOR");
		
		return new Contrato(codContrato, nome, valor);
	}
	
	 @SuppressWarnings({ "finally", "unused" })
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

	public ArrayList<Contrato> consultar() throws ExcecaoNegocio {
		ArrayList<Contrato>  contratos = new ArrayList<Contrato> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_ALL);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				contratos.add(this.criarContrato(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return contratos;
		}
	}

}

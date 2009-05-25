package projeto.grafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.contrato.Contrato;
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioGraficasTerceirizadas implements
		IRepositorioGraficasTerceirizadas {
	
	private static final String QUERY_INSERT = "INSERT INTO GRAFICA_TERCEIRIZADA (COD_GRAFICA,COD_ENDERECO,COD_CONTRATO) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE GRAFICA_TERCEIRIZADA SET COD_ENDERECO = ?,COD_CONTRATO = ? WHERE COD_GRAFICA = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_GRAFICA,COD_ENDERECO,COD_CONTRATO FROM GRAFICA_TERCEIRIZADA WHERE COD_GRAFICA = ?";
	private static final String QUERY_DELETE = "DELETE FROM GRAFICA_TERCEIRIZADA WHERE COD_GRAFICA = ?";

	public void alterar(GraficaTerceirizada graficaTerceirizada)
			throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setInt(1, graficaTerceirizada.getEndereco().getCodigo());
			comando.setInt(2, graficaTerceirizada.getContrato().getCodigo());
			comando.setInt(3, graficaTerceirizada.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}

	@SuppressWarnings("finally")
	public GraficaTerceirizada consultar(int codigo)
			throws ExcecaoNegocio {
		GraficaTerceirizada graficaTerceirizada = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				graficaTerceirizada = this.criarGraficaEmpresa(rs);
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return graficaTerceirizada;
		}
	}	

	public void inserir(GraficaTerceirizada graficaTerceirizada)
			throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, graficaTerceirizada.getCodigo());
			comando.setInt(2, graficaTerceirizada.getEndereco().getCodigo());
			comando.setInt(3, graficaTerceirizada.getContrato().getCodigo());
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
	private GraficaTerceirizada criarGraficaEmpresa(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codGraficaTerceirizada = rs.getInt("COD_GRAFICA");
		int codEndereco = rs.getInt("COD_ENDERECO");
		int codContrato = rs.getInt("COD_CONTRATO");
		
		Endereco endereco = new Endereco();
		endereco.setCodigo(codEndereco);
		
		Contrato contrato = new Contrato();
		contrato.setCodigo(codContrato);
		return new GraficaTerceirizada(codGraficaTerceirizada,null,endereco,contrato);
	}

}

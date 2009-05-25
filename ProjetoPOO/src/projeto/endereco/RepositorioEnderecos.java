package projeto.endereco;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;

public class RepositorioEnderecos implements IRepositorioEnderecos {

	private static final String QUERY_INSERT = "INSERT INTO ENDERECO (LOGRADOURO,BAIRRO,COMPLEMENTO,CEP,NUMERO,UF,CIDADE,PAIS) VALUES (?,?,?,?,?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE ENDERECO SET (LOGRADOURO = ?, BAIRRO = ?, COMPLEMENTO = ?, CEP = ?, NUMERO = ?, UF = ?, CIDADE = ?, PAIS = ?) WHERE COD_ENDERECO = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_ENDERECO,LOGRADOURO,BAIRRO,COMPLEMENTO,CEP,NUMERO,UF,CIDADE,PAIS FROM ENDERECO WHERE COD_ENDERECO = ?";
	private static final String QUERY_ULTIMO_CODIGO = "SELECT MAX(COD_ENDERECO) MAXCOD FROM ENDERECO";	
	private static final String QUERY_DELETE = "DELETE FROM ENDERECO WHERE COD_ENDERECO = ?";
	
	public void alterar(Endereco endereco) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setString(1, endereco.getLogradouro());
			comando.setString(2, endereco.getBairro());
			comando.setString(3, endereco.getComplemento());
			comando.setString(4, endereco.getCep());
			comando.setString(5, endereco.getNumero());
			comando.setString(6, endereco.getUf());
			comando.setString(7, endereco.getCidade());
			comando.setString(8, endereco.getPais());
			comando.setInt(9, endereco.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}

	}

	@SuppressWarnings("finally")
	public Endereco consultar(int codigo) throws ExcecaoNegocio {
		
		Endereco endereco = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				endereco = this.criarEndereco(rs); 
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return endereco;
		}
	}

	@SuppressWarnings("finally")
	public Endereco inserir(Endereco endereco) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		Endereco resultado = endereco;
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 			
			comando.setString(1, endereco.getLogradouro());
			comando.setString(2, endereco.getBairro());
			comando.setString(3, endereco.getComplemento());
			comando.setString(4, endereco.getCep());
			comando.setString(5, endereco.getNumero());
			comando.setString(6, endereco.getUf());
			comando.setString(7, endereco.getCidade());
			comando.setString(8, endereco.getPais());
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
			//int linhasAlteradas = comando.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExcecaoNegocio(e.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
	}
	
	private Endereco criarEndereco(ResultSet rs) throws SQLException {
		
		int codEndereco = rs.getInt("COD_ENDERECO");
		String logradouro = rs.getString("LOGRADOURO");
		String bairro = rs.getString("BAIRRO");
		String complemento = rs.getString("COMPLEMENTO");
		String cep = rs.getString("CEP");
		String numero = rs.getString("NUMERO");
		String uf = rs.getString("UF");
		String cidade = rs.getString("CIDADE");
		String pais = rs.getString("PAIS");
		
		return new Endereco(codEndereco,logradouro,numero,complemento,bairro,cep,cidade,uf,pais);
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
	 
}

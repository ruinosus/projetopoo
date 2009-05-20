package projeto.editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;
import projeto.util.UtilBD;


public class RepositorioEditoras implements IRepositorioEditoras {

	private static final String QUERY_INSERT = "INSERT INTO EDITORA (COD_ENDERECO,NOME) VALUES (?,?)";
	private static final String QUERY_UPDATE = "UPDATE EDITORA SET (COD_ENDERECO = ?, NOME = ?) WHERE COD_EDITORA = ?";
	private static final String QUERY_SELECT_CODIGO = "SELECT COD_EDITORA,COD_ENDERECO,NOME FROM EDITORA WHERE COD_EDITORA = ?";
	//private static final String QUERY_MAXIMO_CODIGO = "SELECT MAX(COD_CONTRATO) MAXCOD FROM CONTRATO";
	private static final String QUERY_SELECT_NOME = "SELECT COD_EDITORA,COD_ENDERECO,NOME FROM EDITORA WHERE NOME LIKE ?" ;
	private static final String QUERY_DELETE = "DELETE FROM EDITORA WHERE COD_EDITORA = ?";
	
	public void alterar(Editora editora) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_UPDATE); 			
			comando.setInt(1, editora.getEndereco().getCodigo());
			comando.setString(2, editora.getNome());
			comando.setInt(3, editora.getCodigo());
			comando.executeUpdate();
			System.out.println("Alteração com Sucesso!");
			
		} catch (SQLException e1) {
			throw new ExcecaoNegocio(e1.getMessage());
		}finally{
			UtilBD.fecharConexao(conexao);
		}
		
	}

	
	@SuppressWarnings("finally")
	public Editora consultarCodigo(int codigo) throws ExcecaoNegocio {
		Editora editora = null;
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_CODIGO);
			comando.setInt(1, codigo);
			ResultSet rs = comando.executeQuery();
			if (rs.next()){
				editora = this.criarEditora(rs) ;
			}
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return editora;
		}
	}

	
	@SuppressWarnings("finally")
	public ArrayList<Editora> consultarNome(String nome) throws ExcecaoNegocio {
		ArrayList<Editora>  editoras = new ArrayList<Editora> ();
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_SELECT_NOME);
			comando.setString(1,"%"+nome+"%");
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				editoras.add(this.criarEditora(rs));
			}
		}catch (SQLException e){
			throw new ExcecaoNegocio(e.getMessage());
		} finally{
			UtilBD.fecharConexao(conexao);
			return editoras;
		}
	}

	
	public void inserir(Editora editora) throws ExcecaoNegocio {
		Connection conexao = UtilBD.obterConexao();
		try {			
			PreparedStatement comando = conexao.prepareStatement(QUERY_INSERT); 
			comando.setInt(1, editora.getEndereco().getCodigo());
			comando.setString(2, editora.getNome());
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
	
	private Editora criarEditora(ResultSet rs) throws ExcecaoNegocio, SQLException {
		int codEditora = rs.getInt("COD_EDITORA");
		int codEndereco = rs.getInt("COD_ENDERECO");
		String nome = rs.getString("NOME");
		Endereco endereco = new Endereco();
		endereco.setCodigo(codEndereco);	
		
		return new Editora(codEditora,nome,endereco);
	}
	

}

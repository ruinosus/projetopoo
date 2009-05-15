package projeto.util;
/**
 * Classe que faz a conexão com o banco de dados.
 * 
 * @author jefferson.barnabe
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projeto.excecao.ExcecaoNegocio;


public class UtilBD {
	
	private static String url= "jdbc:mysql://localhost:3306/projetopoo";//10.0.3.14//localhost
	private static String usuario = "root";
    private static String senha = "12345678";
    
    /**
     * Bloco estatico é executado no primeiro acesso a qualquer item (atributo ou metodo) 
     * estatico desta classe
     */
    static {
    	try {    		
        	Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
			throw new RuntimeException("Não conseguiu carregar o driver");
			// por ser bloco estatico, só posso gerar um erro usando excecao do tipo Runtime
		}
    }
    
    /**
     * Retorna uma conexao com o banco
     * @return objeto conexao com o banco
     * @throws ErroBancoException gerada quando dá algum tipo de erro, no momento de abertura da conexao
     */
    public static Connection obterConexao() throws ExcecaoNegocio{
    	try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new ExcecaoNegocio(e.getMessage());
		}
    }
    /**
     * Fecha uma conexao com o banco
     * @param con - conexao a ser passada
     */ 
    public static void fecharConexao(Connection con){
    	if (con != null){
    		try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }         
}

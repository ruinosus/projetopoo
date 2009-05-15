package projeto.endereco;
/**
 * Classe que representa um Endereço no sistema 
 * 
 * <code>
 * Endereco e = new Endereco(); <BR>
 * </code>
 * 
 * @author jefferson.barnabe
 *
 */
public class Endereco {
	
	 private int codigo;
	 private String logradouro;
	 private String numero;
	 private String complemento;
	 private String bairro;
	 private String cep;
	 private String uf;
	 private String cidade;
	 private String pais;

	/**
	  * Cria um objeto Endereco com os valores default de seus atributos
	  * 
	  */
	public Endereco() {
		super();
	}
	
	/**
	  * Cria um objeto Endereco com o codigo  o logradouro o numero o complemento
	  * o bairro o cep a cidade e o pais.
	  * 
	  * @param codigo - codigo do endereco
	  * @param logradouro - logradouro do endereco
	  * @param numero - numero do endereco
	  * @param complemento - complemento do endereco
	  * @param bairro - bairro do endereco
	  * @param cep - cep do endereco
      * @param cidade - cidade do endereco
	  * @param uf - uf do endereco
	  * @param pais - pais do endereco
	  */
	public Endereco(int codigo,String logradouro, String numero,String complemento, String bairro, String cep,
			String uf,String cidade, String pais) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}
	/**
	  * Retorna a codigo do endereco
	  * 
	  * @return codigo do endereco
	  */
	public int getCodigo() {
		return codigo;
	}
  /**
   * Seta o valor do atributo codigo 
   * 
   * @param rua - codigo do endereco
   */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	  * Retorna a logradouro do endereco
	  * 
	  * @return logradouro do endereco
	  */
	public String getLogradouro() {
		return logradouro;
	}
   /**
    * Seta o valor do atributo rua 
    * 
    * @param rua - rua do endereco
    */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	/**
	  * Retorna o numero do endereco
	  * 
	  * @return numero do endereco
	  */
	public String getNumero() {
		return numero;
	}
   /**
    * Seta o valor do atributo numero 
    * 
    * @param numero - numero do endereco
    */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	  * Retorna o complemento do endereco
	  * 
	  * @return complemento do endereco
	  */
	public String getComplemento() {
		return complemento;
	}
  /**
   * Seta o valor do atributo complemento 
   * 
   * @param complemento - complemento do endereco
   */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	  * Retorna o bairro do endereco
	  * 
	  * @return bairro do endereco
	  */
	public String getBairro() {
		return bairro;
	}
   /**
    * Seta o valor do atributo bairro 
    * 
    * @param bairro - bairro do endereco
    */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	  * Retorna o cep do endereco
	  * 
	  * @return cep do endereco
	  */
	public String getCep() {
		return cep;
	}
   /**
    * Seta o valor do atributo cep 
    * 
    * @param cep - cep do endereco
    */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	  * Retorna a cidade do endereco
	  * 
	  * @return cidade do endereco
	  */
	public String getCidade() {
		return cidade;
	}
   /**
    * Seta o valor do atributo cidade 
    * 
    * @param cidade - cidade do endereco
    */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	 /**
	  * Retorna o pais do endereco
	  * 
	  * @return pais do endereco
	  */
	 public String getPais() {
		return pais;
	}

   /**
    * Seta o valor do atributo pais 
    * 
    * @param pais - pais do endereco
    */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * Retorna a uf do endereco
	 * 
	 * @return uf do endereco
	 */
	public String getUf() {
		return uf;
	}
   /**
    * Seta o valor do atributo uf 
    * 
    * @param uf - uf do endereco
    */	
	public void setUf(String uf) {
		this.uf = uf;
	}


}

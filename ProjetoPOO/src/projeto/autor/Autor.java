package projeto.autor;

import projeto.endereco.Endereco;
import sun.util.calendar.BaseCalendar.Date;


public class Autor {
	
	private String nome;
	private String identidade;
	private Endereco endereco;
	private Date dataNascimento;
	private String nacionalidade;
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor(String nome, String identidade, Endereco endereco, Date data, String nacionalidade, String descricao){
		
		this.nome = nome;
		this.identidade = identidade;
		this.endereco = endereco;
		this.dataNascimento = data;
		this.nacionalidade = nacionalidade;
		this.descricao = descricao;
	}
	
	
}

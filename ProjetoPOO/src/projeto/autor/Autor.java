package projeto.autor;

import projeto.endereco.Endereco;

public class Autor {
	
	private int identidade;
	private String nome;
	private Endereco endereco;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdentidade() {
		return identidade;
	}
	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Autor(int identidade, String nome, Endereco endereco) {
		super();
		this.identidade = identidade;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Autor() {
		super();
	}
	public String toString(){
		return this.nome;
	}
	public boolean equals(Object o){
		boolean resultado = false;
		if (o instanceof Autor){
			Autor a = (Autor)o;
			if(a.getIdentidade()== this.getIdentidade()){
				resultado = true;
			}
		}
		
		return resultado;
	}


	
	
}

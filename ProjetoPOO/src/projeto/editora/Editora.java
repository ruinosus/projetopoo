package projeto.editora;

import projeto.endereco.Endereco;

public class Editora {
	
	private int codigo;
	private String nome;
	private Endereco endereco;
	
	public Editora(int codigo, String nome, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
	}
	public Editora() {
		super();

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String toString(){
		return this.nome;
	}
	
	public boolean equals(Object o){
		boolean resultado = false;
		if (o instanceof Editora){
			Editora e = (Editora)o;
			if(e.getCodigo()== this.getCodigo()){
				resultado = true;
			}
		}
		
		return resultado;
	}
	

}

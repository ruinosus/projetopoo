package projeto.grafica;



public class Grafica {
	
	private int codigo;
	private String nome;
		
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


	public Grafica(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Grafica(){
		
	}
	
	public String toString(){
		return this.nome;
	}
	
	public boolean equals(Object o){
		boolean resultado = false;
		if (o instanceof Grafica){
			Grafica g = (Grafica)o;
			if(g.getCodigo()== this.getCodigo()){
				resultado = true;
			}
		}
		
		return resultado;
	}
	
}

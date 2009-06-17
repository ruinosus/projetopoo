package projeto.loteLivro;

import java.sql.Date;

import projeto.grafica.Grafica;
import projeto.livro.Livro;

public class LoteLivro {

	private int codigo;
	private Livro livro;
	private Grafica grafica;
	private Date dataEntrega;
	private int numeroCopias;
	
	
	public int getNumeroCopias() {
		return numeroCopias;
	}
	public void setNumeroCopias(int numeroCopias) {
		this.numeroCopias = numeroCopias;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Grafica getGrafica() {
		return grafica;
	}
	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LoteLivro(int codigo, Livro livro, Grafica grafica,
			Date dataEntrega, int numeroCopias) {
		super();
		this.codigo = codigo;
		this.livro = livro;
		this.grafica = grafica;
		this.dataEntrega = dataEntrega;
		this.numeroCopias = numeroCopias;
	}
	public LoteLivro() {
		super();
	}
	
	public String toString(){
		return this.livro+" Numero de Copias: "+this.numeroCopias+" data entrega: "+ this.dataEntrega + " Grafica: " + this.grafica;
	}
	
	
	
}

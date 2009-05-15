package projeto.loteLivro;

import java.sql.Date;

import projeto.grafica.Grafica;
import projeto.livro.Livro;

public class LoteLivro {

	private int codigo;
	private Livro livro;
	private Grafica grafica;
	private Date dataEntrega;
	
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
	public LoteLivro(int codigo, Livro livro, Grafica grafica, Date dataEntrega) {
		super();
		this.codigo = codigo;
		this.livro = livro;
		this.grafica = grafica;
		this.dataEntrega = dataEntrega;
	}
	public LoteLivro() {
		super();
	}
	
}

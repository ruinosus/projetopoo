package projeto.livro;
import java.util.ArrayList;

import projeto.autor.Autor;
import projeto.editora.Editora;

import java.sql.Date;

public class Livro {
	
	private int isbn;
	private String titulo;
	private Editora editora;
	private Date dataPublicacao;
	private ArrayList<Autor> autor;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public ArrayList<Autor> getAutor() {
		return autor;
	}
	public void setAutor(ArrayList<Autor> autor) {
		this.autor = autor;
	}

	
	public Livro(int isbn, String titulo, Editora editora, Date data, ArrayList<Autor> autor){
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.dataPublicacao = data;
		this.autor = autor;		
	}
	public Livro(){
	
	}
	
	public String toString(){
		return this.titulo;
	}
	
	public boolean equals(Object o){
		boolean resultado = false;
		if (o instanceof Livro){
			Livro l = (Livro)o;
			if(l.getIsbn()== this.getIsbn()){
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	
	

}

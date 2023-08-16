package modelo;

public class Categoria {
	private int idCategoria;
	private String nome; //ta errado no banco 
	
	public Categoria(int idCategoria, String nome) {
		this.idCategoria = idCategoria;
		this.nome = nome;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

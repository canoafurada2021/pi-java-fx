package modelo;

public class Categoria {
	private Long id_categoria;
	private static String categoria;
	

	public Long getIdCategoria() {
		return id_categoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.id_categoria = idCategoria;
	}
	public static String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}

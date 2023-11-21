package modelo;

public class Categoria {
	private Integer id_categoria;
	private String categoria; // Removido o modificador estático

	public Integer getIdCategoria() {
		return id_categoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.id_categoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}

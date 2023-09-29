package modelo;

public class Vendedor extends PessoaFisica {

	private Long id_vendedor;
	private Double salario;

	public Long getId_vendedor() {
		return id_vendedor;
	}

	public void setIdVendedor(Long id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}

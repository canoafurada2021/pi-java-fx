package modelo;

public class Vendedor extends PessoaFisica {

	private Long id_vendedor;
	private Double salario;
	private Long cpf;
	private String senha;

	public Long getId_vendedor() {
		return id_vendedor;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId_vendedor(Long id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public void setIdVendedor(long id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}

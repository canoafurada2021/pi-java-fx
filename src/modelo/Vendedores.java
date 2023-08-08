package modelo;

public class Vendedores {
	 private int idVendedores;
	 private Double salario;
	 private String nome;
	    private EnumRoles cargo; // Use o enum para o cargo
	 
	public EnumRoles getCargo() {
			return cargo;
		}
		public void setCargo(EnumRoles cargo) {
			this.cargo = cargo;
		}
	public int getIdVendedores() {
		return idVendedores;
	}
	public void setIdVendedores(int idVendedores) {
		this.idVendedores = idVendedores;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

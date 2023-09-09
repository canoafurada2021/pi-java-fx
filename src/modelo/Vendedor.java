package modelo;

public class Vendedor {
	 private int id_vendedor;
	 private Double salario;
	 private String nome;
	 private String sobrenome;
	    public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
		private EnumCargos cargo; // Use o enum para o cargo
	 
	public EnumCargos getCargo() {
			return cargo;
		}
		public void setCargo(EnumCargos cargo) {
			this.cargo = cargo;
		}
	
	public int getId_vendedor() {
			return id_vendedor;
		}
		public void setId_vendedor(int id_vendedor) {
			this.id_vendedor = id_vendedor;
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

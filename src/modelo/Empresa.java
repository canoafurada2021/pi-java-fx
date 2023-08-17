package modelo;

public class Empresa {
	private int idEmpresa;
	private String razaoSocial;
	private Long telefone;
	private Double cnpj;
	private String nome_fantasia;
	private String porte_empresa;
	private EnumRoles cargo;
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public Double getCnpj() {
		return cnpj;
	}
	public void setCnpj(Double cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getPorte_empresa() {
		return porte_empresa;
	}
	public void setPorte_empresa(String porte_empresa) {
		this.porte_empresa = porte_empresa;
	}
	public EnumRoles getCargo() {
		return cargo;
	}
	public void setCargo(EnumRoles cargo) {
		this.cargo = cargo;
	}

}

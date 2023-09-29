package modelo;

public class Empresa extends PessoaJuridica {

	private String razaoSocial;
	private String porte_empresa;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getPorte_empresa() {
		return porte_empresa;
	}

	public void setPorte_empresa(String porte_empresa) {
		this.porte_empresa = porte_empresa;
	}

}

package modelo;

public class Locador {
	private String nome;
	private String sobrenome;
	private String pessoas_cpf;
	private Long tel_contato;
	private String pais_residencia;
	private Long cnh;

	public void setValidadeCarteira(String validadeCarteira) {
		this.validadeCarteira = validadeCarteira;
	}

	public String getValidadeCarteira() {
		return validadeCarteira;
	}

	private String validadeCarteira;
	private Long num_identificacao_carteira;
	private TipoAcessoLogin cargo;
	private String img_Base64;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPessoas_cpf() {
		return pessoas_cpf;
	}

	public void setPessoas_cpf(String pessoas_cpf) {
		this.pessoas_cpf = pessoas_cpf;
	}

	public Long getTel_contato() {
		return tel_contato;
	}

	public void setTel_contato(Long tel_contato) {
		this.tel_contato = tel_contato;
	}

	public String getPaisResidencia() {
		return pais_residencia;
	}

	public void setPaisResidencia(String pais_residencia) {
		this.pais_residencia = pais_residencia;
	}

	public Long getCnh() {
		return cnh;
	}


	public void setCnh(Long cnh) {
		this.cnh = cnh;
	}




	public Long getNumIdentificacaoCarteira() {
		return num_identificacao_carteira;
	}

	public void setNumIdentificacaoCarteira(Long num_identificacao_carteira) {
		this.num_identificacao_carteira = num_identificacao_carteira;
	}

	public String getImg_Base64() {
		return img_Base64;
	}

	public void setImg_Base64(String img_Base64) {
		this.img_Base64 = img_Base64;
	}

	public TipoAcessoLogin getTipoAcesso() {
		return cargo;
	}

	public void setCargo(TipoAcessoLogin cargo) {
		this.cargo = cargo;
	}
}

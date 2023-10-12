package modelo;

public abstract class PessoaJuridica {

	private Long id_empresa;
	private Long cnpj;
	private String nome;
	private Long telefone;
	private TipoAcessoLogin tipoAcesso;

	public TipoAcessoLogin getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcessoLogin tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public Long getIdEmpresa() {
		return id_empresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.id_empresa = idEmpresa;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}

package modelo;

public abstract class PessoaFisica {

	private String nome;
	private String sobrenome;
	private TipoAcessoLogin tipoAcesso;

	public TipoAcessoLogin getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcessoLogin tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

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

}

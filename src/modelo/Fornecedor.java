package modelo;

public class Fornecedor {
	private Long cnpj;

	private Endereco enderecoId;
	private String nome;
	private Long telefone;
	private String atividades;

	public Long getCnpj() {
		return cnpj;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Endereco enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
}

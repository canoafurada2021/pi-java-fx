package modelo;

public class Fornecedor extends PessoaJuridica {

	private Endereco enderecoId; //n existe no banco isso aqui
	private String atividades;

	public Endereco getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Endereco enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

}

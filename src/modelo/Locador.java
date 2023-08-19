package modelo;

import java.util.Date;

public class Locador {
	private String nome;
	private String sobrenome;
	private int pessoas_cpf;
	private Long tel_contato;
	private String paisResidencia;
	private Long cnh;
	private Date validadeCarteira;
	private Long numIdentificacaoCarteira;
	private EnumRoles cargo;

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

	public EnumRoles getCargo() {
		return cargo;
	}

	public void setCargo(EnumRoles cargo) {
		this.cargo = cargo;
	}

	public int getPessoas_cpf() {
		return pessoas_cpf;
	}

	public void setPessoas_cpf(int pessoas_cpf) {
		this.pessoas_cpf = pessoas_cpf;
	}

	public Long getTel_contato() {
		return tel_contato;
	}

	public void setTel_contato(Long tel_contato) {
		this.tel_contato = tel_contato;
	}

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public Long getChn() {
		return cnh;
	}

	public void setChn(Long cnh) {
		this.cnh = cnh;
	}

	public Date getValidadeCarteira() {
		return validadeCarteira;
	}

	public void setValidadeCarteira(Date validadeCarteira) {
		this.validadeCarteira = validadeCarteira;
	}

	public Long getNumIdentificacaoCarteira() {
		return numIdentificacaoCarteira;
	}

	public void setNumIdentificacaoCarteira(Long numIdentificacaoCarteira) {
		this.numIdentificacaoCarteira = numIdentificacaoCarteira;
	}

}

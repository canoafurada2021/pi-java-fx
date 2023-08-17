package modelo;

import java.util.Date;

public class Locador extends Pessoa{
	private Pessoa pessoas_cpf;
	private Long tel_contato;
	private String paisResidencia;
	private Long chn;
	private Date validadeCarteira;
	private Long numIdentificacaoCarteira;
	
	

	public Pessoa getPessoas_cpf() {
		return pessoas_cpf;
	}
	public void setPessoas_cpf(Pessoa pessoas_cpf) {
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
		return chn;
	}
	public void setChn(Long chn) {
		this.chn = chn;
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

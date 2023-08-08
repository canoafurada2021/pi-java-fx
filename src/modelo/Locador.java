package modelo;

import java.util.Date;

public class Locador extends Pessoa{
	private Long telContato;
	private String paisResidencia;
	private Long chn;
	private Date validadeCarteira;
	private Long numIdentificacaoCarteira;
	
	
	public Long getTelContato() {
		return telContato;
	}
	public void setTelContato(Long telContato) {
		this.telContato = telContato;
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

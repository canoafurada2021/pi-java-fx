package modelo;

import java.util.Date;

public class Veiculo {
	private int idVeiculo;
	private String nome;
	private String descricao;
	private Double precoPorDia;
	private String marca;
	private String modelo;
	public Double getPrecoPorDia() {
		return precoPorDia;
	}
	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}
	public int getQuantAssento() {
		return quantAssento;
	}
	public void setQuantAssento(int quantAssento) {
		this.quantAssento = quantAssento;
	}
	public int getQuantPortas() {
		return quantPortas;
	}
	public void setQuantPortas(int quantPortas) {
		this.quantPortas = quantPortas;
	}
	public int getEspacoPortaMalas() {
		return espacoPortaMalas;
	}
	public void setEspacoPortaMalas(int espacoPortaMalas) {
		this.espacoPortaMalas = espacoPortaMalas;
	}
	public int getNotaAvaliacao() {
		return notaAvaliacao;
	}
	public void setNotaAvaliacao(int notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}
	public String getImgBase64() {
		return imgBase64;
	}
	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}
	public int getUnidadeEmEstoque() {
		return unidadeEmEstoque;
	}
	public void setUnidadeEmEstoque(int unidadeEmEstoque) {
		this.unidadeEmEstoque = unidadeEmEstoque;
	}
	private Date anoFabricacao;
	private String tipoCombustivel;
	private int quantAssento;
	private int quantPortas;
	private int espacoPortaMalas;
	private int notaAvaliacao;
private String imgBase64;
private int unidadeEmEstoque;
	
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPrecoUnitario() {
		return precoPorDia;
	}
	public void setPrecoUnitario(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public int getQuantEmEstoque() {
		return quantEmEstoque;
	}
	public void setQuantEmEstoque(int quantEmEstoque) {
		this.quantEmEstoque = quantEmEstoque;
	}
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	public String getImagemBase64() {
		return imagemBase64;
	}
	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}
	private int quantEmEstoque;
	private Date dataUltimaAlteracao;
	private String imagemBase64;
}

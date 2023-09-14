package modelo;

import java.util.Date;

public class Veiculo {
	private int id_veiculo;
	private int quant_assento;
	private String tipo_cambio;
	private int quant_portas;
	private int espaco_porta_malas;
	private String marca;
	private String nome;
	private String cor;
	private int nota_avaliacao;
	private Double preco_por_dia;
	private String img_Base64;
	private int unidade_em_estoque;
	private Categoria idCategoria;
	private Fornecedor cnpj;
	
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	public int getQuant_assento() {
		return quant_assento;
	}
	public void setQuant_assento(int quant_assento) {
		this.quant_assento = quant_assento;
	}
	public String getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(String tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	public int getQuant_portas() {
		return quant_portas;
	}
	public void setQuant_portas(int quant_portas) {
		this.quant_portas = quant_portas;
	}
	public int getEspaco_porta_malas() {
		return espaco_porta_malas;
	}
	public void setEspaco_porta_malas(int espaco_porta_malas) {
		this.espaco_porta_malas = espaco_porta_malas;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getNota_avaliacao() {
		return nota_avaliacao;
	}
	public void setNota_avaliacao(int nota_avaliacao) {
		this.nota_avaliacao = nota_avaliacao;
	}
	public Double getPreco_por_dia() {
		return preco_por_dia;
	}
	public void setPreco_por_dia(Double preco_por_dia) {
		this.preco_por_dia = preco_por_dia;
	}
	public String getImg_Base64() {
		return img_Base64;
	}
	public void setImg_Base64(String img_Base64) {
		this.img_Base64 = img_Base64;
	}
	public int getUnidade_em_estoque() {
		return unidade_em_estoque;
	}
	public void setUnidade_em_estoque(int unidade_em_estoque) {
		this.unidade_em_estoque = unidade_em_estoque;
	}
	public Categoria getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Fornecedor getCnpj() {
		return cnpj;
	}
	public void setCnpj(Fornecedor cnpj) {
		this.cnpj = cnpj;
	}
	
}

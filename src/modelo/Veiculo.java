package modelo;


public class Veiculo {
	private int id_veiculo;
	private int quant_assento;
	private String tipo_cambio;
	private int quant_portas;
	private int espaco_porta_malas;
	private String marca;
	private String nome;
	private String cor;
	private int ano;
	private int nota_avaliacao;
	private Long preco_por_dia;
	private int unidade_em_estoque;
	private Categoria categoria;
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
	public Long getPreco_por_dia() {
		return preco_por_dia;
	}
	public void setPreco_por_dia(Long preco_por_dia) {
		this.preco_por_dia = preco_por_dia;
	}

	public int getUnidade_em_estoque() {
		return unidade_em_estoque;
	}
	public void setUnidade_em_estoque(int unidade_em_estoque) {
		this.unidade_em_estoque = unidade_em_estoque;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Fornecedor getCnpj() {
		return cnpj;
	}
	public void setCnpj(Fornecedor cnpj) {
		this.cnpj = cnpj;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
}

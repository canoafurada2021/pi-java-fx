package modelo;

public class AluguelRegistro {
	private int idVenda;
	private String formaPagamento;


	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	private String dataInicio; // Alterado para Date ao invés de Timestamp
	private int quantDias;
	private Double valor;
	private Vendedor idVendedor;
	private Locador locador;
	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public int getQuantDias() {
		return quantDias;
	}

	public void setQuantDias(int quantDias) {
		this.quantDias = quantDias;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Vendedor getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Vendedor idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locadorr) {
		this.locador = locadorr;
	}


		public void setVendedor(Vendedor vendedor) {
			this.idVendedor = vendedor;
		}

	}

	// Se necessário, remova os métodos que não estão sendo usados

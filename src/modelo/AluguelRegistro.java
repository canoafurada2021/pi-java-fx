package modelo;

import java.util.Date;

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
	private Locador pessoas_cpf;
	private EnumPagamento tipoPagamento;
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

	public Locador getPessoas_cpf() {
		return pessoas_cpf;
	}

	public void setPessoas_cpf(Locador pessoas_cpf) {
		this.pessoas_cpf = pessoas_cpf;
	}

	public EnumPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(EnumPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


		public void setVendedor(Vendedor vendedor) {
			this.idVendedor = vendedor;
		}
	public void setLocador(Locador locador) {
		this.pessoas_cpf = locador;
	}
	}

	// Se necessário, remova os métodos que não estão sendo usados

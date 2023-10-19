package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AluguelRegistro {
	private int idVenda;
	private String formaPagamento;
	private Date dataInicio;
	private int quantDias;
	private Double valor;
	private Vendedor idVendedor;
	private ArrayList<Veiculo> carrinho = new ArrayList<>();
	private Locador idLocador;
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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
	public ArrayList<Veiculo> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(ArrayList<Veiculo> carrinho) {
		this.carrinho = carrinho;
	}
	public Locador getIdLocador() {
		return idLocador;
	}
	public void setIdLocador(Locador idLocador) {
		this.idLocador = idLocador;
	}
	public EnumPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(EnumPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	
	

	

}

package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AluguelRegistro {
	private int idVenda;
	private String forma_pagamento;
	private Date data_inicio;
	private int quant_dias;
	private Double valor;
	private int vendedor_id_vendedor;
	private int locador_pessoas_cpf;
	private ArrayList<Veiculo> carrinho = new ArrayList<>();
	private Locador idLocador;
	private EnumPagamento formaPagamento;
	
	
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
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
	public EnumPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(EnumPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	

}

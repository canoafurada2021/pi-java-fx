package modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluguel {
	private int idVenda;
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

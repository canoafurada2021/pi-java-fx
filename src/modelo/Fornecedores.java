package modelo;

public class Fornecedores {
private int cnpj;

private Endereco enderecoId;
private String nome;
private int telefone;
public int getCnpj() {
	return cnpj;
}
public void setCnpj(int cnpj) {
	this.cnpj = cnpj;
}
public Endereco getEnderecoId() {
	return enderecoId;
}
public void setEnderecoId(Endereco enderecoId) {
	this.enderecoId = enderecoId;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getTelefone() {
	return telefone;
}
public void setTelefone(int telefone) {
	this.telefone = telefone;
}
}

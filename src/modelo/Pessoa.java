package modelo;

public class Pessoa {

private float cpf;
private String nome;
private String sobrenome;
private EnumRoles cargo;
public float getCpf() {
	return cpf;
}
public void setCpf(float cpf) {
	this.cpf = cpf;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getSobrenome() {
	return sobrenome;
}
public void setSobrenome(String sobrenome) {
	this.sobrenome = sobrenome;
}
public EnumRoles getCargo() {
	return cargo;
}
public void setCargo(EnumRoles cargo) {
	this.cargo = cargo;
}
	
}

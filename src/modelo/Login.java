package modelo;

public class Login {
	private int id;

	private String cpf;
    private String senha;
    private EnumCargos cargo;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	    
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public EnumCargos getTipoUsuario() {
			return cargo;
		}
		public void setTipoUsuario(EnumCargos tipoUsuario) {
			this.cargo = tipoUsuario;
		}
}

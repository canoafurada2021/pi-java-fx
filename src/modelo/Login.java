package modelo;

public class Login {
	private int id;
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String cpf;
	    private String senha;
	    private EnumRoles tipoUsuario;
	    
	    
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
		public EnumRoles getTipoUsuario() {
			return tipoUsuario;
		}
		public void setTipoUsuario(EnumRoles tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}
}

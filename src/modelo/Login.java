package modelo;

public class Login {
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

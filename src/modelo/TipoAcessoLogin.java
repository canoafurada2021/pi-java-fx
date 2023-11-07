package modelo;

public enum TipoAcessoLogin {

	MASTER(1), FUNCIONARIO(2), CLIENTE(3);

	TipoAcessoLogin(int idEnum) {
		this.idEnum = idEnum;
	}

	private int idEnum;

	public int getId() {
		return this.idEnum;
	}

	public static TipoAcessoLogin getById(int id) {

		for (TipoAcessoLogin tipo : TipoAcessoLogin.values()) {

			if (tipo.getId() == id) {
				return tipo;
			}
		}

		return null;

	}

}
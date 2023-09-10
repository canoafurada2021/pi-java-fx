package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Locador;

public class LocadorDAO {

	// Inserindo o locador
	public boolean inserir(Locador l) {

		Conexao c = Conexao.getInstancia();

		// Abrindo conexao banco
		Connection con = c.conectar();

		String query = "INSERT INTO locador (pessoas-cpf, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, l.getNome());
			ps.setString(2, l.getSobrenome());
			ps.setLong(3, l.getPessoas_cpf());
			ps.setLong(4, l.getTel_contato());
			ps.setString(5, l.getPaisResidencia());
			ps.setLong(6, l.getChn());
			// ps.setDate(7, l.getValidadeCarteira());
			ps.setLong(8, l.getNumIdentificacaoCarteira());
			// ps.setEnumRoules(9, l.getCargo());

		} catch (SQLException l) {
			l.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}

		return false;

	}
}
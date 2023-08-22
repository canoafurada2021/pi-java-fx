package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Veiculo;

public class VeiculoDAO {

	public boolean inserir(Veiculo v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "INSERT INTO veiculo "
				+ "(id_veiculo, quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, nota_avaliação, preco_por_dia, img_Base64, unidade_em_estoque, "
				+ "idCategoria, cnpj)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, v.getId_veiculo());
			ps.setInt(3, v.getQuant_assento());
			ps.setString(4, v.getTipo_cambio());
			ps.setInt(5, v.getQuant_portas());
			ps.setInt(6, v.getEspaco_porta_malas());
			ps.setString(7, v.getMarca());
			ps.setString(8, v.getNome());
			ps.setString(9, v.getCor());
			ps.setInt(10, v.getNota_avaliacao());
			ps.setDouble(11, v.getPreco_por_dia());
			ps.setString(12, v.getImg_Base64());
//			ps.setInt(13, v.getIdCategoria());
//			ps.setInt(14, v.getCnpj());

			// CHAVES ESTRANGEIRAS
			ps.setInt(13, v.getIdCategoria().getIdCategoria()); // Preenche a chave estrangeira sendo a chave primaria
																// da tabela o ID

			ps.setLong(14, v.getCnpj().getCnpj()); // Preenche a chave estrangeira sendo a chave primaria da
															// tabela o cnpj
            ps.executeUpdate();

            c.fecharConexao();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false; // Retorna false em caso de falha na inserção
		}
		return true;
	}
}

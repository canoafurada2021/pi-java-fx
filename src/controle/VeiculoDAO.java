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
				+ "(idVeiculo, nome, descricao, precoUnitario, marca, modelo, anoFabricacao, tipoCombustivel, quantEmEstoque, dataUltimaAlteracao, imagemBase64, categorias_idcategorias, fornecedores_cnpj)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, v.getIdVeiculo());
			ps.setString(2, v.getNome());
			ps.setString(3, v.getDescricao());
			ps.setDouble(4, v.getPrecoUnitario());
			ps.setString(5, v.getMarca());
			ps.setString(6, v.getModelo());
			ps.setDate(7, new java.sql.Date(v.getAnoFabricacao().getTime()));
			ps.setString(8, v.getTipoCombustivel());
			ps.setInt(9, v.getQuantEmEstoque());
			ps.setDate(10, new java.sql.Date(v.getDataUltimaAlteracao().getTime()));
			ps.setString(11, v.getImagemBase64());

			// CHAVES ESTRANGEIRAS
			ps.setInt(12, v.getIdCategoria().getIdCategoria()); // Preenche a chave estrangeira sendo a chave primaria
																// da tabela o ID

			ps.setInt(13, v.getIdFornecedores().getCnpj()); // Preenche a chave estrangeira sendo a chave primaria da
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

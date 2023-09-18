package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Veiculo;

public class VeiculoDAO {

	public ArrayList<Veiculo> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Veiculo> veiculos = new ArrayList<>();
		String query = "SELECT v.*, f.nome AS fornecedor_nome, c.categoria AS categoria_nome " + "FROM veiculo v "
				+ "INNER JOIN fornecedores f ON v.fornecedores_cnpj = f.cnpj "
				+ "INNER JOIN categoria c ON v.idCategoria = c.id_categoria";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int idVeiculo = rs.getInt("id_veiculo");
				int quantAssento = rs.getInt("quant_assento");
				String tipoCambio = rs.getString("tipo_cambio");
				int quantPortas = rs.getInt("quant_portas");
				int espacoPortaMalas = rs.getInt("espaco_porta_malas");
				String marca = rs.getString("marca");
				String nome = rs.getString("nome");
				String cor = rs.getString("cor");
				int ano = rs.getInt("ano");
				int notaAvaliacao = rs.getInt("nota_avaliacao");
				Long precoPorDia = rs.getLong("preco_por_dia");
				String imgBase64 = rs.getString("img_Base64");
				int unidadeEmEstoque = rs.getInt("unidade_em_estoque");
				int categoria = rs.getInt("c.id_categoria");
				Long fornecedorCnpj = rs.getLong("f.cnpj");

				Veiculo v = new Veiculo();

				v.setId_veiculo(idVeiculo);
				v.setQuant_assento(quantAssento);
				v.setTipo_cambio(tipoCambio);
				v.setQuant_portas(quantPortas);
				v.setEspaco_porta_malas(espacoPortaMalas);
				v.setMarca(marca);
				v.setNome(nome);
				v.setCor(cor);
				v.setAno(ano);
				v.setNota_avaliacao(notaAvaliacao);
				v.setPreco_por_dia(precoPorDia);
				v.setImg_Base64(imgBase64);
				v.setUnidade_em_estoque(unidadeEmEstoque);

				// Definindo o id da categoria
				Categoria cat = new Categoria();
				cat.setIdCategoria(categoria);

				v.setIdCategoria(cat);

				Fornecedor f = new Fornecedor();
				f.setCnpj(fornecedorCnpj);

				v.setCnpj(f);

				veiculos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return veiculos;

	}

	public boolean inserir(Veiculo v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "INSERT INTO veiculo " + "(id_veiculo," + " quant_assento," + " tipo_cambio," + " quant_portas,"
				+ " espaco_porta_malas," + " marca," + " nome," + " cor," + " nota_avaliacao," + " preco_por_dia,"
				+ " img_Base64," + " unidade_em_estoque," + " idCategoria," + " fornecedores_cnpj)"
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

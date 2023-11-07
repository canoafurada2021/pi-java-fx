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
		String query = "SELECT v.*, f.nome AS fornecedor_nome, c.categoria AS categoria_nome " +
	               "FROM veiculo v " +
	               "INNER JOIN fornecedor f ON v.fornecedor_cnpj = f.cnpj " +  // Correção aqui
	               "INNER JOIN categoria c ON v.categoria_id_categoria = c.id_categoria";  // Correção aqui


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
//				String imgBase64 = rs.getString("img_Base64");
				int unidadeEmEstoque = rs.getInt("unidade_em_estoque");
				String categoria = rs.getString("categoria_nome"); // Correção aqui
				Long fornecedorCnpj = rs.getLong("fornecedor_cnpj");

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
				v.setUnidade_em_estoque(unidadeEmEstoque);

				// Definindo o id da categoria
				Categoria cat = new Categoria();
				cat.setCategoria(categoria);

				v.setIdCategoria(cat);

				// Definindo o id do fornecedor
				Fornecedor f = new Fornecedor();
				
				f.setCnpj(fornecedorCnpj);

				v.setCnpj(f);
				System.out.println("fornecedor"+ f);

				veiculos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return veiculos;

	}

	public boolean inserir(Veiculo veiculo) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO veiculo " + "(quant_assento," + " tipo_cambio, " + "quant_portas,"
				+ " espaco_porta_malas," + " marca," + " nome," + " cor," + " ano," + " nota_avaliacao,"
				+ " preco_por_dia,"  + "unidade_em_estoque," + " categoria_id_categoria,"
				+ " fornecedor_cnpj" + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    boolean insercaoSucesso = false; // Inicializa com false

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, veiculo.getQuant_assento());
			ps.setString(2, veiculo.getTipo_cambio());
			ps.setInt(3, veiculo.getQuant_portas());
			ps.setInt(4, veiculo.getEspaco_porta_malas());
			ps.setString(5,veiculo.getMarca());
			ps.setString(6,veiculo.getNome());
			ps.setString(7,veiculo.getCor());
			ps.setInt(8,veiculo.getAno());
			ps.setInt(9,veiculo.getNota_avaliacao());
			ps.setLong(10,veiculo.getPreco_por_dia());
			ps.setInt(11,veiculo.getUnidade_em_estoque());
			ps.setLong(12,veiculo.getIdCategoria().getIdCategoria());
			ps.setLong(13,veiculo.getCnpj().getCnpj());

	
			// Chave estrangeira para fornecedores

	        int linhasAfetadas = ps.executeUpdate();
	        

	        if (linhasAfetadas > 0) {
	            insercaoSucesso = true; // Define como true se pelo menos uma linha foi afetada
	        }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

	    return insercaoSucesso; // Retorna o resultado da inserção
	}

	
	
	
	public boolean excluir(int idVeiculo) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM veiculo WHERE id_veiculo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			// Defina o valor do parâmetro com base no ID do veículo que você deseja excluir
			ps.setInt(1, idVeiculo);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				c.fecharConexao();
				return true; // Exclusão bem-sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false; // Falha na exclusão
	}

	public boolean atualizar(Veiculo veiculo) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE veiculo SET "
				+ "quant_assento = ?, tipo_cambio = ?, quant_portas = ?, espaco_porta_malas = ?, "
				+ "marca = ?, nome = ?, cor = ?, ano = ?, nota_avaliacao = ?, preco_por_dia = ?, "
				+ "unidade_em_estoque = ?, categoria_id_categoria = ?, fornecedor_cnpj = ? "
				+ "WHERE id_veiculo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			// Configure os valores dos parâmetros com base no objeto Veiculo
			ps.setInt(1, veiculo.getQuant_assento());
			ps.setString(2, veiculo.getTipo_cambio());
			ps.setInt(3, veiculo.getQuant_portas());
			ps.setInt(4, veiculo.getEspaco_porta_malas());
			ps.setString(5, veiculo.getMarca());
			ps.setString(6, veiculo.getNome());
			ps.setString(7, veiculo.getCor());
			ps.setInt(8, veiculo.getAno());
			ps.setInt(9, veiculo.getNota_avaliacao());
			ps.setLong(10, veiculo.getPreco_por_dia());
			ps.setInt(11, veiculo.getUnidade_em_estoque());
			ps.setLong(12, veiculo.getIdCategoria().getIdCategoria());
			ps.setLong(13, veiculo.getCnpj().getCnpj());

			// Defina o valor do último parâmetro como o ID do veículo que você deseja
			// atualizar
			ps.setInt(14, veiculo.getId_veiculo());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				c.fecharConexao();
				return true; // Atualização bem-sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false; // Falha na atualização
	}

}

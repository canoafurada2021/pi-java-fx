package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Veiculo;

public class VeiculoDAO {

	public ArrayList<Veiculo> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Veiculo> produtos = new ArrayList<>();
		String query = "SELECT v.*, ";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id_veiculo = rs.getInt("id_veiculo");
				int quant_assento = rs.getInt("quant_assento");
				String tipo_cambio = rs.getString("tipo_cambio");
				int quant_portas = rs.getInt("quant_portas");
				int espaco_porta_malas = rs.getInt("espaco_porta_malas");
				String marca = rs.getString("marca");
				String nome = rs.getString("nome");
				String cor = rs.getString("cor");
				int ano = rs.getInt("ano");
				int nota_avaliacao = rs.getInt("nota_avaliacao");
				int preco_por_dia = rs.getInt("preco_por_dia");
				int unidade_em_estoque = rs.getInt("unidade_em_estoque");

				Veiculo v = new Veiculo();

				v.setId_veiculo(id_veiculo);
				v.setQuant_assento(quant_assento);
				v.setTipo_cambio(tipo_cambio);
				v.setQuant_portas(quant_portas);
				v.setEspaco_porta_malas(espaco_porta_malas);
				v.setMarca(marca);
				v.setNome(nome);
				v.setCor(cor);
				v.setAno(ano);
				v.setNota_avaliacao(nota_avaliacao);
				v.setPreco_por_dia(null);
				v.setUnidade_em_estoque(unidade_em_estoque);

				// falta as chaves estrangeiras

				produtos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return produtos;
	}

	public boolean inserir(Veiculo v) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO veiculo "
				+ "(id_veiculo, quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, nota_avaliação, preco_por_dia, img_Base64, unidade_em_estoque, "
				+ "idCategoria, cnpj)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false; // Retorna false em caso de falha na inserção
		} finally {
			c.fecharConexao();
		}
		return true;
	}

	public boolean excluir(Veiculo v) {
		Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
		
	    String query = "DELETE FROM veiculo WHERE id_veiculo = ?";
	    
	    try {
	    	PreparedStatement ps = con.prepareStatement(query);
	    	ps.setInt(1, v.getId_veiculo());
	    	
	    	int rowsAffected = ps.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            c.fecharConexao();
	            return true;
	        }
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	c.fecharConexao();
	    }
	    
		return false;
	}
	
	
	public boolean atualizar(Veiculo v) {
		Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    String query = "UPDATE veiculo SET quant_assento = ?, tipo_cambio = ?, quant_portas = ?, espaco_porta_malas = ?, marca = ?, nome = ?, cor = ?, nota_avaliacao = ?, preco_por_dia = ?, img_Base64 = ?, unidade_em_estoque = ?, categoria_id_categoria = ?, fornecedores_cnpj = ?,  WHERE id_veiculo = ?";
	
	    try {
	    	PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setInt(1, v.getQuant_assento());
	        preparedStatement.setString(2, v.getTipo_cambio());
	        preparedStatement.setInt(3, v.getQuant_portas());
	        preparedStatement.setInt(4, v.getEspaco_porta_malas());
	        preparedStatement.setString(5, v.getMarca());
	        preparedStatement.setString(6, v.getNome());
	        preparedStatement.setString(7, v.getCor());
	        preparedStatement.setInt(8, v.getAno());
	        preparedStatement.setInt(9, v.getNota_avaliacao());
//	        preparedStatement.setInt(10, v.getPreco_por_dia());
	        preparedStatement.setString(11,v.getImg_Base64());
	        preparedStatement.setInt(12, v.getUnidade_em_estoque());
//	        preparedStatement.setInt(13, v.getCategoria_id_categoria);
//	        preparedStatement.setBigDecimal(14, v.getFornecedores_cnpj);
	        
	        int rowsUpdated = preparedStatement.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            // Os dados foram atualizados com sucesso
	            return true;
	        } else {
	            // Nenhum registro foi atualizado (o CNPJ pode não existir)
	            return false;
	        }
	        
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	c.fecharConexao();
	    }
		return true;
	
	}

}
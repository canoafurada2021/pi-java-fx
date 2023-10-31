package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import modelo.AluguelRegistro;
import modelo.Categoria;
import modelo.EnumPagamento;
import modelo.Fornecedor;
import modelo.Locador;
import modelo.Vendedor;

public class AluguelRegistroDAO implements IAluguelRegistroDAO{


	public ArrayList<AluguelRegistro> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		ArrayList<AluguelRegistro> alugueis = new ArrayList<>();

		String query = "SELECT ar.id_venda, ar.forma_pagamento, ar.data_inicio, ar.quant_dias, ar.valor, v.id_vendedor, l.pessoas_cpf as locador_cpf "
				+ "FROM aluguelRegistro ar "
				+ "INNER JOIN locador l ON ar.locador_pessoas_cpf = l.pessoas_cpf "
				+ "INNER JOIN vendedor v ON ar.vendedor_id_vendedor = v.id_vendedor";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AluguelRegistro aluguel = new AluguelRegistro();

				Long idRegistro = rs.getLong("id_venda");
				String formaPagamento = rs.getString("forma_pagamento");
				Date dataInicio = rs.getDate("data_inicio");
				int quantDias = rs.getInt("quant_dias");
				Double valor = rs.getDouble("valor");
				Long idVendedor = rs.getLong("id_vendedor");
				String cpfLocador = rs.getString("locador_cpf");

				// Configurar o ID do aluguel
				aluguel.setIdVenda(idRegistro.intValue());


				// Configurar os outros atributos
				aluguel.setFormaPagamento(formaPagamento);
				aluguel.setDataInicio(dataInicio);
				aluguel.setQuantDias(quantDias);
				aluguel.setValor(valor);

				// Criar um objeto vendedor e configurar o ID do vendedor
				Vendedor vendedor = new Vendedor();
				vendedor.setId_vendedor(idVendedor);
				aluguel.setVendedor(vendedor);

				// Criar um objeto locador e configurar o CPF
				Locador locador = new Locador();
				locador.setPessoas_cpf(cpfLocador);
				aluguel.setLocador(locador);

				// Adicionar o AluguelRegistro à lista
				alugueis.add(aluguel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return alugueis;
	}


	public boolean inserir(AluguelRegistro ar) {
		// instancia a classe
		Conexao a = Conexao.getInstancia();
		// ABRE conexao com banco
		Connection con = a.conectar();

		String query = "INSERT INTO aluguelRegistro (forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf)"
				+ "VALUES (?, ?, ?, ?, ?, ?);";
	   
		boolean insercaoSucesso = false; // Inicializa com false


		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ar.getFormaPagamento());
			//conversão do date

			ps.setDate(2, ar.getDataInicio());
			ps.setInt(3, ar.getQuantDias());
			ps.setDouble(4,ar.getValor());
			ps.setLong(5, ar.getIdVendedor().getId_vendedor());
			ps.setString(6, ar.getPessoas_cpf().getPessoas_cpf());

		
			
			
			// Chave estrangeira para fornecedor, locador e vendedor

	        int linhasAfetadas = ps.executeUpdate();
	        

	        if (linhasAfetadas > 0) {
	            insercaoSucesso = true; // Define como true se pelo menos uma linha foi afetada
	        }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			a.fecharConexao();
		}

	    return insercaoSucesso; // Retorna o resultado da inserção
	}

	

	public boolean excluir(AluguelRegistro ar) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM aluguelRegistro WHERE id_venda = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ar.getIdVenda());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				c.fecharConexao();
				return true; // se bem sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return false; // se bem falha na exclusao
	}

	public boolean atualizar(AluguelRegistro ar) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE aluguelRegistro SET forma_pagamento = ?, data_inicio = ?, quant_dias = ?,"
				+ " valor = ?,  vendedor_id_vendedor = ?, locador_pessoas_cpf= ?"
				+ " WHERE id_venda = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ar.getFormaPagamento());
			//conversão do date

			ps.setDate(2, ar.getDataInicio());
			ps.setInt(3, ar.getQuantDias());
			ps.setDouble(4,ar.getValor());
			ps.setLong(5, ar.getIdVendedor().getId_vendedor());
			ps.setString(6, ar.getPessoas_cpf().getPessoas_cpf());
			ps.setLong(7, ar.getFornecedor().getCnpj());
			

			int rowsUpdate = ps.executeUpdate();
			
			if(rowsUpdate>0) {
				return true; //se alter bem sucedido
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			c.fecharConexao();
		}

	}

}

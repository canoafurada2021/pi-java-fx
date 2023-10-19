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

		  String query = "SELECT ar.*, f.nome as nomeFornecedor, l.cpf as locador_cpf,"
		  		+ " v.id_vendedor FROM aluguelRegistro ar"
		  		+ "	 INNER JOIN fornecedor f ON ar.fornecedor_id = f.id"
		  		+ "	 INNER JOIN locador l ON ar.locador_pessoas_cpf = l.pessoas_cpf"
		  		+ "  INNER JOIN vendedor v ON ar.vendedor_id_vendedor = v.id_vendedor";


		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
	            AluguelRegistro aluguel = new AluguelRegistro();

	            Long idRegistro = rs.getLong("id_venda");
				String formaPagamento = rs.getString("forma_pagamento");
				Timestamp dataInicio = rs.getTimestamp("data_inicio");
				int quantDias = rs.getInt("quant_dias");
				Double valor = rs.getDouble("valor");
				Long idVendedor = rs.getLong("id_vendedor");
				int pessoasCpf = rs.getInt("pessoas_cpf");
				Date data_inicio = rs.getDate("data_inicio");
				String cpfLocador = rs.getString("locador_cpf");
				
				//crie um objeto vendedor e configure os atributos
				Vendedor vendedor = new Vendedor();
					vendedor.setId_vendedor(idVendedor);
					//associe o vendedor ao aluguel
					aluguel.setIdVendedor(vendedor);
		            
				Locador locador = new Locador();
					locador.setPessoas_cpf(cpfLocador);
					//associando o lcoador ao aluguel
					aluguel.setPessoas_cpf(locador);
				
				 Fornecedor fornecedor = new Fornecedor();
		            fornecedor.setCnpj(idRegistro);
		            fornecedor.setNome(rs.getString("nomeFornecedor"));
		            aluguel.setFornecedor(fornecedor);

		            //resto das atribuições
		            aluguel.setFormaPagamento(formaPagamento);
		            aluguel.setDataInicio(dataInicio);
		            aluguel.setQuantDias(quantDias);
		            aluguel.setValor(valor);
		            aluguel.setIdVendedor(vendedor);
		            
		            //fazer o enum tipo pagamento
		            String tipoPagamentoString = rs.getString("forma_pagamento");
		            //converte a string pra um enum
		            EnumPagamento tipoPagamento = EnumPagamento.valueOf(tipoPagamentoString);
		            //atribui p valor do enum ao objeto alugel
		            aluguel.setTipoPagamento(tipoPagamento); //validar se esta certo
		            
		            
		            // Adicione o AluguelRegistro à lista
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

		String query = "INSERT INTO aluguelRegistro (forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf, fornecedor_id)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
	   
		boolean insercaoSucesso = false; // Inicializa com false


		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ar.getFormaPagamento());
			//conversão do date
			java.util.Date dataUtil = ar.getDataInicio(); // Suponha que ar.getDataInicio() retorne um java.util.Date
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			ps.setDate(2, dataSql);
			ps.setInt(3, ar.getQuantDias());
			ps.setDouble(4,ar.getValor());
			ps.setLong(5, ar.getIdVendedor().getId_vendedor());
			ps.setString(6, ar.getPessoas_cpf().getPessoas_cpf());
			ps.setLong(7, ar.getFornecedor().getCnpj());
		
			
			
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
				+ " valor = ?,  vendedor_id_vendedor = ?, locador_pessoas_cpf= ?, fornecedor_id = ?"
				+ " WHERE id_venda = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ar.getFormaPagamento());
			//conversão do date
			java.util.Date dataUtil = ar.getDataInicio(); // Suponha que ar.getDataInicio() retorne um java.util.Date
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			ps.setDate(2, dataSql);
			ps.setInt(3, ar.getQuantDias());
			ps.setDouble(4,ar.getValor());
			ps.setLong(5, ar.getIdVendedor().getId_vendedor());
			ps.setString(6, ar.getPessoas_cpf().getPessoas_cpf());
			ps.setLong(7, ar.getFornecedor().getCnpj());
			
			ps.setInt(8 , ar.getIdVenda());

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

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;

public class FornecedorDAO {

	public ArrayList<Fornecedor> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		// Caso a tabela a ser trabalhada no método de listagem houver uma chave
		// estrangeira vinculada a outra tabela
		// Será necessário aplicar um inner join (junção entre duas ou mais tabelas)
		// para ter o retorno correto dos dados
		// o exemplo abaixo faz uso do inner join na tabela fornecedores que possui a
		// chave estrangeira para endereços

		// Exemplo de como fazer mais de um inner join (apenas didático, essas tabelas
		// não existem no projeto):

		// onde: 'c' se refere a 'clientes', 'p' a 'pedidos' e 'ip' a 'itens_pedidos'

		// SELECT c.nome, p.data_pedido, ip.produto, ip.quantidade
		// FROM clientes c
		// INNER JOIN pedidos p ON c.id_cliente = p.id_cliente
		// INNER JOIN itens_pedido ip ON p.id_pedido = ip.id_pedido;

		String query = "SELECT f.*, e.rua FROM fornecedor f " + "INNER JOIN endereco e ON f.endereco_id = e.id";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Long cnpj = rs.getLong("cnpj");
				String nome = rs.getString("nome");
				Long telefone = rs.getLong("telefone");
				String atividades = rs.getString("atividades");

				Fornecedor f = new Fornecedor();

				f.setCnpj(cnpj);
				f.setNome(nome);
				f.setTelefone(telefone);
				f.setAtividades(atividades);

				// Crie um objeto Endereco e configure os atributos
				Endereco endereco = new Endereco();
				endereco.setRua(rs.getString("rua"));
				// Preencha os demais atributos do endereço se necessário

				// Associe o endereço ao fornecedor
				f.setEnderecoId(endereco);

				fornecedores.add(f);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return fornecedores;

	}

	public boolean inserir(Fornecedor f) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO fornecedor " + "(cnpj," + " endereco_id" + ", nome," + " atividades,"
				+ " telefone) " + "VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, f.getCnpj());
			ps.setLong(2, f.getEnderecoId().getId());
			ps.setString(3, f.getNome());
			ps.setString(4, f.getAtividades());
			ps.setLong(5, f.getTelefone());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}

		return true;
	}
	
	
	
	public boolean excluir(Fornecedor f) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "DELETE FROM fornecedor WHERE cnpj = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, f.getCnpj());
	        
	        int rowsAffected = ps.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            c.fecharConexao();
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        c.fecharConexao();
	    }
	    
	    return false;
	}
	
	
	public boolean atualizar(Fornecedor f) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    String query = "UPDATE fornecedor SET nome = ?, telefone = ?, atividades = ? WHERE cnpj = ?";
	    try {
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, f.getNome());
	        preparedStatement.setLong(2, f.getTelefone());
	        preparedStatement.setString(3, f.getAtividades()); 
	        preparedStatement.setLong(4, f.getCnpj()); 

	        int rowsUpdated = preparedStatement.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            // Os dados foram atualizados com sucesso
	            return true;
	        } else {
	            // Nenhum registro foi atualizado (o CNPJ pode não existir)
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        c.fecharConexao();
	    }
	}

	


}

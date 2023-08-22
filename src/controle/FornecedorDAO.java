package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedores;

public class FornecedorDAO {

	public ArrayList<Fornecedores> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Fornecedores> fornecedores = new ArrayList<>();
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

		String query = "SELECT f.*, e.rua FROM fornecedores f " + "INNER JOIN enderecos e ON f.enderecos_id = e.id";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Long cnpj = rs.getLong("cnpj");
				String nome = rs.getString("nome");
				Long telefone = rs.getLong("telefone");
				String atividades = rs.getString("atividades");

				Fornecedores f = new Fornecedores();

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

	public boolean inserir(Fornecedores f) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores " + "(cnpj," + " enderecos_id" + ", nome," + " atividades,"
				+ " telefone) " + "VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, f.getCnpj());
			ps.setInt(2, f.getEnderecoId().getId());
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
}

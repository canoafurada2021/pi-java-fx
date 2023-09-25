package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.EnumCargos;
import modelo.Vendedor;

public class VendedorDAO {

	public ArrayList<Vendedor> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Vendedor> vendedores = new ArrayList<>();

		String query = "SELECT * FROM vendedor";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int idVendedor = rs.getInt("id_vendedor");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				double salario = rs.getDouble("salario");

				// Recupere o valor do cargo do enum
				String cargoString = rs.getString("cargo");
				EnumCargos cargo = EnumCargos.valueOf(cargoString);

				Vendedor v = new Vendedor();
				v.setId_vendedor(idVendedor);

				v.setNome(nome);
				v.setSobrenome(sobrenome);
				v.setSalario(salario);
				v.setCargo(cargo);

				vendedores.add(v);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return vendedores;
	}

	public boolean inserir(Vendedor v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO vendedor " + "(" + " salario, " + "nome," + "sobrenome,"

				+ " cargo)" + " VALUES ( ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setDouble(1, v.getSalario());
			ps.setString(2, v.getNome());
			ps.setString(3, v.getSobrenome());
			// Defina o cargo diretamente usando o valor do enum
			ps.setString(4, EnumCargos.FUNCIONARIO.name());

			// Consolidar a execução do comando no banco
			ps.executeUpdate();

			// Fecha a conexão com o banco
			c.fecharConexao();

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false; // Retorna false em caso de falha na inserção
		}

		return true; // Retorna true se a inserção for bem-sucedida
	}
	
	
	
	public boolean excluir(Vendedor v) { //metodo de exclusao
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "DELETE FROM vendedor WHERE id_vendedor = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query); //prepara consulta sql
			ps.setInt(1, v.getId_vendedor());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				c.fecharConexao();
				return true; //se exclusao bem-sucessida
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.fecharConexao();
		}
		return false;// retorna false se falha na exclusao
		
	}
	
	
	public boolean atualizar(Vendedor v) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		//acho q o cargo n pode atualizar 
		String query = "UPDATE vendedor SET  salario = ?, nome = ?, sobrenome = ? WHERE id_vendedor = ? ";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setDouble(1, v.getSalario());
			preparedStatement.setString(2, v.getNome());
			preparedStatement.setString(3, v.getSobrenome());
			preparedStatement.setInt(4, v.getId_vendedor());
			
			int rowsUpdate = preparedStatement.executeUpdate();
			
			if(rowsUpdate >0 ) {
				//dados atualizados com sucesso
				return true;
			}else {
				//nenhum registro atualizado (id pode n existir)
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			c.fecharConexao();
		}
		
	}
	
	
	
}

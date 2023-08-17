package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.EnumRoles;
import modelo.Vendedores;

public class VendedoresDAO {

	public ArrayList<Vendedores> listar() {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    ArrayList<Vendedores> vendedores = new ArrayList<>();
	    
	    String query = "SELECT * FROM vendedores";
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            int idVendedor = rs.getInt("idvendedores");
	            String nome = rs.getString("nome");
	            double salario = rs.getDouble("salario");
	            
	            // Recupere o valor do cargo do enum
	            String cargoString = rs.getString("cargo");
	            EnumRoles cargo = EnumRoles.valueOf(cargoString);
	            
	            Vendedores v = new Vendedores();
	            v.setId_vendedor(idVendedor);;
	            v.setNome(nome);
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

	
	public boolean inserir(Vendedores v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = 
				"INSERT INTO vendedores "
				+ "(id_vendedor,"
				+ " salario, "
				+ "nome,"
				+ " cargo)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		
		 try {
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, v.getId_vendedor());
	            ps.setDouble(2, v.getSalario());
	            ps.setString(3, v.getNome());

	            // Defina o cargo diretamente usando o valor do enum
	            ps.setString(5, EnumRoles.FUNCIONARIO.name());
	            
	            
	            // Consolidar a execução do comando no banco
	            ps.executeUpdate();

	            // Fecha a conexão com o banco
	            c.fecharConexao();
	            
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	            return false; // Retorna false em caso de falha na inserção
	        }

	        return true; // Retorna true se a inserção for bem-sucedida
	    }
}

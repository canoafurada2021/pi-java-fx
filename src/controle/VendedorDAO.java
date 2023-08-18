package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.EnumRoles;
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
	            double salario = rs.getDouble("salario");
	            
	            // Recupere o valor do cargo do enum
	            String cargoString = rs.getString("cargo");
	            EnumRoles cargo = EnumRoles.valueOf(cargoString);
	            
	            Vendedor v = new Vendedor();
	            v.setId_vendedor(idVendedor);;
	            v.setNome(nome);
	            v.setSalario(salario);
	            v.setCargo(cargo);
	            
	            vendedores.add(v);
	            
	            System.out.println("vendedores do banco");
	            System.out.println(vendedores);
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

		String query = 
				"INSERT INTO vendedor "
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

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Empresa;
import modelo.TipoAcessoLogin;

public class EmpresaDAO {

    public boolean inserir(Empresa e) {

        // Instanciar a classe
        Conexao c = Conexao.getInstancia();

        // Abrir a conexao com o banco de dados
        Connection con = c.conectar();

        String query = "INSERT INTO empresa (razaosocial, telefone, cnpj, nome_fantasia, tipoAcessoLogin, porte_empresa) VALUES (?, ?, ?, ?, ?, ?);"; //adicionar o cargo aqui

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, e.getRazao_social());
            ps.setLong(2, e.getTelefone());
            ps.setString(3, Double.toString(e.getCnpj()));
            ps.setString(4, e.getNome());
            ps.setString(5, TipoAcessoLogin.MASTER.name());
            ps.setString(6, e.getNome_fantasia());
         
            
            // TODO 
//            ps.setString(5, TipoAcessoLogin.getById(0)); //conversão da role para o valor especifico estabelecido para essa coluna no banco

            ps.setString(7, e.getPorte_empresa());

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
    
    public boolean atualizar(Empresa e) {
    	Conexao c = Conexao.getInstancia();
    	Connection con = c.conectar();
    	String query = "UPDATE empresa SET razao_social = ?, telefone = ?, nome_fantasia = ?, porte_empresa = ? WHERE cnpj = ?";
    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		preparedStatement.setString(1, e.getNome());
    		preparedStatement.setString(2, e.getNome_fantasia());
    		preparedStatement.setString(3, e.getPorte_empresa());
    		preparedStatement.setString(4, e.getRazao_social());
    		preparedStatement.setLong(5, e.getCnpj());
    		preparedStatement.setLong(6, e.getTelefone());
    		
    		int rowsUpdate = preparedStatement.executeUpdate();
			
			if(rowsUpdate>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException em) {
			em.printStackTrace();
			return false;
		}finally {
			c.fecharConexao();
		}

    	}
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    


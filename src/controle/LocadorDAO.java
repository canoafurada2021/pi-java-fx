//package controle;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import modelo.Locador;
//
//public class LocadorDAO {
//
//	// Listar
//	public List<Locador>list(){
//		List<Locador>list = new ArrayList<>();
//		try{
//			//Instanciando a classe conexao
//			Conexao c = Conexao.getInstancia();
//
//			//Abrindo a conexao
//			Connection con = c.conectar();
//
//			//Consulta SQL, seleciona resgistros da tabela 'locador'
//			String query = "SELECT * FROM locador";
//
//			PreparedStatement ps = con.prepareStatement(query);
//
//			//Executando a consulta, o ResultSet... é executada ao armazenar o objetos em si, o qual contem os registros do banco em si
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				Locador l = new Locador();
//				l.setId(rs.getInt("id"));
//				l.setNome(rs.getString("nome"));
//				l.setSobrenome(rs.getString("sobrenome"));
//				l.setPessoas_cpf(rs.getInt("pessoas_cpf"));
//				l.setTel_contato(rs.getLong("tel_contato"));
//				l.setPaisResidencia(rs.getString("pais_residencia"));
//				l.setChn(rs.getLong("cnh"));
//				l.setValidadeCarteira(rs.getDate("validade_carteira"));
//				//l.setCargo(rs.getString("cargo"));
//				list.add(l); //o objeto locador é adicionado a lista list, após tudo isso
//			}
//	}
//
//	// Inserindo o locador
//	public boolean inserir (Locador l) {
//
//		Conexao c = Conexao.getInstancia();
//
//		// Abrindo conexao banco
//		Connection con = c.conectar();
//
//		String query = "INSERT INTO locador (pessoas-cpf, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//
//		try {
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, l.getNome());
//			ps.setString(2, l.getSobrenome());
//			ps.setLong(3, l.getPessoas_cpf());
//			ps.setLong(4, l.getTel_contato());
//			ps.setString(5, l.getPaisResidencia());
//			ps.setLong(6, l.getChn());
//			//ps.setDate(7, l.getValidadeCarteira());
//			ps.setLong(8, l.getNumIdentificacaoCarteira());
//			//ps.setLong(9, l.getCargo());
//
//		} catch (SQLException l1) {
//			l1.printStackTrace();
//			return false;
//		}
//
//		return true;
//	
//	
//}}
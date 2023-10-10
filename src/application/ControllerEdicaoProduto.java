package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.CategoriaDAO;
import controle.FornecedorDAO;
import controle.VeiculoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Veiculo;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerEdicaoProduto implements Initializable {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private ComboBox<Long> comboCategoria;

	@FXML
	private ComboBox<Long> comboFornecedor;

	@FXML
	private Label lblCor;

	@FXML
	private Label lblEpacoPortaMalas;

	@FXML
	private Label lblFornecedor;

	@FXML
	private Label lblMarca;

	@FXML
	private Label lblMarcaVeiculo2;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblNomeVeiculo;

	@FXML
	private Label lblNotaAvaliacao;

	@FXML
	private Label lblPrecoPorDia;

	@FXML
	private Label lblQuantPortas;

	@FXML
	private Label lblQuantidadeVeiculos;

	@FXML
	private Label lblTipoCambio;

	@FXML
	private Label lblUnidadeEmEstoque;

	@FXML
	private Label lvlQuantAssentos;

	@FXML
	private Pane pnlLocacaoEdicao;

	@FXML
	private TextField txtCor;

	@FXML
	private TextField txtEspacoPortaMalas;

	@FXML
	private TextField txtIdVeiculo;

	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtNotaAvaliacao;

	@FXML
	private TextField txtPrecoPorDia;

	@FXML
	private TextField txtQuantAssentos;

	@FXML
	private TextField txtAno;

	@FXML
	private TextField txtQuantPortas;

	@FXML
	private TextField txtTipoCambio;

	@FXML
	private TextField txtUnidadeEmEstoque;

	private VeiculoDAO dao = new VeiculoDAO();
	private ArrayList<Veiculo> veiculos = dao.listar();
	private CategoriaDAO daoCat = new CategoriaDAO();
	private ArrayList<Categoria> categorias = daoCat.listar();

	Veiculo veiculo = new Veiculo();
	
	private FornecedorDAO daoFor = new FornecedorDAO();
	private ArrayList<Fornecedor> fornecedores = daoFor.listar();

	@FXML
	void cancelarAlteracaoProduto(ActionEvent event) {
				Node source = (Node) event.getSource();

				Stage stage = (Stage) source.getScene().getWindow();

				stage.close();
	}

	

	@FXML
	void salvarAlteracaoProduto(ActionEvent event) {
			//método de alterar
		
		Integer veiculosId = Integer.valueOf(txtIdVeiculo.getText());
		Integer quantAssento = Integer.valueOf(txtQuantAssentos.getText());
		String corVeiculo = txtCor.getText();
		Integer espacoPortaMalas = Integer.valueOf(txtEspacoPortaMalas.getText());
		String marca = txtMarca.getText();
		String nome = txtNome.getText();
		Integer notaAvaliacao = Integer.valueOf(txtNotaAvaliacao.getText());
		Integer ano = Integer.valueOf(txtAno.getText());
		Integer quantPortas = Integer.valueOf(txtQuantPortas.getText());
		String cambio = txtTipoCambio.getText();
		Long precoDia = Long.parseLong(txtPrecoPorDia.getText());
		Integer unidadeEstoque = Integer.valueOf(txtUnidadeEmEstoque.getText());
		
		// Obtém o CNPJ selecionado do comboFornecedor
		Long cnpjSelecionado = comboFornecedor.getValue();
		// Encontra o objeto Fornecedor correspondente ao CNPJ
		Fornecedor fornecedorSelecionado = encontrarFornecedorPorCnpj(cnpjSelecionado);
		//idem categoriaID
		
		Long idSelecionado = comboCategoria.getValue();
		Categoria categoriaSelecionada = encontrarCategoria(idSelecionado);
		
		
		Veiculo veiculo = new Veiculo();
	
		veiculo.setAno(ano);
		veiculo.setCor(corVeiculo);
		veiculo.setEspaco_porta_malas(espacoPortaMalas);
		veiculo.setId_veiculo(veiculosId);
		veiculo.setMarca(marca);
		veiculo.setNome(nome);
		veiculo.setNota_avaliacao(notaAvaliacao);
		veiculo.setPreco_por_dia(precoDia);
		veiculo.setQuant_assento(quantAssento);
		veiculo.setUnidade_em_estoque(unidadeEstoque);
		veiculo.setQuant_portas(quantPortas);
		veiculo.setTipo_cambio(cambio);
		
		// Define o Fornecedor no veiculo
		veiculo.setCnpj(fornecedorSelecionado);
		veiculo.setIdCategoria(categoriaSelecionada);

		if(dao.atualizar(veiculo)) {
			ExibePopUpSucesso.ExibirPopUpSucesso();
			
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();

			stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

			System.out.println("deu bomba " + stage);

			stage.close();
		}else {
			ExibePopUpErro.ExibirPopUpErro();
			System.out.println("nao atualizou");
		}
			
		
	}

	public void seVeiculo(Veiculo v) {
		txtIdVeiculo.setText(String.valueOf(v.getId_veiculo()));
		txtCor.setText(v.getCor());
		txtEspacoPortaMalas.setText(String.valueOf(v.getEspaco_porta_malas()));
		txtMarca.setText(v.getMarca());
		txtNome.setText(v.getNome());
		txtNotaAvaliacao.setText(String.valueOf(v.getNota_avaliacao()));
		txtPrecoPorDia.setText(String.valueOf(v.getPreco_por_dia()));
		txtQuantAssentos.setText(String.valueOf(v.getQuant_assento()));
		txtAno.setText(String.valueOf(v.getAno()));
		txtQuantPortas.setText(String.valueOf(v.getQuant_portas()));
		txtTipoCambio.setText(v.getTipo_cambio());
		txtUnidadeEmEstoque.setText(String.valueOf(v.getUnidade_em_estoque()));
		
		if (v.getIdCategoria() != null) {
			 long categoriaId = v.getIdCategoria().getIdCategoria();  // Supondo que getIdCategoria() retorna um long
			    int categoriaIndex = encontrarIndiceCategoria(categoriaId);
			    String categoriaText = String.valueOf(categoriaId);

			    comboCategoria.getEditor().setText(categoriaText);
			    
			    if(categoriaText.equals("-1")) {
			    	  // Definir o índice no ComboBox
			    	comboCategoria.getEditor().setText(categoriaText);
			    	comboCategoria.getSelectionModel().select(categoriaIndex);
			    }
		}
		
		if(v.getCnpj() !=  null) {
			long cnpjFornecedor = v.getCnpj().getCnpj();
			int cnpjIndex = encontrarIndiceFornecedor(cnpjFornecedor);
			String cnpjText = String.valueOf(cnpjFornecedor);
			
			comboFornecedor.getEditor().setText(cnpjText);
			
			if(cnpjText.equals("-1")) {
				  // Definir o índice no ComboBox
				comboFornecedor.getEditor().setText(cnpjText);
				comboFornecedor.getSelectionModel().select(cnpjIndex);
			}
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		preencherComboCategoria();
		preencherComboFornecedor();
		txtIdVeiculo.setDisable(true);
	}

	//comobo box categoria 
	private int encontrarIndiceCategoria(long categoriaId) {
		for (int i = 0; i < categorias.size(); i++) {
			if(categorias.get(i).getIdCategoria()== categoriaId) {
			System.out.println("idnice categoria "+ categoriaId);
			return i;
			}
		}return-1;
	}
	
	private void preencherComboCategoria() {
		for (Categoria categoria : categorias) {
			Long categoriaInfo = categoria.getIdCategoria();
			comboCategoria.getItems().add(categoriaInfo);
		}
	}
	
	private int encontrarIndiceFornecedor(long cnpjFornecedor) {
		for (int i = 0; i < fornecedores.size(); i++) {
			if(fornecedores.get(i).getCnpj() == cnpjFornecedor){
				System.out.println("indice fornecedor " + i);
				return i;
			}
		}
		return -1;
	}
	
	//p combo box
	private void preencherComboFornecedor() {
		for (Fornecedor fornecedor : fornecedores) {
			Long fornecedorInfo = fornecedor.getCnpj();
			comboFornecedor.getItems().add(fornecedorInfo);
		}
	}
	private Fornecedor encontrarFornecedorPorCnpj(long cnpjFornecedor) {
	    for (Fornecedor fornecedor : fornecedores) {
	        if (fornecedor.getCnpj() == cnpjFornecedor) {
	            return fornecedor;
	        }
	    }
	    return null;  // Retorna null se nenhum fornecedor for encontrado com o CNPJ
	}
	
	private Categoria encontrarCategoria (long idDaCategoria) {
		for (Categoria categoria : categorias) {
			if(categoria.getIdCategoria() == idDaCategoria) {
				return categoria;
			}
		}return null;
	}

}

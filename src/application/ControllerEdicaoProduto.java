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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Veiculo;

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
	private TextField txtUniadeEmEstoque;

	private VeiculoDAO dao = new VeiculoDAO();
	private ArrayList<Veiculo> veiculos = dao.listar();
	private CategoriaDAO daoCat = new CategoriaDAO();
	private ArrayList<Categoria> categorias = daoCat.listar();

	Veiculo veiculo = new Veiculo();
	
	private FornecedorDAO daoFor = new FornecedorDAO();
	private ArrayList<Fornecedor> fornecedores = daoFor.listar();

	@FXML
	void cancelarAlteracaoProduto(ActionEvent event) {

	}

	

	@FXML
	void salvarAlteracaoProduto(ActionEvent event) {

		
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
}

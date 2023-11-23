package application;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.CategoriaDAO;
import controle.FornecedorDAO;
import controle.VeiculoDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Veiculo;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerCadastroProduto implements Initializable {


	@FXML
	private Label lblQuantAssentos;

	@FXML
	private Label lblTipoCambio;

	@FXML
	private TextField txtTipoCambio;

	@FXML
	private Label lblQuantPortas;

	@FXML
	private Button btnCadastrarVeiculo;

	@FXML
	private Button btnProdutos;

	@FXML
	private Button btnSair;

	@FXML
	private TextField txtQuantPortas;

	@FXML
	private Label lblEspacoPortaMalas;

	@FXML
	private Label lblMarca;

	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtQuantAssentos;

	@FXML
	private TextField txtEspacoPortaMalas;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCor;

	@FXML
	private Label lblCor;

	@FXML
	private Label lblAno;

	@FXML
	private TextField txtAno;

	@FXML
	private Label lblNotaAvaliacao;

	@FXML
	private TextField txtNotaAvaliacao;

	@FXML
	private TextField txtPrecoPorDia;

	@FXML
	private Label lblPrecoPorDia;

	@FXML
	private TextField txtUnidadeEmEstoque;

	@FXML
	private Label lblUnidadeEmEstoque;

	@FXML
	private TextField txtCategorias;

	@FXML
	private Label lblCategoria;

	@FXML
	private TextField txtCNPJFornecedor;

	@FXML
	private Label lblCNPJFornecedor;
//
//	@FXML
//	private TextField txtImgBase64;

	@FXML
	private ComboBox<String> comboCategoriaIds;

	@FXML
	private ComboBox<String> comboFornecedorIds;

	CategoriaDAO daoCategoria = new CategoriaDAO();

	// para listar as categorias, já que está usando o comboBox, para listar todos
	// os ids já cadastrados
	ArrayList<Categoria> categorias = daoCategoria.listar();

	private FornecedorDAO daoFornecedor = new FornecedorDAO();
	private ArrayList<Fornecedor> fornecedores = daoFornecedor.listar();
	VeiculoDAO daoVeiculo = new VeiculoDAO();

	@FXML
	void cadastrarVeiculo(ActionEvent event) {

		int quantAssento = Integer.parseInt(txtQuantAssentos.getText());
		String tipoCambio = txtTipoCambio.getText();
		int quantPortas = Integer.parseInt(txtQuantPortas.getText());
		int espacoPortaMalas = Integer.parseInt(txtEspacoPortaMalas.getText());
		String marca = txtMarca.getText();
		String nome = txtNome.getText();
		String cor = txtCor.getText();
		int ano = Integer.parseInt(txtAno.getText());
		int notaAvaliacao = Integer.parseInt(txtNotaAvaliacao.getText());
		Long precoPorDia = Long.parseLong(txtPrecoPorDia.getText());
		int unidadeEmEstoque = Integer.parseInt(txtUnidadeEmEstoque.getText());

		String selectedCategoriaInfo = comboCategoriaIds.getValue();

		int categoriaId = Integer.parseInt(selectedCategoriaInfo.split(" - ")[0]);

		Categoria categoriaSelecionada = encontrarCategoriaporId(categoriaId);

		String selectedFornecedorInfo = comboFornecedorIds.getValue();
		Long fornecedorCnpj = Long.parseLong(selectedFornecedorInfo.split(" - ")[0]);
		Fornecedor fornecedorSelecionado = EncontrarFornecedorPorId(fornecedorCnpj);

		Veiculo v = new Veiculo();

		v.setQuant_assento(quantAssento);
		v.setTipo_cambio(tipoCambio);
		v.setQuant_portas(quantPortas);
		v.setEspaco_porta_malas(espacoPortaMalas);
		v.setMarca(marca);
		v.setNome(nome);
		v.setCor(cor);
		v.setAno(ano);
		v.setNota_avaliacao(notaAvaliacao);
		v.setPreco_por_dia(precoPorDia);
		v.setUnidade_em_estoque(unidadeEmEstoque);

		v.setCategoria(categoriaSelecionada);
		v.setCnpj(fornecedorSelecionado);

		try {

			boolean insercaoSucesso = daoVeiculo.inserir(v);

			limpaCampos();

			if (insercaoSucesso) {
				System.out.println("inserção sucesso" + insercaoSucesso);
				System.out.println("deu bom");
				ExibePopUpSucesso.ExibirPopUpSucesso();
			} else {
				ExibePopUpErro.ExibirPopUpErro();
				System.out.println("n deu bom");
				System.out.println(v.getCategoria());
			}

		} catch (Exception e) {

			ExibePopUpSucesso.ExibirPopUpSucesso();

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println(categorias);
		System.out.println(fornecedores);

		preencherComboCategoria();
		preencherComboFornecedores();

	}

	private void preencherComboCategoria() {
		for (Categoria categoria : categorias) {
			String categoriaInfo = categoria.getIdCategoria() + " - " + categoria.getCategoria();
			comboCategoriaIds.getItems().add(String.valueOf(categoriaInfo));
		}
	}

	private void preencherComboFornecedores() {
		for (Fornecedor fornecedor : fornecedores) {
			String fornecedorInfo = fornecedor.getCnpj() + " - " + fornecedor.getNome();
			comboFornecedorIds.getItems().add(fornecedorInfo);
		}
	}

	private Categoria encontrarCategoriaporId(int categoriaId) {
		for (Categoria categoria : categorias) {
			if (categoria.getIdCategoria() == categoriaId) {
				return categoria;
			}
		}

		return null; // Retorna null se não encontrar o endereço
	}

	private Fornecedor EncontrarFornecedorPorId(Long fornecedorCnpj) {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getCnpj() == fornecedorCnpj) {
				return fornecedor;
			}
		}

		return null; // Retorna null se não encontrar o endereço
	}

	private void limpaCampos() {
		txtQuantAssentos.setText(null);
		txtTipoCambio.setText(null);
		txtQuantPortas.setText(null);
		txtEspacoPortaMalas.setText(null);
		txtMarca.setText(null);
		txtNome.setText(null);
		txtCor.setText(null);
		txtAno.setText(null);
		txtNotaAvaliacao.setText(null);
		txtPrecoPorDia.setText(null);
		// txtImgBase64.setText(null);
		txtUnidadeEmEstoque.setText(null);
	}
	@FXML
    void saircCadProdLogin(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
			Parent root = loader.load();

			ControllerLogin controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@FXML
	void abrirTelaListagemProduto(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Produtos.fxml"));
			Parent root = loader.load();

			ControllerListProdutos controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

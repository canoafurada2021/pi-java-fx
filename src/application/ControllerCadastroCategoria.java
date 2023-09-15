package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.CategoriaDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Categoria;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerCadastroCategoria implements Initializable{

	@FXML
    private StackPane StackPanePerfil;

    @FXML
    private Button btnConfiguracoes;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnFuncionarios;

    @FXML
    private Button btnLocacao;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private ComboBox<String> comboIdCategoria;

    @FXML
    private ImageView imgDefaultConfiguracoes;

    @FXML
    private ImageView imgDefaultDashboard;

    @FXML
    private ImageView imgDefaultFornecedores;

    @FXML
    private ImageView imgDefaultFuncionarios;

    @FXML
    private ImageView imgDefaultLocacao;

    @FXML
    private ImageView imgDefaultProdutos;

    @FXML
    private ImageView imgDefaultUsuarios;

    @FXML
    private ImageView imgFotoPerfil;

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgSair;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblFuncao;

    @FXML
    private Label lblIdCategoria;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private TextField txtCategoria;
    
 // instanciando DAOCategora (pra pegar os metodos)
	CategoriaDAO daoCategoria = new CategoriaDAO();
    
	//para listar as categorias, já que está usando o comboBox, para listar todos os ids já cadastrados
    ArrayList<Categoria> categorias = daoCategoria.listar();
    
    @FXML
    void cadastrarCategoria(ActionEvent event) {
    	
    	
    	
    	//Conversão a variavel e atribuido os valores
    	String idCategoriaSelect = comboIdCategoria.getValue();    	
    	System.out.println("Id selecionado + idCategoriaSelect");
    	
    	String nomeCategoria = txtCategoria.getText();

    	//Instaciando os atributos, variaveis, a própria categoria
    	Categoria c = new Categoria();
        
    	c.setCategoria(nomeCategoria);
    	
    	//chamando o metodos pra fazer as validações (que já existem no pacote utilities)
    	try {

			boolean insercaoSucesso = daoCategoria.inserir(c);

			limpaCampos();

			if (insercaoSucesso) {
				ExibePopUpSucesso.ExibirPopUpSucesso();
			} else {
	        	ExibePopUpErro.ExibirPopUpErro();
			}

		} catch (Exception e) {

			ExibePopUpSucesso.ExibirPopUpSucesso();

		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		preencherComboBoxCategoria();
	}
	
	private void limpaCampos() {
		//Para quando cadastrar os dados, ele automaticamente limpar os campos
		txtCategoria.setText(null);
	}
	
	private void preencherComboBoxCategoria() {
		for (Categoria categoria : categorias) {
			int categoriaInfo = categoria.getIdCategoria();
			comboIdCategoria.getItems().add(String.valueOf(categoriaInfo));
		}
	}

}

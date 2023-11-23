package application;

import controle.VeiculoDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.Veiculo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPopUpVisuProduto implements Initializable {

    @FXML
    private AnchorPane Panel;

    @FXML
    private Label lblAno;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblCor;

    @FXML
    private Label lblFornecedor;

    @FXML
    private Label lblIProduto;

    @FXML
    private Label lblIdProduto11;

    @FXML
    private Label lblIdProduto111;

    @FXML
    private Label lblIdProduto2;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblNome11;

    @FXML
    private Label lblNome2;

    @FXML
    private Label lblNome21;

    @FXML
    private Label lblQuantAssentos;

    @FXML
    private Pane panelButtons;

    @FXML
    private Pane panelFotoVeiculo;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtIdProduto;

    @FXML
    private TextField txtIdProduto11;

    @FXML
    private TextField txtIdProduto111;

    @FXML
    private TextField txtIdProduto2;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNome11;

    @FXML
    private TextField txtNome2;

    @FXML
    private TextField txtNome21;

    @FXML
    private TextField txtQuantAssentos;


    private VeiculoDAO dao = new VeiculoDAO();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
String id;
String tipoCambio;
String nome;
String quantPortas;
String marca;
String espacoPortaMalas;
String ano;
String notaAvaliacao;
String categoria;
String uniEmEstoque;
String cor;
String precoDia;
String quantAssentos;
String fornecedor;



    }


    public void setVeiculo(Veiculo v){



    }



}

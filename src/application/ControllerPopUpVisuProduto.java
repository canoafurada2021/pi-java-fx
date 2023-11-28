package application;

import controle.CategoriaDAO;
import controle.FornecedorDAO;
import controle.VeiculoDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Veiculo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPopUpVisuProduto implements Initializable {

    @FXML
    private AnchorPane Panel;

    @FXML
    private ImageView imgVeiculo;

    @FXML
    private Label lblAno;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblCor;

    @FXML
    private Label lblEspacoPortaMalas;

    @FXML
    private Label lblFornec;

    @FXML
    private Label lblId;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblNotaAvaliacao;

    @FXML
    private Label lblPrecoPorDia;

    @FXML
    private Label lblQuantAssentos;

    @FXML
    private Label lblQuantPortas;

    @FXML
    private Label lblTipoCambio;

    @FXML
    private Label lblUnidadeEmEstoque;

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
    private TextField txtEspacoPortaMalas;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtId;

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

    public void setVeiculoVizu(Veiculo v){
        txtAno.setText(String.valueOf(v.getAno()));
        txtCategoria.setText(v.getCategoria().getCategoria());
        txtCor.setText(v.getCor());
        txtId.setText(String.valueOf(v.getId_veiculo()));
        txtMarca.setText(v.getMarca());
        txtEspacoPortaMalas.setText(String.valueOf(v.getEspaco_porta_malas()));
//        txtFornecedor.setText(v.getCnpj().getNome());
        txtNome.setText(v.getNome());
        txtNotaAvaliacao.setText(String.valueOf(v.getNota_avaliacao()));
        txtPrecoPorDia.setText(v.getPreco_por_dia().toString());
        txtQuantAssentos.setText(String.valueOf(v.getQuant_assento()));
        txtQuantPortas.setText(String.valueOf(v.getQuant_portas()));
        txtTipoCambio.setText(v.getTipo_cambio());
        txtUnidadeEmEstoque.setText(String.valueOf(v.getUnidade_em_estoque()));
        txtFornecedor.setText(v.getCnpj().getNome());


    }

    private int encontrarIndexVeiculo(int idVeiculo) {
        for(int i=0; i<veiculos.size(); i++){
            if(veiculos.get(i).getId_veiculo() == idVeiculo) {
                System.out.println("indeice: " + i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtAno.setDisable(true);
        txtCategoria.setDisable(true);
        txtCor.setDisable(true);
        txtId.setDisable(true);
        txtMarca.setDisable(true);
        txtEspacoPortaMalas.setDisable(true);
        txtFornecedor.setDisable(true);
        txtNome.setDisable(true);
        txtNotaAvaliacao.setDisable(true);
        txtPrecoPorDia.setDisable(true);
        txtQuantPortas.setDisable(true);
        txtQuantAssentos.setDisable(true);
        txtTipoCambio.setDisable(true);
        txtUnidadeEmEstoque.setDisable(true);
    }


    private Fornecedor encontrarFornecedor(Long cnpj) {
        System.out.println(cnpj);

        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getCnpj().equals(cnpj)) {
                return fornecedor;

            }
        }

        return null;
    }
}

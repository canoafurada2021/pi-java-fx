package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerCadastroProduto {

    @FXML
    private TextField txtIdVeiculo;

    @FXML
    private TextField txtQuantAssentos;

    @FXML
    private TextField txtTipoCambio;

    @FXML
    private TextField txtQuantPortas;

    @FXML
    private TextField txtEspacoPortaMalas;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtNotaAvaliacao;

    @FXML
    private TextField txtPrecoPorDia;

    @FXML
    private TextField txtUnidadeEmEstoque;

    @FXML
    private TextField txtCategorias;

    @FXML
    private TextField txtCBPJFornecedor;

    @FXML
    private Button btnCadastrarVeiculo;

    @FXML
    private void cadastrarVeiculo(ActionEvent event) {
        // Implemente a lógica para cadastrar o veículo com base nos campos preenchidos
        System.out.println("Botão Cadastrar Veículo pressionado");

        // Exemplo de como obter os valores dos campos
        String idVeiculo = txtIdVeiculo.getText();
        String quantAssentos = txtQuantAssentos.getText();
        // ... e assim por diante

        // Implemente aqui a lógica para cadastrar o veículo no banco de dados ou onde for necessário
    }

    // Aqui você pode adicionar outros métodos conforme necessário

}

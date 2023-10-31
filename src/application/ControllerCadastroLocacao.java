package application;

import controle.AluguelRegistroDAO;
import controle.LocadorDAO;
import controle.VendedorDAO;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.AluguelRegistro;
import modelo.Endereco;
import modelo.Locador;
import modelo.Vendedor;
import utilities.CnpjFormatter;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;
import utilities.TelefoneFormatter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCadastroLocacao {

    @FXML
    private StackPane StackPanePerfil;

    @FXML
    private Button btnCadastrarLocacao;

    @FXML
    private Button btnCategorias;

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
    private ComboBox<String> comboCpfLocador;

    @FXML
    private ComboBox<String> comboIdVendedor;

    @FXML
    private DatePicker dateDataInicio;

    @FXML
    private ImageView imgDefaultConfiguracoes;

    @FXML
    private ImageView imgDefaultConfiguracoes1;

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
    private Label lblCpfLocador;

    @FXML
    private Label lblFormaPagamento;

    @FXML
    private Label lblFuncao;

    @FXML
    private Label lblIdVendedor;

    @FXML
    private Label lblMarcaVeiculo;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Label lblQuantDias;

    @FXML
    private Label lblValor;

    @FXML
    private TextField txtFormaPagamento;

    @FXML
    private TextField txtQuantDias;

    @FXML
    private TextField txtValor;

    private VendedorDAO dao = new VendedorDAO();
    private ArrayList<Vendedor> vendedores = dao.listar();

    private LocadorDAO daoL = new LocadorDAO();
    private ArrayList<Locador> locadores = (ArrayList<Locador>) daoL.listar();


    @FXML
    void cadastrarLocacao(ActionEvent event) {
        AluguelRegistroDAO daoAluguelRegistro = new AluguelRegistroDAO();

        String formaPagamento = txtFormaPagamento.getText();
        LocalDate dataInicio = dateDataInicio.getValue();

        String quantDiasF = txtQuantDias.getText();
        Integer quantDias = Integer.parseInt(quantDiasF);

        String valorF = txtValor.getText();
        Double valor = Double.parseDouble(valorF);

        //vendedor selecionado
        String selectedVendedor = comboIdVendedor.getValue();
        int vendedorId = Integer.parseInt(selectedVendedor.split(" - ")[0]);
        Vendedor vendedorSelecionado = encontrarVendedorPorId(vendedorId);

        // locador selecionado
        String selectedLocador = comboCpfLocador.getValue();
        Locador locadorSelecionado = encontrarLocadorPorCpf(selectedLocador);

        AluguelRegistro a = new AluguelRegistro();

        a.setFormaPagamento(formaPagamento);
        a.setDataInicio(dataInicio);
        a.setQuantDias(quantDias);
        a.setValor(valor);
        a.setIdVendedor(vendedorSelecionado);
        a.setPessoas_cpf(locadorSelecionado);

        try {
            boolean insercaoSucesso = daoAluguelRegistro.inserir(a);

            limpaCampos();

            ExibePopUpSucesso.ExibirPopUpSucesso();

            if(insercaoSucesso){
            }else{
                ExibePopUpErro.ExibirPopUpErro();
            }
        } catch (Exception e){
            ExibePopUpSucesso.ExibirPopUpSucesso();
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {


        txtFormaPagamento.textProperty()
                .addListener((ChangeListener<? super String>) (observableValue, oldValue, newValue) -> {
                    if (newValue != null && !newValue.isEmpty()) {
                        txtFormaPagamento.setText(TelefoneFormatter.formatTelefoneBrasil(newValue));
                    }
                });

        txtValor.textProperty().addListener((ChangeListener<? super String>) (observableValue, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                txtValor.setText(CnpjFormatter.formatCnpj(newValue));
            }
        });

        preencherComboBox();
    }

    private void preencherComboBox() {
        for (Vendedor vendedor : vendedores){
            String vendedorInfo = vendedor.getId_vendedor()+ " - "+ vendedor.getNome();
            comboIdVendedor.getItems().add(vendedorInfo);
        }

        for (Locador locador : locadores){
            String locadorInfo = locador.getPessoas_cpf()+" - "+locador.getNome();
            comboCpfLocador.getItems().add(locadorInfo);
        }
    }

    private void limpaCampos() {
        txtFormaPagamento.setText(null);
        txtValor.setText(null);
        txtQuantDias.setText(null);
        dateDataInicio.setValue(null);
    }

    private Locador encontrarLocadorPorCpf(String selectedLocador) {
        for (Locador locador : locadores){
            if (locador.getPessoas_cpf().equals(selectedLocador)){
                return locador;
            }

        }
        return null;
    }

    private Vendedor encontrarVendedorPorId(int vendedorId) {
        for (Vendedor vendedor : vendedores){
            if (vendedor.getId_vendedor() == vendedorId){
                return vendedor;
            }
        }
        return null; // retorna null se não encontrar o vendedor
    }

    @FXML
    void abrirDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
            Parent root = loader.load();

            ControllerDashboard controllerNovaTela = loader.getController();

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
    void abrirListLocacoes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Locacoes.fxml"));
            Parent root = loader.load();

            ListViewController controllerNovaTela = loader.getController();

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
    void sair(ActionEvent event) {
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
    void sairCadFornLogin(ActionEvent event) {
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
    void abrirListClientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/ListClientes.fxml"));
            Parent root = loader.load();

            ControllerListClientes controllerNovaTela = loader.getController();

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
    void abrirListFornecedores(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
            Parent root = loader.load();

            ControllerListFornecedores controllerNovaTela = loader.getController();

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
    void abrirListFuncionarios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Funcionarios.fxml"));
            Parent root = loader.load();

            ControllerTableViewFuncionarios controllerNovaTela = loader.getController();

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
    void abrirListProdutos(ActionEvent event) {
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

    @FXML
    void abrirTelaConfiguracoes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracoes.fxml"));
            Parent root = loader.load();

            ControllerConfiguracoes controllerNovaTela = loader.getController();

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
    void abrirTelaDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
            Parent root = loader.load();

            ControllerDashboard controllerNovaTela = loader.getController();

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

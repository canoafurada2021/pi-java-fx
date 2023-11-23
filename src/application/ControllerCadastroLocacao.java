package application;

import controle.AluguelRegistroDAO;
import controle.LocadorDAO;
import controle.VendedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.CurrencyStringConverter;
import modelo.AluguelRegistro;
import modelo.Locador;
import modelo.Vendedor;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCadastroLocacao implements Initializable {

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
    @FXML
    private TextField txtData;

    private final VendedorDAO vendedorDAO = new VendedorDAO();
    private final LocadorDAO locadorDAO = new LocadorDAO();

    private ArrayList<Vendedor> vendedores = vendedorDAO.listar();
    private ArrayList<Locador> locadores = locadorDAO.listar();

    @FXML
    void cadastrarLocacao(ActionEvent event) {
        AluguelRegistroDAO daoAluguelRegistro = new AluguelRegistroDAO();

        String formaPagamento = txtFormaPagamento.getText();
        String dataInicio = txtData.getText();
        Integer quantDias = Integer.parseInt(txtQuantDias.getText());
        Double valor = Double.parseDouble(txtValor.getText());

        String selectedVendedorInfo = comboIdVendedor.getValue();
        int vendedorId = Integer.parseInt(selectedVendedorInfo.split(" - ")[0]);
        Vendedor vendedorSelecionado = encontrarVendedorSelecionado(vendedorId);

        String selectedLocadorInfo = comboCpfLocador.getValue();
        String locadorId = selectedLocadorInfo.split(" - ")[0];
        Locador locadorSelecionado = encontrarLocadorSelecionado(locadorId);
        // Define o formato da máscara de dinheiro


// Agora, você pode usar o valor formatado como um Double
        AluguelRegistro a = new AluguelRegistro();

        a.setFormaPagamento(formaPagamento);
        a.setDataInicio(dataInicio);
        a.setQuantDias(quantDias);
        a.setValor(valor);
        a.setVendedor(vendedorSelecionado);
        a.setLocador(locadorSelecionado);


        try {


            boolean insercaoSucesso = daoAluguelRegistro.inserir(a);
            if (insercaoSucesso) {
                limpaCampos();
                ExibePopUpSucesso.ExibirPopUpSucesso();
            } else {
                ExibePopUpErro.ExibirPopUpErro();
            }
        } catch (Exception e) {
            ExibePopUpSucesso.ExibirPopUpSucesso();
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherComboVendedor();
        preencherComboLocador();

//        TextFormatter<String> valueFormatter = new TextFormatter<Double>(
//                new CurrencyStringConverter(), // Usando um conversor de moeda para formatar o texto
//                0.0, // Valor padrão
//                change -> {
//                    if (change.getControlNewText().matches("\\d*\\.?\\d*")) {
//                        return change;
//                    } else {
//                        return null;
//                    }
//                }
//        );
//
//        // Associe o TextFormatter ao TextField
//        txtValor.setTextFormatter(valueFormatter);
    }


    private void limpaCampos() {
        txtFormaPagamento.setText(null);
        txtValor.setText(null);
        txtQuantDias.setText(null);
        txtData.setText(null);
    }


    private void preencherComboVendedor() {
        for (Vendedor vendedor : vendedores) {
            String vendedorInfo = vendedor.getId_vendedor() + " - " + vendedor.getNome();
            comboIdVendedor.getItems().add(vendedorInfo);
        }
        System.out.println("Tamanho do ComboBox de Vendedor: " + comboIdVendedor.getItems().size());

    }


    private void preencherComboLocador() {
        for (Locador locador : locadores) {
            String locadorInfo = locador.getPessoas_cpf() + " - " + locador.getNome();
            comboCpfLocador.getItems().add(locadorInfo);
        }

    }


    private Vendedor encontrarVendedorSelecionado(int vendedorId) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId_vendedor() == vendedorId) {
                System.out.println("vendedor Selecionado" + vendedor);


                return vendedor;
            }
        }
        return null;

    }

    private Locador encontrarLocadorSelecionado(String locadorCpf) {
        for (Locador locador : locadores) {
            if (locador.getPessoas_cpf().equals(locadorCpf)) {

                System.out.println("locador selecionado" + locador);

                return locador;
            }
        }
        return null;

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

            ControllerListLocacoes controllerNovaTela = loader.getController();

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

            //ControllerConfiguracoes controllerNovaTela = loader.getController();

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

    @FXML
    void abrirListCategorias(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Categorias.fxml"));
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


}

package application;

import controle.AluguelRegistroDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import modelo.AluguelRegistro;
import modelo.Fornecedor;
import modelo.Locador;
import modelo.Vendedor;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerListLocacoes implements Initializable {

    @FXML
    private SplitPane SlipPaneConfigurações;

    @FXML
    private StackPane StackPanePerfil;

    @FXML
    private Button bntCadastrar;

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
    private ImageView btnPesquisa;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private TableColumn<AluguelRegistro, Date> columnDataInicio;

    @FXML
    private TableColumn<AluguelRegistro, String> columnAcoes;

    @FXML
    private TableColumn<AluguelRegistro, String> columnFormaPag;

    @FXML
    private TableColumn<AluguelRegistro, Integer> columnId;

    @FXML
    private TableColumn<AluguelRegistro, Vendedor> columnIdVendedor;

    @FXML
    private TableColumn<AluguelRegistro, Locador> columnLocador;

    @FXML
    private TableColumn<AluguelRegistro, Integer> columnQuantDias;

    @FXML
    private TableColumn<AluguelRegistro, Double> columnValor;

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
    private Label lblFornecedores;

    @FXML
    private Label lblFuncao;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Pane panelFornecedores;

    @FXML
    private TableView<AluguelRegistro> tableLocacoes;

    @FXML
    private TextField txtPesquisa;

    private ObservableList<AluguelRegistro>obsAluguelRegistro;

    AluguelRegistroDAO daoFor = new AluguelRegistroDAO();

    public void tblViewAluguelRegistroSearch(){
        tableLocacoes.getItems().clear();
        columnId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVenda()));
        columnFormaPag.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFormaPagamento()));
        columnDataInicio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataInicio()));
        columnQuantDias.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantDias()));
        columnValor.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getValor()));
        columnIdVendedor.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVendedor()));
        columnLocador.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPessoas_cpf()));

    }

    AluguelRegistroDAO dao = new AluguelRegistroDAO();

    public void filtroPesquisa(){

        AluguelRegistroDAO dao = new AluguelRegistroDAO();

        ArrayList<AluguelRegistro> aluguelRegistros = dao.listar();

        obsAluguelRegistro = FXCollections.observableArrayList(aluguelRegistros);
        FilteredList<AluguelRegistro> listaFiltrada = new FilteredList<>(obsAluguelRegistro, p -> true);

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            listaFiltrada.setPredicate(seuObjeto -> {
                // Verifique se o texto de busca está vazio; se estiver, mostre todos os itens
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Transforme o texto de busca e o texto no objeto em minúsculas para realizar
                // uma busca insensível a maiúsculas
                String termoBusca = newValue.toLowerCase();

                // Implemente a lógica de filtro com base nos campos do objeto
                // Por exemplo, se você deseja filtrar pelo campo 'nome':
                return seuObjeto.getFormaPagamento().toLowerCase().contains(termoBusca);
            });
        });
        tableLocacoes.setItems(listaFiltrada);
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
    void abrirTelaCadastroLocacao(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_locacao.fxml"));
            Parent root = loader.load();

            ControllerCadastroLocacao controllerNovaTela = loader.getController();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AluguelRegistroDAO dao = new AluguelRegistroDAO();
        tableLocacoes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        columnId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVenda()));
        columnFormaPag.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFormaPagamento()));
        columnDataInicio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataInicio()));
        columnQuantDias.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantDias()));
        columnValor.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getValor()));
        columnIdVendedor.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVendedor()));
        columnLocador.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPessoas_cpf()));

        columnAcoes.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AluguelRegistro, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<AluguelRegistro, String> param) {
                return new TableCell<AluguelRegistro, String>(){

                    private final Button viewButton = new Button();

                    private final Button editButton = new Button();

                    private final HBox buttonContainer = new HBox(viewButton, editButton);

                    {

                        buttonContainer.setSpacing(10); //setta o espaçamento entre os botões

                        // Estilização do botão de edição de funcionário, settando a imagem do lapis e a
                        // cor de fundo do botão

                        ImageView imageView = new ImageView(
                                new Image(getClass().getResourceAsStream("/imgs/editar.png")));
                        imageView.setFitHeight(16);
                        imageView.setFitWidth(16);
                        viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");

                        viewButton.setGraphic(imageView);
                        viewButton.setOnAction(event -> {
                            AluguelRegistro aluguelRegistro = getTableView().getItems().get(getIndex());
                            String formaPagamento = aluguelRegistro.getFormaPagamento().toString();

                            try {
                                FXMLLoader loader = new FXMLLoader(
                                        getClass().getResource("/visao/Edicao_locacao.fxml"));
                                Parent root = loader.load();
                                ControllerEdicaoLocacoes controllerNovaTela = loader.getController();

                                //Passando os dados da locação selecionada de uma tela para outra
                                controllerNovaTela.setAluguelRegistro(aluguelRegistro);

                                //Configurar a nova janela e mostra-la
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.setScene(scene);

                                stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>(){

                                    @Override
                                    public void handle(WindowEvent event) {
                                        tblViewAluguelRegistroSearch();
                                    }
                                });
                                stage.show();


                            } catch (IOException e1){
                                e1.printStackTrace();
                            }
                            System.out.println("edicao forma pagamento"+formaPagamento);
                            System.out.println("botao de edição clicado");

                        });

                        ImageView editImage = new ImageView(
                                new Image(getClass().getResourceAsStream("/imgs/excluir.png")));
                        editImage.setFitWidth(16);
                        editImage.setFitWidth(16);
                        editButton.setGraphic(editImage);
                        editButton.setStyle("-fx-background-color: red;");
                        editButton.setOnAction(event -> {
                            AluguelRegistro aluguelRegistro = getTableView().getItems().get().get(getIndex());

                            if (dao.excluir(aluguelRegistro)) {
                                dao.excluir(aluguelRegistro);
                                getTableView().getItems().remove(aluguelRegistro);

                                System.out.println("Locacao excluída com sucesso.");
                            } else {
                                System.out.println("Erro ao excluir a locacao.");
                            }
                            System.out.println("botao de delete clicado");
                        });
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(buttonContainer);
                        }
                    }
                };
            }
        });

        columnLocador.setCellValueFactory(cellData -> {
            AluguelRegistro aluguelRegistro = cellData.getValue();
            String nome = "";
            if (aluguelRegistro.getPessoas_cpf() != null){
                nome = aluguelRegistro.getPessoas_cpf().getNome();
            }
            return new SimpleObjectProperty(nome);
        });

        columnIdVendedor.setCellValueFactory(cellData -> {
            AluguelRegistro aluguelRegistro = cellData.getValue();
            String nomeV = "";
            if (aluguelRegistro.getIdVendedor().getNome() != null){
                nomeV=aluguelRegistro.getIdVendedor().getNome();
            }
            return new SimpleObjectProperty(nomeV);
        });

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {

            FilteredList<AluguelRegistro>listaFiltrada = new FilteredList<>(obsAluguelRegistro, p -> true);

            if (newValue != null && !newValue.isEmpty()){
                String termoBusca = newValue.toLowerCase();
                listaFiltrada.setPredicate(aluguelRegistro -> {

                    String formaPagamento = aluguelRegistro.getFormaPagamento().toLowerCase();
                    String valor = aluguelRegistro.getValor().toString();
                    return formaPagamento.contains(termoBusca) || valor.contains(termoBusca);
                });
            }
            tableLocacoes.setItems(listaFiltrada);
        }
        carregarLocacoes();

    }

    private Object carregarLocacoes() {
        AluguelRegistroDAO dao = new AluguelRegistroDAO();

        ArrayList<AluguelRegistro> aluguelRegistros = dao.listar();

        obsAluguelRegistro = FXCollections.observableArrayList(aluguelRegistros);
        tableLocacoes.setItems(obsAluguelRegistro);
    }
}
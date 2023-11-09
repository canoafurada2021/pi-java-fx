package application;

import controle.AluguelRegistroDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.AluguelRegistro;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import com.dansoftware.pdfdisplayer.PDFDisplayer;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


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
    private TableColumn<AluguelRegistro, String> columnAcoes;

    @FXML
    private TableColumn<AluguelRegistro, Integer> columnId;

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

    private ObservableList<AluguelRegistro> obsAluguelRegistro;

    AluguelRegistroDAO daoFor = new AluguelRegistroDAO();

    public void tblViewAluguelRegistroSearch() {
        tableLocacoes.getItems().clear();
        columnId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVenda()));


    }

    AluguelRegistroDAO dao = new AluguelRegistroDAO();

    public void filtroPesquisa() {

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

            //   ControllerConfiguracoes controllerNovaTela = loader.getController();

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

        AluguelRegistro aluguel = new AluguelRegistro();

        System.out.println(aluguel.getIdVendedor());

        tableLocacoes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        columnId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdVenda()));

        columnAcoes.setCellFactory(param -> new TableCell<AluguelRegistro, String>() {
            private final Button viewButton = new Button();
            private final Button editButton = new Button();
            private final HBox buttonContainer = new HBox(viewButton, editButton);

            {
                buttonContainer.setSpacing(10); // Definir o espaçamento entre os botões

                // Estilização dos botões
                ImageView viewImage = new ImageView(new Image(getClass().getResourceAsStream("/imgs/editar.png")));
                viewImage.setFitHeight(15);
                viewImage.setFitWidth(15);
                viewButton.setGraphic(viewImage);
                viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");

                viewButton.setOnAction(event -> {
                    try (PDDocument document = new PDDocument()) {
                        PDPage page = new PDPage(PDRectangle.A4);
                        document.addPage(page);

                        File fontFile = new File("src/resources/fonts/Helvetica.ttf");
                        if (fontFile != null) {
                            PDType0Font customFont = PDType0Font.load(document, fontFile);

                            if (customFont != null) {
                                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                                    File logoFile = new File("src/imgs/logo_azul.png");
                                    PDImageXObject logo = PDImageXObject.createFromFile(String.valueOf(logoFile), document);

                                    float pageWidth = page.getMediaBox().getWidth();
                                    float pageHeight = page.getMediaBox().getHeight();

                                    float logoX = (pageWidth - logo.getWidth()) / 2;
                                    float logoY = pageHeight - logo.getHeight() - 20;
                                    contentStream.drawImage(logo, logoX, logoY, logo.getWidth(), logo.getHeight());

                                    contentStream.setFont(customFont, 12);

                                    String nomeDoProjeto = "REGISTRO DE COMPRA";
                                    float nomeX = (pageWidth - customFont.getStringWidth(nomeDoProjeto) / 1000 * 12) / 2;
                                    float nomeY = logoY - 20;
                                    contentStream.beginText();
                                    contentStream.newLineAtOffset(nomeX, nomeY);
                                    contentStream.showText(nomeDoProjeto);
                                    contentStream.endText();

                                    AluguelRegistroDAO dao = new AluguelRegistroDAO();
                                    ArrayList<AluguelRegistro> alugueis = dao.listar();

                                    float tableY = nomeY - 40; // Adjust the distance between the name and the table
                                    float margin = 50; // Left margin for the table
                                    int rows = alugueis.size();
                                    int cols = 5; // Number of columns in the table

                                    float tableWidth = pageWidth - 2 * margin;
                                    float tableHeight = 20f * (rows + 1); // Add 1 for the header row
                                    float rowHeight = 20f;
                                    float tableX = margin;

                                    // Calcular a largura de cada coluna
                                    float columnWidth = tableWidth / cols;

                                    contentStream.setLineWidth(1f);
                                    contentStream.moveTo(tableX, tableY);
                                    contentStream.lineTo(tableX + tableWidth, tableY);
                                    contentStream.moveTo(tableX, tableY - rowHeight);
                                    contentStream.lineTo(tableX + tableWidth, tableY - rowHeight);
                                    contentStream.stroke();

                                    for (int i = 0; i <= cols; i++) {
                                        float x = tableX + columnWidth * i;
                                        contentStream.moveTo(x, tableY);
                                        contentStream.lineTo(x, tableY - tableHeight);
                                        contentStream.stroke();
                                    }

                                    // Set text properties for the table
                                    contentStream.setFont(customFont, 10);
                                    contentStream.setLeading(20.0f);
                                    float yPosition = tableY - 15;

                                    // Draw table header text
                                    float xPosition = tableX;
                                    for (int i = 0; i < cols; i++) {
                                        contentStream.beginText();
                                        contentStream.newLineAtOffset(xPosition, yPosition);
                                        contentStream.showText(getTableHeader(i));
                                        contentStream.endText();
                                        xPosition += tableWidth / cols;
                                    }

                                    // Draw table data
                                    yPosition = tableY - rowHeight - 15;
                                    for (AluguelRegistro aluguel : alugueis) {
                                        xPosition = tableX;
                                        for (int i = 0; i < cols; i++) {
                                            contentStream.beginText();
                                            String texto = getTableData(aluguel, i);
                                            int comprimentoMaximoLinha = 20; // Ajuste conforme necessário
                                            List<String> linhas = new ArrayList<>();
                                            for (int j = 0; j < texto.length(); j += comprimentoMaximoLinha) {
                                                int endIndex = Math.min(j + comprimentoMaximoLinha, texto.length());
                                                linhas.add(texto.substring(j, endIndex));
                                            }

                                            // Exiba as linhas na tabela
                                            for (int j = 0; j < linhas.size(); j++) {
                                                contentStream.newLineAtOffset(xPosition, yPosition - j * 15); // Ajuste conforme necessário
                                                contentStream.showText(linhas.get(j));
                                            }

                                            contentStream.endText();

                                            // Adicione uma linha divisória entre as linhas
                                            contentStream.setLineWidth(0.5f); // Ajuste conforme necessário
                                            contentStream.moveTo(xPosition, yPosition);
                                            contentStream.lineTo(xPosition + columnWidth, yPosition);
                                            contentStream.stroke();

                                            xPosition += tableWidth / cols;
                                        }
                                        yPosition -= rowHeight;

                                        // Adicione uma linha divisória entre as linhas
                                        contentStream.setLineWidth(1f); // Restaure a largura da linha para o valor original
                                        contentStream.moveTo(tableX, yPosition);
                                        contentStream.lineTo(tableX + tableWidth, yPosition);
                                        contentStream.stroke();
                                    }
                                }
                            }
                        }

                        String fileName = "seu-arquivo.pdf";

                        // Salve o PDF em um arquivo
                        document.save(fileName);

                        PDFDisplayer displayer = new PDFDisplayer();

                        Stage stage = new Stage();
                        stage.setScene(new Scene(displayer.toNode()));
                        stage.show();

                        displayer.loadPDF(new File(fileName));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                ImageView editImage = new ImageView(new Image(getClass().getResourceAsStream("/imgs/excluir.png")));
                editImage.setFitWidth(16);
                editImage.setFitHeight(16);
                editButton.setGraphic(editImage);
                editButton.setStyle("-fx-background-color: red;");

                editButton.setOnAction(event -> {
                    AluguelRegistro aluguelRegistro = getTableView().getItems().get(getIndex());

                    if (aluguelRegistro != null) {
                        if (dao.excluir(aluguelRegistro)) {
                            getTableView().getItems().remove(aluguelRegistro);
                            System.out.println("Locação excluída com sucesso.");
                        } else {
                            System.out.println("Erro ao excluir a locação.");
                        }
                    } else {
                        System.out.println("AluguelRegistro é nulo. Não é possível excluir.");
                    }

                    System.out.println("Botão de excluir clicado");
                });
            }
            // Helper method to get table header text based on the column index
            private String getTableHeader(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return "ID da Venda";
                    case 1:
                        return "Forma de Pagamento";
                    case 2:
                        return "Data de Início";
                    case 3:
                        return "Quantidade de Dias";
                    case 4:
                        return "Valor";
                    default:
                        return "";
                }
            }

            // Helper method to get table data based on the column index
            private String getTableData(AluguelRegistro aluguel, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return String.valueOf(aluguel.getIdVenda());
                    case 1:
                        return aluguel.getFormaPagamento();
                    case 2:
                        return aluguel.getDataInicio().toString();
                    case 3:
                        return String.valueOf(aluguel.getQuantDias());
                    case 4:
                        return String.valueOf(aluguel.getValor());
                    default:
                        return "";
                }
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
        });
        

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {

            FilteredList<AluguelRegistro> listaFiltrada = new FilteredList<>(obsAluguelRegistro, p -> true);

            if (newValue != null && !newValue.isEmpty()) {
                String termoBusca = newValue.toLowerCase();
                listaFiltrada.setPredicate(aluguelRegistro -> {

                    String formaPagamento = aluguelRegistro.getFormaPagamento().toLowerCase();
                    String valor = aluguelRegistro.getValor().toString();
                    return formaPagamento.contains(termoBusca) || valor.contains(termoBusca);
                });
            }
            tableLocacoes.setItems(listaFiltrada);
        });

        carregarLocacoes();
    }

    private void carregarLocacoes() {
        AluguelRegistroDAO dao = new AluguelRegistroDAO();

        ArrayList<AluguelRegistro> aluguelRegistros = dao.listar();

        obsAluguelRegistro = FXCollections.observableArrayList(aluguelRegistros);
        tableLocacoes.setItems(obsAluguelRegistro);
    }
}
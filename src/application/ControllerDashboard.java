package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerDashboard  implements Initializable{

    @FXML
    private ImageView imageCapa;
    
    @FXML
    private Text textBoasVindas;

    @FXML
    private PieChart graphicMarcas;
    
    
    @FXML
    private BarChart<String, Number> graphicVendas;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnLocacao;

    @FXML
    private Button btnFuncionarios;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnConfiguracoes;

    @FXML
    private Button btnSair;

    @FXML
    private ImageView imgSair;

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgDefaultDashboard;

    @FXML
    private ImageView imgDefaultProdutos;

    @FXML
    private ImageView imgDefaultLocacao;

    @FXML
    private ImageView imgDefaultFuncionarios;

    @FXML
    private ImageView imgDefaultUsuarios;

    @FXML
    private ImageView imgDefaultFornecedores;

    @FXML
    private ImageView imgDefaultConfiguracoes;


    @FXML
    void abrirListFornecedores(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
			Parent root = loader.load();

			ControllerListFornecedores controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    private void handleDashboardButton() {
        // Lógica para quando o botão Dashboard for clicado
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		XYChart.Series<String, Number> vendaSeries = new XYChart.Series<>();
		vendaSeries.getData().add(new XYChart.Data<>("Janeiro", 1000));       // Janeiro
		vendaSeries.getData().add(new XYChart.Data<>("Fevereiro", 1200));    // Fevereiro
		vendaSeries.getData().add(new XYChart.Data<>("Março", 1500));        // Março

		vendaSeries.setName("Vendas");

		BarChart<String, Number> barChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
		graphicVendas.getData().add(vendaSeries);


      
      
      
      
      
    // Inicializar gráfico de Marcas (PieChart)
    ObservableList<Data> marcaData = FXCollections.observableArrayList(
        new PieChart.Data("Marca A", 30),
        new PieChart.Data("Marca B", 25),
        new PieChart.Data("Marca C", 45)
    );
    
    
    // cores dos elementos do gráfico
//    marcaData.get(0).getNode().setStyle("-fx-pie-color: #FF5733;");
//    marcaData.get(1).getNode().setStyle("-fx-pie-color: #33FFA3;");
//    marcaData.get(2).getNode().setStyle("-fx-pie-color: #336BFF;");
    
    
    graphicMarcas.setData(marcaData);

      
      
	}

    // Outros métodos de manipulação de eventos podem ser definidos da mesma forma
}
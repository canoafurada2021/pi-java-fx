package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import controle.VendedorDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Vendedor;

public class ControllerTableViewFuncionarios implements Initializable {

	@FXML
	private TableView<Vendedor> tableFuncionario;

	@FXML
	private TableColumn<Vendedor, String> columnCargo;

	@FXML
	private TableColumn<Vendedor, Integer> columnIdVendedor;

	@FXML
	private TableColumn<Vendedor, String> columnNome;

	@FXML
	private TableColumn<Vendedor, Double> columnSalario;

	private ObservableList<Vendedor> obsVendedores;

	@FXML
	private void sair(ActionEvent event) {
		// Implemente a lógica para sair aqui
		System.out.println("Botão de sair pressionado");
	}

	@FXML
	private void salvarDados(ActionEvent event) {
		System.out.println("AAAAAAAAAAAAAAAA");
	}

	// Formata a cédula do salário para o padrão PT-BR (R$ 0000,000)
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnIdVendedor
				.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId_vendedor()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnCargo
				.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCargo().toString()));

		carregarVendedores();
	}

	public void carregarVendedores() {
		VendedorDAO dao = new VendedorDAO();
		ArrayList<Vendedor> vendedores = dao.listar();

		obsVendedores = FXCollections.observableArrayList(vendedores);
		tableFuncionario.setItems(obsVendedores);
	}
}

package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import modelo.Categoria;
import modelo.Vendedores;

public class ListViewController implements Initializable {

	@FXML
	private ListView<Categoria> lvCategorias;

	private List<Categoria> categorias = new ArrayList<>();

	private ObservableList<Categoria> obsCategoria;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarCategorias();
		System.out.println("teste funcionadeus ");
	}
	
	public void carregarCategorias() {
		Categoria c1 = new Categoria(1, "Comidas");
		Categoria c2 = new Categoria(2, "Bebidas");
		
		categorias.add(c1);
		categorias.add(c2);
		
		obsCategoria = FXCollections.observableArrayList(categorias);
		
		lvCategorias.setItems(obsCategoria);
	
	
	}

}

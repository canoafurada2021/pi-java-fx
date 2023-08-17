package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Categoria;

public class ListViewController implements Initializable {

    @FXML
    private TableView<Categoria> tabela;

    @FXML
    private TableColumn<Categoria, String> colunaNome;

    @FXML
    private TableColumn<Categoria, Integer> colunaId;

    private ObservableList<Categoria> obsCategoria;

    
    
    
    
    List<Categoria> categorias = new ArrayList<>(
            Arrays.asList(new Categoria(1, "coisinha"), new Categoria(2, "coisona")));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colunaId.setText("Id");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        
        colunaNome.setText("Nome da Categoria");
        colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));

        
        // método para tirar a coluna extra vazia criada como padrão no table column
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        carregarCategorias();
        System.out.println("teste funcionadeus ");
    }

    public void carregarCategorias() {
        Categoria c1 = new Categoria(1, "Comidas");
        Categoria c2 = new Categoria(2, "Bebidas");

        categorias.add(c1);
        categorias.add(c2);

        obsCategoria = FXCollections.observableArrayList(categorias);

        tabela.setItems(obsCategoria);
    }
}


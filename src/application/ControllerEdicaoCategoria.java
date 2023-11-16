package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.CategoriaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Categoria;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerEdicaoCategoria implements Initializable{

	  @FXML
	    private Button btnCancelarCategoria;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private ComboBox<Integer> comboIdCategoria;

	    @FXML
	    private Label lblIdCategoria;

	    @FXML
	    private Label lblNomeCategoria;

	    @FXML
	    private Pane pnlFormEdicao1;

	    @FXML
	    private TextField txtNomeCategoria;

	    private CategoriaDAO dao =  new CategoriaDAO();
	    private ArrayList <Categoria> categorias = dao.listar();
	    
	    @FXML
	    void alterarCategoria(ActionEvent event) {
	    		String nomeCategoriaNovo = txtNomeCategoria.getText();
	    		
	    		Categoria categoria = new Categoria();
	    		categoria.setIdCategoria(comboIdCategoria.getValue());
	    		categoria.setCategoria(nomeCategoriaNovo);
	    		
	    		if(dao.atualizar(categoria)) {
	    			ExibePopUpSucesso.ExibirPopUpSucesso();
	    			Node source = (Node) event.getSource();
	    			Stage stage = (Stage) source.getScene().getWindow();

	    			stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

	    			System.out.println("deu boa aqui  " + stage);
	    			
	    			stage.close();
	    		}else {
	    			ExibePopUpErro.ExibirPopUpErro();
	    			System.out.println("nao deu ");
	    		}
	    		
	    		
	    }

	    @FXML
	    void cancelarAlteracaoCategoria(ActionEvent event) {
	    	// Obtém o Node (geralmente um botão) que acionou o evento
			Node source = (Node) event.getSource();

			// Obtém o Stage (janela) atual com base no Node
			Stage stage = (Stage) source.getScene().getWindow();

			// Fecha o Stage atual
			stage.close();

	    }

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherComboBoxCategoriaAlter();
		comboIdCategoria.setDisable(true);
	}
	
	Categoria categoria = new Categoria();
	
	public void setCategoria(Categoria ca) {
		txtNomeCategoria.setText(ca.getCategoria());
		
		Integer idCategoria = ca.getIdCategoria();

		// Corrija a comparação usando um valor que represente "não definido" 
		//tava dando erro a comparacao com null aqui:
		if (idCategoria != -1) {
			int categoriaIndex = encontrarIndexPorCategoria(ca.getIdCategoria());
			String categoriaText = String.valueOf(ca.getIdCategoria());
			
			comboIdCategoria.getEditor().setText(categoriaText);
			
			if(categoriaIndex != -1) {
				comboIdCategoria.getEditor().setText(categoriaText);
				comboIdCategoria.getSelectionModel().select(categoriaIndex);
			}
			
		}
		
	}
	private int encontrarIndexPorCategoria(long categoriaId) {
		for (int i = 0; i < categorias.size(); i++) {
			if(categorias.get(i).getIdCategoria() == categoriaId) {
				System.out.println("indice : "+ i);
				return i;
			}
		}return -1;
	}
	
	private Categoria encontrarCategoriaPorId(int idCategoria) {
		for (Categoria categoria : categorias) {
			if(categoria.getIdCategoria() == idCategoria) {
				return categoria;
			}
		}return null;
	}
	
	private void preencherComboBoxCategoriaAlter() {
		for (Categoria categoria : categorias) {
			int infoCategoria = categoria.getIdCategoria();
			comboIdCategoria.getItems().add(infoCategoria);
		}
	}
	
	

}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Empresa;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;


public class ControllerEdicaoConfiguracao implements Initializable {




		@FXML
		private Button btnCancelar;

		@FXML
		private Button btnSalvar;

		@FXML
		private Label lblCnpj;

		@FXML
		private Label lblIdEmpresa;

		@FXML
		private Label lblNomeFantasia;

		@FXML
		private Label lblPorteEmpresa;

		@FXML
		private Label lblRazaoSocial;

		@FXML
		private Label lblTelefone;

		@FXML
		private Pane pnlEdicaoEmpresa;

		@FXML
		private TextField txtCnpj;

		@FXML
		private TextField txtIdEmpresa;

		@FXML
		private TextField txtNomeFantasia;

		@FXML
		private TextField txtPorteEmpresa;

		@FXML
		private TextField txtRazaoSocial;

		@FXML
		private TextField txtTelefone;

	@FXML
	public void cancelarAlteracaoEmpresa(ActionEvent actionEvent) {
		// Obtém o Node (geralmente um botão) que acionou o evento
		Node source = (Node) actionEvent.getSource();

		// Obtém o Stage (janela) atual com base no Node
		Stage stage = (Stage) source.getScene().getWindow();

		// Fecha o Stage atual
		stage.close();
	}

	public void setEmpresa(Empresa e){
		txtNomeFantasia.setText(e.getNome_fantasia());
		txtCnpj.setText(e.getCnpj().toString());
		txtIdEmpresa.setText(e.getIdEmpresa().toString());
		txtTelefone.setText(e.getTelefone().toString());
		txtPorteEmpresa.setText(e.getPorte_empresa());
		txtRazaoSocial.setText(e.getRazao_social());
	}



	@FXML
	public void alterarEmpresa(ActionEvent actionEvent) {
		//Capture as alterações dos campos do formulário
//			String novoNomeFantasia = txtNomeFantasia.getText();
//			String novoRazaoSocial = txtRazaoSocial.getText();
//			String novoPorteEmpresa = txtPorteEmpresa.getText();
//			long cnpj = Long.parseLong(txtCnpj.getText());
//			long novoTelefone = Long.parseLong(txtTelefone.getText());
//
//			System.out.println(cnpj);
//
//
//			PRECISA ARRUMAR - CRIAR MODELO E DAO
//			 Atualize o objeto Configuracao com as alterações
//	    	Configuracao configuracao = new Configuracao();
//	    	configuracao.setNomeFantasia(novoNomeFantasia);
//	    	configuracao.setRazaoSocial(novoRazaoSocial);
//	    	configuracao.setPorteEmpresa(novoPorteEmpresa);
//	    	configuracao.setCnpj(cnpj);
//	    	configuracao.setTelefone(novoTelefone);
//
//	    	if(daoConfiguracao.atualizar (configuracao)) {
//	    		ExibePopUpSucesso.ExibirPopUpSucesso();
//
//		    	//    telaTabelaController.atualizarTabela(daoFornecedor.listar());
//
//				   // Obtém o Node (geralmente um botão) que acionou o evento
//			    Node source = (Node) event.getSource();
//
//			    // Obtém o Stage (janela) atual com base no Node
//			    Stage stage = (Stage) source.getScene().getWindow();
//
//			    stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
//
//			    // Fecha o Stage atual
//			    stage.close();
//
//		    } else {
//				ExibePopUpErro.ExibirPopUpErro();
//
//		    	System.out.println("Deu ruim");
//		    }
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


}

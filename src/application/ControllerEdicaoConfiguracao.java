package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;


public class ControllerEdicaoConfiguracao implements Initializable {
	
	public class PleaseProvideControllerClassName {

	    @FXML
	    private SplitPane SlipPaneConfigurações;

	    @FXML
	    private StackPane StackPanePerfil;

	    @FXML
	    private Button bntSalvarAlteraoes;

	    @FXML
	    private Button btnCoategorias;

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
	    private ImageView imgConfiguracoes;

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
	    private Label lblCnpj;

	    @FXML
	    private Label lblDados;

	    @FXML
	    private Label lblFuncao;

	    @FXML
	    private Label lblId;

	    @FXML
	    private Label lblNomeFantasia;

	    @FXML
	    private Label lblNomeVendedor;

	    @FXML
	    private Label lblPorte;

	    @FXML
	    private Label lblRazaoSocial;

	    @FXML
	    private Label lblTelefone;

	    @FXML
	    private Pane panelConfiguracoes;

	    @FXML
	    private TextField txtCnpj;

	    @FXML
	    private TextField txtId;

	    @FXML
	    private TextField txtNomeFantasia;

	    @FXML
	    private TextField txtPorteEmpresa;

	    @FXML
	    private TextField txtRazaoSocial;

	    @FXML
	    private TextField txtTelefone;

	    @FXML
	    void salvarDados(ActionEvent event) {
	    	
	    	// Capture as alterações dos campos do formulário
	    	String novoNomeFantasia = txtNomeFantasia.getText();
	    	String novoRazaoSocial = txtRazaoSocial.getText();
	    	String novoPorteEmpresa = txtPorteEmpresa.getText();
	    	long cnpj = Long.parseLong(txtCnpj.getText());
	    	long novoTelefone = Long.parseLong(txtTelefone.getText());
	    	
	    	System.out.println(cnpj);
	    	
	    	// Atualize o objeto Configuracao com as alterações
	    	Configuracao configuracao = new Configuracao();
	    	configuracao.setNomeFantasia(novoNomeFantasia);
	    	configuracao.setRazaoSocial(novoRazaoSocial);
	    	configuracao.setPorteEmpresa(novoPorteEmpresa);
	    	configuracao.setCnpj(cnpj);
	    	configuracao.setTelefone(novoTelefone);
	    	
	    	if(daoConfiguracao.atualizar (configuracao)) {
	    		ExibePopUpSucesso.ExibirPopUpSucesso();

		    	//    telaTabelaController.atualizarTabela(daoFornecedor.listar());

				   // Obtém o Node (geralmente um botão) que acionou o evento
			    Node source = (Node) event.getSource();
			    
			    // Obtém o Stage (janela) atual com base no Node
			    Stage stage = (Stage) source.getScene().getWindow();
			   
			    stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
			    
			    // Fecha o Stage atual
			    stage.close();
		
		    } else {
				ExibePopUpErro.ExibirPopUpErro();

		    	System.out.println("Deu ruim");
		    }

	    }

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	    
	public void setConfiguracoes (Configuracoes c) {
		txtNomeFantasia.setText(c.getNomeFantasia());
		txtRazaoSocial.setText(c.getRazaoSocial());
		txtPorteEmpresa.setText(c.getPorteEmpresa());
		txtId.setText(valueOf(c.getId()));
		txtCnpj.setText(valueOf(c.getCNPJ()));
		txtTelefone.setText(valueOf(c.getTelefone()));
	
	}

}

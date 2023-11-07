package application;

import controle.AluguelRegistroDAO;
import controle.LocadorDAO;
import controle.VendedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.AluguelRegistro;
import modelo.Locador;
import modelo.Vendedor;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerEdicaoLocacoes implements Initializable {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button BtnSalvar;

    @FXML
    private ComboBox<String> comboIdVendedor;

    @FXML
    private ComboBox<String> comboxCpfLocador;

    @FXML
    private DatePicker dateQuantDias;

    @FXML
    private Label lblMarcaVeiculo;

    @FXML
    private Label lblMarcaVeiculo1;

    @FXML
    private Label lblNomeVeiculo;

    @FXML
    private Label getLblNomeVeiculo1;

    @FXML
    private Label lblQuantidadeVeiculos;

    @FXML
    private Label lblTipoVeiculo;

    @FXML
    private Label lblTipoVeiculo1;

    @FXML
    private Pane pnlLocacaoEdicao;

    @FXML
    private TextField txtFormPag;

    @FXML
    private TextField txtQuantDias;

    @FXML
    private TextField txtValor;

    private VendedorDAO dao = new VendedorDAO();
    private ArrayList<Vendedor> vendedores = dao.listar();

    private LocadorDAO daoL = new LocadorDAO();
    private ArrayList<Locador> locadores = (ArrayList<Locador>) daoL.listar();

    AluguelRegistroDAO daoAluguelRegistro = new AluguelRegistroDAO();

    public void alterarLocacao(ActionEvent event) {

        //capture as alteracoes dos campos do fomulário
        String novoFormaPagamento = txtFormPag.getText();
        String novoDataInicio = String.valueOf(dateQuantDias.getValue());
        Integer novoQuantDias = Integer.parseInt(txtQuantDias.getText());
        String novoValor = txtValor.getText();

        System.out.println(novoValor);

        //Atualize o objeto Locacao cm as alterações
        AluguelRegistro aluguelRegistro = new AluguelRegistro();
        aluguelRegistro.setFormaPagamento(novoFormaPagamento);
        aluguelRegistro.setDataInicio(Timestamp.valueOf(novoDataInicio));
        aluguelRegistro.setQuantDias(novoQuantDias);
        aluguelRegistro.setValor(Double.valueOf(novoValor));

        if (daoAluguelRegistro.atualizar(aluguelRegistro)){
            ExibePopUpSucesso.ExibirPopUpSucesso();

            // Obtém o Node (geralmente um botão) que acionou o evento
            Node source = (Node) event.getSource();

            // Obtém o Stage (janela) atual com base no Node
            Stage stage = (Stage) source.getScene().getWindow();

            stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

            // Fecha o Stage atual
            stage.close();
        }else {
            ExibePopUpErro.ExibirPopUpErro();

            System.out.println("Deu ruim");
        }
    }

    public void cancelarAlteracaoLocacao(ActionEvent event) {
        // Obtém o Node (geralmente um botão) que acionou o evento
        Node source = (Node) event.getSource();

        // Obtém o Stage (janela) atual com base no Node
        Stage stage = (Stage) source.getScene().getWindow();

        // Fecha o Stage atual
        stage.close();
    }

    public void comboIdVendedor(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherComboBox();
        txtFormPag.setDisable(true);

    }

    private void preencherComboBox() {
        for (Vendedor vendedor : vendedores){
            String vendedorInfo = vendedor.getId_vendedor()+ " - "+ vendedor.getNome();
            comboIdVendedor.getItems().add(vendedorInfo);
        }

        for (Locador locador : locadores){
            String locadorInfo = locador.getPessoas_cpf()+" - "+locador.getNome();
            comboxCpfLocador.getItems().add(locadorInfo);
        }
    }

    public void setAluguelRegistro(AluguelRegistro a){
        txtFormPag.setText(a.getFormaPagamento());
        txtValor.setText(String.valueOf(a.getValor()));
        txtQuantDias.setText(String.valueOf(a.getQuantDias()));
        dateQuantDias.setValue(LocalDate.parse(String.valueOf(a.getDataInicio())));

        if (a.getPessoas_cpf() != null){
            int cpfLocadorIndex = encontrarIndiceCpfLocador(a.getPessoas_cpf().getPessoas_cpf());
            String locadorText = a.getPessoas_cpf().getNome();

            comboxCpfLocador.getEditor().setText(locadorText);

            if (cpfLocadorIndex != -1){
                //defina o indice do comboBox
                comboxCpfLocador.getEditor().setText(locadorText);

                comboxCpfLocador.getSelectionModel().select(cpfLocadorIndex);
            }
        }

        if (a.getIdVendedor() != null){
            int vendedorIndex = encontrarIndiceIdVendedor(a.getIdVendedor().getId_vendedor());
            String vendedorText = a.getIdVendedor().getNome();

            comboIdVendedor.getEditor().setText(vendedorText);

            if (vendedorIndex != -1){
                //defina o indice do comboBox
                comboIdVendedor.getEditor().setText(vendedorText);

                comboIdVendedor.getSelectionModel().select(vendedorIndex);
            }
        }
    }

    private int encontrarIndiceIdVendedor(Long idVendedor) {
        for (int i=0; i<vendedores.size();i++){
            if (vendedores.get(i).getId_vendedor().equals(idVendedor)){
                System.out.println("indice"+ i);
                return i;
            }
        }
        return -1; // Retornar -1 se o ID do vendedor não for encontrado (trate isso adequadamente)
    }

    private int encontrarIndiceCpfLocador(String pessoasCpf) {
        for (int i=0; i<locadores.size();i++){
            if (locadores.get(i).getPessoas_cpf().equals(pessoasCpf)){
                System.out.println("indice"+ i);
                return i;
            }
        }
        return -1; // Retornar -1 se o CPF do locador não for encontrado (trate isso adequadamente)
    }
}

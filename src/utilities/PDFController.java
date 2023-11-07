package utilities;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFController {

    @FXML
    private Button btnOpenPDF;

    @FXML
    private void openPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos PDF", "*.pdf"));
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try {
                PDDocument document = Loader.loadPDF(file);

                PDDocumentCatalog catalog = document.getDocumentCatalog();
                PDDocumentInformation info = document.getDocumentInformation();
                PDDocumentNameDictionary names = catalog.getNames();

                // Exemplo: exibir informações do documento
                String title = info.getTitle();
                String author = info.getAuthor();
                String subject = info.getSubject();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Informações do PDF");
                alert.setHeaderText("Informações do PDF:");
                alert.setContentText("Título: " + title + "\nAutor: " + author + "\nAssunto: " + subject);
                alert.showAndWait();

                // Exemplo: extrair texto do PDF
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                String text = pdfTextStripper.getText(document);
                // Faça o que desejar com o texto extraído

                // Exemplo: renderizar PDF
                PDFRenderer renderer = new PDFRenderer(document);
                // Exiba o PDF em um visualizador de PDF

                // Feche o documento após usá-lo
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
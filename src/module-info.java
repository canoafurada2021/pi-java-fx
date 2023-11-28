module MavanJFxProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires PDFViewerFX;
    // requires org.junit.jupiter.api;
    requires javafx.web;
    requires java.sql.rowset;


    opens application to javafx.graphics, javafx.fxml;
    opens modelo to javafx.base;
    
    
}

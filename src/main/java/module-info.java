module com.example.emailclientprod {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.example.emailclientprod to javafx.fxml;
    exports com.example.emailclientprod;
}
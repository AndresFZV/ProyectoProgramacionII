package proyectofinal.unieventos.controladores;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class adminLoginController implements Initializable{

    @FXML
    private Button cancelarButton;
    @FXML
    private Label loginMensajeLabel;
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView candadoImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File logoFile = new File("imagenes/UNIEVENTOS2.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);

        File candadoFile = new File("imagenes/candado.png");
        Image candadoImage = new Image(candadoFile.toURI().toString());
        candadoImageView.setImage(candadoImage);
    }

    public void closeWindows(){

    }

    public void loginButtonOnAction(ActionEvent event) {
        try {
            if (!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
                // Validar
                String usuario = "admin";
                String password = "123";

                if (usernameTextField.getText().equals(usuario) && passwordField.getText().equals(password)) {
                    // Usuario y contraseña son válidos
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setHeaderText(null);
                    alert.setContentText("Sesión iniciada correctamente");
                    alert.showAndWait();
                } else {
                    // Usuario o contraseña son incorrectos
                    loginMensajeLabel.setText("Usuario o contraseña incorrectos");
                }
            } else {
                if (usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    throw new RuntimeException("Todos los campos son obligatorios");
                } else {
                    loginMensajeLabel.setText("Por favor ingrese su correo y/o contraseña");
                }
            }
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void cancelarButtonOnAction(ActionEvent event) {
        try {
            // Cargar la ventana del administrador
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofinal/unieventos/principal.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana del administrador
            principalController principalController = loader.getController();

            // Obtener la escena y el escenario actual
            Scene currentScene = cancelarButton.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            // Cerrar la ventana actual
            currentStage.close();

            // Mostrar la nueva ventana del administrador
            Stage adminStage = new Stage();
            adminStage.setScene(new Scene(root));
            adminStage.show();
        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de errores
        }
    }
}

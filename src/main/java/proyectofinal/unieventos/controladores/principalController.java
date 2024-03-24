package proyectofinal.unieventos.controladores;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class principalController<AdminLoginController> implements Initializable {

    @FXML
    private Button adminButton;

    @FXML
    private ImageView principalView;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File principalFile = new File("imagenes/Principal.png");
        Image principalImage = new Image(principalFile.toURI().toString());
        principalView.setImage(principalImage);
    }

    @FXML
    public void adminButtonOnAction(ActionEvent event) {
        try {
            // Cargar la ventana del administrador
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofinal/unieventos/adminLogin.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana del administrador
            AdminLoginController adminLoginController = loader.getController();

            // Obtener la escena y el escenario actual
            Scene currentScene = adminButton.getScene();
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

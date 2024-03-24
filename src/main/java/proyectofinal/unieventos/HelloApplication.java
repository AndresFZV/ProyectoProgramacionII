package proyectofinal.unieventos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 370);
        stage.setResizable(false);
        stage.setTitle("¡UNIEVENTOS!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
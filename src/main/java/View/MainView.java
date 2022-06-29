package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class MainView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("FirstView.fxml")));
        stage.setTitle("Repair Finalization");
        Scene scene = new Scene(root, 800, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}

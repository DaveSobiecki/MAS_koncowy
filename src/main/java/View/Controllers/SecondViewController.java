package View.Controllers;

import Repair.Repair;
import Util.SerializationUtil;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


public class SecondViewController {

    @FXML
    private ListView<String> detailedRaportListView;

    @FXML
    private Button backBtn;

    @FXML
    private Button generateBtn;

    @FXML
    private Button cancelBtn;

    private Repair selectedRepair;

    public void prepareRaportData(Stage stage){

        selectedRepair = (Repair) stage.getUserData();

        detailedRaportListView.setItems(FXCollections.observableArrayList(selectedRepair.getRaportView()));
    }

    public void onClickedCancel(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void onClickedGenerate(MouseEvent mouseEvent) throws IOException {
        int index = Repair.repairsList.indexOf(selectedRepair);
        selectedRepair.finalizeRaport();
        Repair.repairsList.set(index, selectedRepair);
        SerializationUtil.serializeObject(Repair.repairsList, "RepairList.obj");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Repair Generated");
        alert.setContentText("Raport has been generated properly.");
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CLOSE);
        if (button == ButtonType.OK){
            loadFirstView();
        } else {
            Platform.exit();
        }
    }

    private void loadFirstView() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("FirstView.fxml")));
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        Scene scene = new Scene(root, 800, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickedBack(MouseEvent mouseEvent) throws IOException {
        loadFirstView();
    }
}

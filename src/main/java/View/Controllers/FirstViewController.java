package View.Controllers;

import Repair.Repair;
import Util.SerializationUtil;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.util.*;


public class FirstViewController implements Initializable {
    @FXML
    private ListView<Repair> repairListView;
    @FXML
    private ListView<String> detailsListView;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button nextBtn;
    @FXML
    private Button backBtn;
    private List<Repair> repairArrayList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repairArrayList = getRepairs();
        ArrayList<String> titles = new ArrayList<>();
        repairArrayList.forEach((repair) -> titles.add(repair.toString()));
        repairListView.setItems(FXCollections.observableArrayList(repairArrayList));
    }

    public void onClickedCancel(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void onClickedNext(MouseEvent mouseEvent) throws IOException {
        if (repairListView.getSelectionModel().selectedItemProperty().get() != null) {
            Repair selectedRepair = Repair.repairsList.get(repairListView.getSelectionModel().getSelectedIndex());
            if (!selectedRepair.isPaid() && !selectedRepair.isWarranty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Repair not Paid");
                alert.setContentText("You cannot generate raport selecting this repair. This repair has not yet been paid for.");
                alert.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SecondView.fxml"));
                Parent root = loader.load();
                SecondViewController controller = loader.getController();
                Stage stage = (Stage) nextBtn.getScene().getWindow();
                stage.setUserData(selectedRepair);

                controller.prepareRaportData(stage);

                Scene scene = new Scene(root, 800, 400);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Repair not selected");
            alert.setContentText("You cannot generate raport without selecting a Repair");
            alert.show();
        }
    }

    public void onClickedBack(MouseEvent mouseEvent) {
        Platform.exit();
    }

    private List<Repair> getRepairs() {
        ArrayList<Repair> repairList = SerializationUtil.deserializeObject(Repair.class, "RepairList.obj");
        //ArrayList<Repair> repairList = new ArrayList<>();
        if (repairList.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("There are currently no available repairs");
            alert.setTitle("No Repairs");
            Optional<ButtonType> result = alert.showAndWait();
            ButtonType button = result.orElse(ButtonType.CLOSE);
            if (button == ButtonType.OK){
                System.out.println("No Repairs available.");
            }
            Platform.exit();
        }
        return repairList;
    }

    public void updateDetailsListView(MouseEvent mouseEvent) {
        detailsListView.setItems(FXCollections.observableArrayList(
                repairListView.getSelectionModel().getSelectedItem().getAllAttributes()
        ));
    }
}

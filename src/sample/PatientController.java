package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class PatientController {
    public Label labelCPR;
    public TextField textCPR;
    public Label labelFirstName;
    public TextField textFirstName;
    public Label labelLastName;
    public TextField textLastName;
    public TextArea textAreaPatientList;
    public Button buttonSearch;

    @FXML
    private GridPane grid;

    public void onSearchPatient(ActionEvent actionEvent) {
        String CPR = textCPR.getText().trim();

        // validate CPR
        if (!DataValidator.isValidCPR(CPR)) {
            // CPR er forkert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Det CPR er forkert");
            alert.show();
        } else {
            System.out.println("korrekt");
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setContentText("Det CPR er korrekt");
            info.show();
        }


    }
}

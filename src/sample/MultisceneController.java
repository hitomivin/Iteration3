package sample;

import javafx.event.ActionEvent;

public class MultisceneController {
    public void newPatient(ActionEvent actionEvent) {
        Main.setGridPane(0);
    }

    public void summary(ActionEvent actionEvent) {
        Main.setGridPane(1);
    }
}
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SummaryController {
    public Label labelPostnr;

    public TextField textPostnr;
    public Label labelTidsperiode;
    public Label labelTidsperiodeFra;
    public DatePicker datepickerTidsperiodeFra;
    public Label labelTidsperiodeTil;
    public DatePicker datepickerTidsperiodeTil;
    public TextArea textAreaSummary;
    public Button buttonMakeSummary;
    public Button buttonExportXML;

    @FXML
    private GridPane grid;

    private Statistik statistik;

    private void resetTextFields(GridPane grid) {
        // Simple method to reset the style on text fields in a grid which have a style set
        // and don't touch the other fields
        // We use it to clear the fields we turned yellow
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                System.out.println(node.getStyle());
                // clear
                if (node.getStyle() != null && !node.getStyle().equals("")) {
                    ((TextField) node).setText("");
                    node.setStyle(null);
                }
            }
        }
    }

    public void onMakeSummary(ActionEvent actionEvent) {
        String postnr =textPostnr.getText();
        String periodeFra = datepickerTidsperiodeFra.getValue().toString();
        String periodeTil = datepickerTidsperiodeTil.getValue().toString();

        Statistik st = new Statistik(postnr, datepickerTidsperiodeFra.getValue(), datepickerTidsperiodeTil.getValue());

        // tjek, om input er rigtig
        // postnr skal være 4 cifre
        // periodeFra skal være efter første tilfælde af COVID-19 i Danmark ()
        // periodeTil må ikke være tidligere end periodeFra, men der accepteres, når der er en samme dag (00:00:00-23:59:59)

        // indhent data
        st.addMutations(new Database().getStatistikMutationList(postnr, periodeFra, periodeTil));

        // vis
        resetTextFields(grid);
        textAreaSummary.setText(st.printStatistik());

    }

    public void onExportXML(ActionEvent actionEvent) {
        eksportXML.eksportStatistik("C:\\Users\\hitom\\Desktop\\XML\\test.xml", statistik);
        //statistik.exportXML("C:\\Users\\hitom\\Desktop\\XML\\test.xml");
        //Statistik.exportXML(".\\XML\\test.xml", statistik);
    }


}
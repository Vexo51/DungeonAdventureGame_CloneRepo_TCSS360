package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiMainController {

    @FXML
    private BorderPane scenePane;
    @FXML
    private VBox mainButtonContainer;

    public void exit(ActionEvent theEvent) {
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void start(ActionEvent theEvent) throws Exception {
        /*
            JavaFX to Java Swing
            Stage => JFrame
            Scene => JPanel
            Root => Components
         */

        // get the pane for character selection
        Pane characterPane = FXMLLoader.load(getClass().getResource("CharacterSelect.fxml"));

        // swap the center pane to display characterPane and remove the start and exit buttons (by id)
        scenePane.setCenter(characterPane);
        scenePane.getChildren().remove(mainButtonContainer);
    }

}

package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GuiMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
        Parent root = FXMLLoader.load(GuiMain.class.getResource("GuiMain.fxml"));

        theStage.getIcons().add(new Image(GuiMain.class.getResourceAsStream("/icon.png")));
        theStage.setTitle("Group 10 Dungeon Game");

        theStage.setResizable(false);

        Scene scene = new Scene(root);
        theStage.setScene(scene);
        theStage.show();
    }
}

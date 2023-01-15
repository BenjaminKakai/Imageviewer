import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ImageViewer extends Application {

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            ImageView imageView = new ImageView(image);

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(imageView);

            primaryStage.setTitle(selectedFile.getName());
            primaryStage.setScene(new Scene(scrollPane, 800, 600));
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

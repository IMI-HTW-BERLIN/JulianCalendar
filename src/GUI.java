import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class GUI extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Scene sceneInput = setupInputScene();

        stage.setScene(sceneInput);
        stage.show();
    }

    private Scene setupInputScene() {
        Label lblInfo = new Label("Please enter your date of birth:");

        Label lblDay = new Label("Day:");
        TextField txtDay = new TextField("");
        txtDay.setPrefWidth(35);
        VBox boxDay = new VBox(10, lblDay, txtDay);

        Label lblMonth = new Label("Month:");
        TextField txtMonth = new TextField("");
        txtMonth.setPrefWidth(35);
        VBox boxMonth = new VBox(10, lblMonth, txtMonth);

        Label lblYear = new Label("Year:");
        TextField txtYear = new TextField("");
        txtYear.setPrefWidth(65);
        VBox boxYear = new VBox(10, lblYear, txtYear);

        HBox boxInput = new HBox(20, boxDay, boxMonth, boxYear);

        Label lblError = new Label("");
        lblError.setStyle("-fx-text-fill: red");

        VBox boxLayout = new VBox(30);

        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(event -> {
            int boxLayoutSize = boxLayout.getChildren().size();
            if (boxLayoutSize > 3) {
                boxLayout.getChildren().remove(boxLayoutSize - 1);
                stage.sizeToScene();
            }

            try {
                int[] date = convertInput(txtDay.getText(), txtMonth.getText(), txtYear.getText());
                if(Arrays.stream(date).filter(x -> x > 0).toArray().length < 3 ||
                        date[0] > 31 ||
                        date[1] > 12) {
                    throw new InvalidParameterException();
                }

                else{checkBirthday(date[0], date[1], date[2]);}
            } catch (NumberFormatException e) {
                lblError.setText("Please enter a valid date!");
                boxLayout.getChildren().add(lblError);
                stage.sizeToScene();
            }
        });

        boxLayout.getChildren().addAll(lblInfo, boxInput, btnSubmit);
        boxLayout.setAlignment(Pos.CENTER);
        boxLayout.setPadding(new Insets(30));

        return new Scene(boxLayout);
    }

    private int[] convertInput(String day, String month, String year) {
        return new int[] {Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)};
    }

    private void checkBirthday(int day, int month, int year) {
        Label lblResult;
        StackPane stackPane;
        Scene sceneResult;

        if (Test.isBirthdayToday(year, month, day)) {
            lblResult = new Label("HAPPY BIRTHDAY!");

            MediaPlayer player = new MediaPlayer(new Media(new File("happy_birthday.wav").toURI().toString()));
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.play();
        } else {
            lblResult = new Label("Today is not your birthday :(");
        }

        stackPane = new StackPane(lblResult);
        stackPane.setPadding(new Insets(30));

        sceneResult = new Scene(stackPane);
        stage.setScene(sceneResult);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

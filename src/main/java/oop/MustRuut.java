package oop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MustRuut extends Application {

    KuueNumbriTäring täring = new KuueNumbriTäring();
    boolean esimese_kord = true;

    Skoor skoor = new Skoor(91);


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Button btn1 = new Button("Veereta");
        btn1.setLayoutX(300);
        btn1.setLayoutY(250);
        Button btn2 = new Button("Anna käik üle.");
        btn2.setLayoutX(500);
        btn2.setLayoutY(250);


//        Image piltFail = new Image(new FileInputStream("C:\\Users\\redjo\\proge\\Oop\\OOP_projekt\\src\\main\\java\\oop\\pildid\\täring.png"));
//        ImageView pilt = new ImageView(piltFail);
//        pilt.setFitHeight(100);
//        pilt.setPreserveRatio(true);
//
//        StackPane täringupilt = new StackPane(pilt);
        Text veeretus = new Text("0");
        veeretus.setFont(Font.font("Verdana", 100));

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 20, 10, 20));

        VBox nupud = new VBox(veeretus, btn1, btn2);


        nupud.setPadding(new Insets(15, 100, 15, 100));
        nupud.setCenterShape(true);

        Text nimetus1 = new Text("Mängija 1");
        Text nimetus2 = new Text("Mängija 2");
        nimetus1.setFont(Font.font("Verdana", 20));
        nimetus2.setFont(Font.font("Verdana", 20));
        Text mängija1 = new Text("0");
        Text mängija2 = new Text("0");
        mängija1.setFont(Font.font("Verdana", 100));
        mängija2.setFont(Font.font("Verdana", 100));

        VBox vasak = new VBox(
                nimetus1,
                mängija1

        );
        VBox parem = new VBox(nimetus2, mängija2);


        Text t = new Text(10, 20, "TÄRINGUMÄNG");
        t.setFont(Font.font("Verdana", 25));
        StackPane pealkiri = new StackPane(t);


        border.setCenter(nupud);
        border.setTop(pealkiri);
        border.setLeft(vasak);
        border.setRight(parem);


        Scene scene = new Scene(border, 600, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Täringumäng");
        primaryStage.show();


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                täring.täringuVeeretus();
                veeretus.setText(Integer.toString(täring.getVeeretus()));

            }
        });


        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

}
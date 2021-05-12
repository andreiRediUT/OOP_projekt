package oop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;

public class MustRuut extends Application {


    KuueNumbriTäring täring = new KuueNumbriTäring();

    Skoor mängu_skoor = new Skoor(91);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Button btn1 = new Button("Veereta");
        Button btn2 = new Button("Anna käik üle.");


//        Image piltFail = new Image(new FileInputStream("C:\\Users\\redjo\\proge\\Oop\\OOP_projekt\\src\\main\\java\\oop\\pildid\\täring.png"));
//        ImageView pilt = new ImageView(piltFail);
//        pilt.setFitHeight(100);
//        pilt.setPreserveRatio(true);
//
//        StackPane täringupilt = new StackPane(pilt);
        Text veeretus = new Text("0");
        Text skoor = new Text("0");
        skoor.setFont(Font.font(50));

        VBox veeretus_skoor = new VBox(veeretus, skoor );
        veeretus_skoor.setAlignment(Pos.CENTER);


        veeretus.setFont(Font.font("Verdana", 100));

        BorderPane border = new BorderPane();

        HBox nupud = new HBox( btn1, btn2);
        nupud.setAlignment(Pos.CENTER);


        nupud.setSpacing(10);
        VBox kesk = new VBox(veeretus_skoor, nupud);


        kesk.setPadding(new Insets(15, 100, 15, 100));
        nupud.setCenterShape(true);

        border.setPadding(new Insets(15, 10, 12, 12));
        border.setCenter(kesk);
        border.setTop(title());
        border.setLeft(mängija("Mängija 1", 0, true));
        border.setRight(mängija("Mängija 2", 0 , false));


        Scene scene = new Scene(border, 750 , 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Täringumäng");
        primaryStage.show();


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                veeretus.setFill(Color.BLACK);


                täring.täringuVeeretus();

                veeretus.setText(Integer.toString(täring.getVeeretus()));

                mängu_skoor.setVooruskoor(täring.getVeeretus());
                skoor.setText(Integer.toString(mängu_skoor.getVooruskoor()));

                if (täring.getVeeretus() == 1){
                    mängu_skoor.poole_vahetus(true);
                    veeretus.setFill(Color.RED);
                }


                border.setLeft(mängija("Mängija 1 ", mängu_skoor.getSkoor()[0], mängu_skoor.isEsimese_kord()));
                border.setRight(mängija("Mängija 2 ", mängu_skoor.getSkoor()[1], !mängu_skoor.isEsimese_kord()));

                System.out.println(mängu_skoor.keegiVõitnud());
                if (mängu_skoor.kasOnVõitnud()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");
                    System.out.println(mängu_skoor.isEsimese_kord());
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        System.out.println("JAH");
                    } else {
                        System.out.println("EI");
                        Platform.exit();
                    }

                }

            }
        });


        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                mängu_skoor.liidaSkoor();
                mängu_skoor.poole_vahetus(false);
                border.setLeft(mängija("Mängija 1 ", mängu_skoor.getSkoor()[0], mängu_skoor.isEsimese_kord()));
                border.setRight(mängija("Mängija 2 ", mängu_skoor.getSkoor()[1], !mängu_skoor.isEsimese_kord()));
                System.out.println(Arrays.toString(mängu_skoor.getSkoor()));


                skoor.setText("0");
                veeretus.setText("");



            }
        });
    }

    private VBox mängija (String nimi, int skoor, boolean tema_kord) {
        Text nimetus = new Text(nimi);
        nimetus.setFont(Font.font("Verdana", 20));
        Text m_skoor = new Text(Integer.toString(skoor));

        m_skoor.setFont(Font.font("Verdana", 100));

        if (tema_kord)
            return new VBox(  nimetus,  m_skoor,  kelle_kord() );

        return new VBox(nimetus, m_skoor);
    }

    private Text kelle_kord() {
        Text nimetus = new Text("KORD");
        nimetus.setFont(Font.font("Verdana", FontWeight.BOLD,  35));
        nimetus.resize(200, 200);
        nimetus.setFill(Color.RED);
        nimetus.setStyle("-colour: #FF0000;");
        return nimetus;
    }

    private StackPane title () {
        Text t = new Text(10, 20, "TÄRINGUMÄNG");
        t.setFont(Font.font("Verdana", 25));
        StackPane pealkiri = new StackPane(t);

        pealkiri.setStyle("-fx-background-colour: #FF0000;");

        return pealkiri;
    }


}
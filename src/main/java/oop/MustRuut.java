package oop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
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

        BorderPane border = new BorderPane();

        HBox nupud = new HBox(btn1, btn2);
        nupud.setAlignment(Pos.CENTER);
        nupud.setSpacing(10);


        VBox kesk = täring_vooruskoor(nupud, true);


        kesk.setPadding(new Insets(15, 100, 15, 100));
        nupud.setCenterShape(true);
        border.setPadding(new Insets(15, 10, 12, 12));

        border.setCenter(kesk);
        border.setTop(title());
        border.setLeft(mängija("Mängija 1", 0, true));
        border.setRight(mängija("Mängija 2", 0, false));


        Scene scene = new Scene(border, 750, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Täringumäng");

        primaryStage.show();
        reeglid();


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                täring.täringuVeeretus();

                //veeretus_skoor = new VBox(joonistaTulemus())

                mängu_skoor.setVooruskoor(täring.getVeeretus());


                if (täring.getVeeretus() == 1) {
                    mängu_skoor.poole_vahetus(true);
                   // veeretus.setFill(Color.RED);  TODO teha punaseks täring kui 1
                }

                border.setCenter(täring_vooruskoor(nupud, false));
                border.setLeft(mängija("Mängija 1 ", mängu_skoor.getSkoor()[0], mängu_skoor.isEsimese_kord()));
                border.setRight(mängija("Mängija 2 ", mängu_skoor.getSkoor()[1], !mängu_skoor.isEsimese_kord()));

                if (võiduTeade()) {
                    mängu_skoor.setVooruskoor(0);
                    mängu_skoor.setSkoor(new int[]{0, 0});

                    border.setCenter(täring_vooruskoor(nupud, true));


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


              //  veeretus.setText("");  TODO
            }
        });
    }



    private VBox mängija(String nimi, int skoor, boolean tema_kord) {
        Text nimetus = new Text(nimi);
        nimetus.setFont(Font.font("Verdana", 20));
        Text m_skoor = new Text(Integer.toString(skoor));

        m_skoor.setFont(Font.font("Verdana", 100));

        if (tema_kord)
            return new VBox(nimetus, m_skoor, kelle_kord());

        return new VBox(nimetus, m_skoor);
    }

    private boolean võiduTeade() {
        if (mängu_skoor.kasOnVõitnud()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Võit");
            int võitja = mängu_skoor.isEsimese_kord() ? 1 : 2;
            alert.setHeaderText("" +
                    "Palju õnne!  Võitis Mängija  "
                    + võitja
                    + "\nSkooriga " + (mängu_skoor.getSkoor()[võitja - 1] + mängu_skoor.getVooruskoor())
            );
            alert.setContentText("Kas tahate uuesti mängida?");

//            Image pilt = new Image(getClass()
//                    .getResource("C:\\Users\\redjo\\proge\\Oop\\OOP_projekt\\src\\main\\java\\oop\\pildid\\tärig.png")
//                    .toExternalForm());
//            ImageView imageView = new ImageView(pilt);
//            alert.setGraphic(imageView);
//            File tempFile = new File("C:\\Users\\redjo\\proge\\Oop\\OOP_projekt\\src\\main\\java\\oop\\pildid\\täring.png");

            // TODO lisada ikoon võiduteatele
            // alert.setGraphic(new ImageView(this.getClass().getResource("C:\\Users\\redjo\\proge\\Oop\\OOP_projekt\\src\\main\\java\\oop\\pildid\\täring.png").toString()));


            ButtonType uuesti = new ButtonType("Jah");
            ButtonType exit = new ButtonType("Ei");
            alert.getButtonTypes().setAll(uuesti, exit);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == uuesti) {
                System.out.println("JAH");

                return true;

            } else {
                System.out.println("EI");
                Platform.exit();
            }
        }
        return false;
    }

    private VBox täring_vooruskoor(HBox nupud, boolean algus) {
        Text skoor = new Text("");
        skoor.setFont(Font.font(50));
        if (algus)
            skoor.setText("0");

        skoor.setText(Integer.toString(mängu_skoor.getVooruskoor()));
        VBox veeretus_skoor = new VBox(joonistaTulemus(algus), skoor);

        veeretus_skoor.setAlignment(Pos.CENTER);


        return new VBox(veeretus_skoor, nupud);
    }

    private Text kelle_kord() {
        Text nimetus = new Text("KORD");
        nimetus.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        nimetus.resize(200, 200);
        nimetus.setFill(Color.RED);
        nimetus.setStyle("-colour: #FF0000;");
        return nimetus;
    }

    private StackPane title() {
        Text t = new Text(10, 20, "TÄRINGUMÄNG");
        t.setFont(Font.font("Verdana", 25));

        //pealkiri.setStyle("-fx-background-colour: #FF0000;");

        return new StackPane(t);
    }

    private void reeglid() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reeglid");
        alert.setHeaderText("Täringumäng");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.setContentText("" +
                "Mängijate viskevoorud kordamööda.\n" +
                "Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda," +
                " aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale. \n" +
                "Muidu viskel saadud tulemus liidetakse kogusummale. \n\n" +
                "Võidab see, kes saab enne üle 91 punkti."

        );

        alert.showAndWait();

    }

    private Canvas joonistaTulemus(boolean tühi) {


        Canvas canvas = new Canvas(115, 115);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(10);
        gc.strokeRoundRect(5, 5, 105, 105, 15, 15);

        if (tühi) return canvas;
        if (täring.getVeeretus() == 1) {
            gc.fillOval(50, 50, 10, 10);// keskmine

        } else if (täring.getVeeretus() == 2) {
            gc.fillOval(25, 25, 10, 10);// vasak tulp ülemine
            gc.fillOval(75, 75, 10, 10);// parem tulp alumine
        } else if (täring.getVeeretus() == 3) {
            gc.fillOval(25, 25, 10, 10);// vasak tulp ülemine
            gc.fillOval(75, 75, 10, 10);// parem tulp alumine
            gc.fillOval(50, 50, 10, 10);// keskmine
        } else if (täring.getVeeretus() == 4) {
            gc.fillOval(25, 25, 10, 10);// vasak tulp ülemine
            gc.fillOval(25, 75, 10, 10);//vasak tulp alumine
            gc.fillOval(75, 25, 10, 10);// parem tulp ülemine
            gc.fillOval(75, 75, 10, 10);// parem tulp alumine
        } else if (täring.getVeeretus() == 5) {
            gc.fillOval(25, 25, 10, 10);// vasak tulp ülemine
            gc.fillOval(25, 75, 10, 10);//vasak tulp alumine
            gc.fillOval(75, 25, 10, 10);// parem tulp ülemine
            gc.fillOval(75, 75, 10, 10);// parem tulp alumine
            gc.fillOval(50, 50, 10, 10);// keskmine
        } else if (täring.getVeeretus() == 6) {
            gc.fillOval(25, 25, 10, 10);// vasak tulp ülemine
            gc.fillOval(25, 50, 10, 10);//vasak tulp keskmine
            gc.fillOval(25, 75, 10, 10);//vasak tulp alumine
            gc.fillOval(75, 25, 10, 10);// parem tulp ülemine
            gc.fillOval(75, 50, 10, 10);// parem tulp keskmine
            gc.fillOval(75, 75, 10, 10);// parem tulp alumine


        }
        return canvas;
    }

}
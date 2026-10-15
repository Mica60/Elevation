import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import musique.GestionnaireMusique;

public class Jeu extends Application {

    private final Label ecran = new Label();
    private final BorderPane root = new BorderPane();

    @Override
    public void start(Stage stage) {
        ecran.setFont(Font.font("Consolas", 12));
        ecran.setTextFill(Color.WHITE);
        root.setCenter(ecran);
        root.setStyle("-fx-background-color: black;");
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
        lancerChargement();
    }

    private void afficher(String fichier) {
        try {
            ecran.setText(Files.readString(Path.of(fichier)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jouer(List<String> fichiers, int repetitions, Runnable fin) {
        Timeline t = new Timeline();
        int n = fichiers.size();
        for (int i = 0; i < n * repetitions; i++) {
            String f = fichiers.get(i % n);
            t.getKeyFrames().add(new KeyFrame(Duration.seconds(i), e -> afficher(f)));
        }
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(n * repetitions), e -> fin.run()));
        t.play();
    }

    private void lancerChargement() {
        GestionnaireMusique credit = new GestionnaireMusique("audio/bobine.wav", false);
        jouer(List.of("ecran/menu/credit1.txt", "ecran/menu/credit2.txt", "ecran/menu/credit3.txt"), 5, () -> {
            credit.arreter();
            GestionnaireMusique musique = new GestionnaireMusique("audio/musiqueChargement.wav", true);
            jouer(List.of("ecran/menu/chargement1.txt", "ecran/menu/chargement2.txt",
                    "ecran/menu/chargement3.txt", "ecran/menu/chargement4.txt",
                    "ecran/menu/chargement5.txt"), 3, () -> {
                musique.arreter();
                lancerMenu();
            });
        });
    }

    private void lancerMenu() {
        List<String> menus = List.of("ecran/menu/menu1ang.txt", "ecran/menu/menu2ang.txt",
                "ecran/menu/menu3ang.txt", "ecran/menu/menu4ang.txt", "ecran/menu/menu5ang.txt");
        Timeline anim = new Timeline();
        for (int i = 0; i < menus.size(); i++) {
            String f = menus.get(i);
            anim.getKeyFrames().add(new KeyFrame(Duration.millis(250 * i), e -> afficher(f)));
        }
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(250 * menus.size())));
        anim.setCycleCount(Animation.INDEFINITE);
        anim.play();

        HBox boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 5; i++) {
            int choix = i;
            Button b = new Button(String.valueOf(i));
            b.setOnAction(e -> { anim.stop(); choisir(choix); });
            boutons.getChildren().add(b);
        }
        root.setBottom(boutons);
    }

    private void choisir(int choix) {
        System.out.println("Choix : " + choix); 
    }
}
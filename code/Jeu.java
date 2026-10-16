import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Cursor;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import musique.GestionnaireMusique;

public class Jeu extends Application {

    private final Label ecran = new Label();
    private final BorderPane root = new BorderPane();

    public void start(Stage stage) {
        ecran.setFont(Font.font("Consolas", 12));
        ecran.setTextFill(Color.WHITE);
        root.setCenter(ecran);
        root.setStyle("-fx-background-color: black;");
        stage.setScene(new Scene(root, 1000, 700));
        stage.setFullScreen(true);
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
        jouerCredits(15, () -> {
            credit.arreter();
            GestionnaireMusique musique = new GestionnaireMusique("audio/musiqueChargement.wav", true);
            jouerChargement(10, () -> {
                afficherConnexion(() -> {
                    musique.arreter();
                    lancerMenu();
                });
            });
        });
    }

    private void jouerCredits(int secondes, Runnable fin) {
        Image[] frames = new Image[5];
        for (int i = 0; i < 5; i++) {
            frames[i] = new Image("file:affichage/credits/CreditScene" + (i + 1) + ".png");
        }

        ImageView vue = new ImageView(frames[0]);
        vue.setPreserveRatio(true);
        vue.fitWidthProperty().bind(root.widthProperty());
        vue.fitHeightProperty().bind(root.heightProperty());
        root.setCenter(vue);

        Timeline t = new Timeline();
        for (int i = 0; i < 5; i++) {
            Image f = frames[i];
            t.getKeyFrames().add(new KeyFrame(Duration.millis(140 * i), e -> vue.setImage(f)));
        }
        t.getKeyFrames().add(new KeyFrame(Duration.millis(140 * 5)));
        t.setCycleCount(secondes * 1000 / (140 * 5));
        t.setOnFinished(e -> {
            root.setCenter(ecran);
            fin.run();
        });
        t.play();
    }

    private void jouerChargement(int secondes, Runnable fin) {
        Image[] frames = new Image[11];
        for (int i = 0; i < 11; i++) {
            frames[i] = new Image("file:affichage/chargement/ChargementScene" + (i + 1) + ".png");
        }

        ImageView vue = new ImageView(frames[0]);
        vue.setPreserveRatio(true);
        vue.fitWidthProperty().bind(root.widthProperty());
        vue.fitHeightProperty().bind(root.heightProperty());
        root.setCenter(vue);

        double duree = secondes * 750.0 / 11; 

        Timeline t = new Timeline();
        for (int i = 0; i < 11; i++) {
            Image f = frames[i];
            t.getKeyFrames().add(new KeyFrame(Duration.millis(duree * i), e -> vue.setImage(f)));
        }
        t.getKeyFrames().add(new KeyFrame(Duration.millis(duree * 11)));
        t.setCycleCount(1);
        t.setOnFinished(e -> {
            root.setCenter(ecran);
            fin.run();
        });
        t.play();
    }

    private void lancerMenu() {
        List<String> menus = List.of("ecran/menu/menu1ang.txt", "ecran/menu/menu2ang.txt","ecran/menu/menu3ang.txt", "ecran/menu/menu4ang.txt", "ecran/menu/menu5ang.txt");
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
        ImageView carte = new ImageView(new Image("file:carte/Gayane, citoyenne de Daggenharr.png"));
        carte.setFitHeight(650);
        carte.setPreserveRatio(true);
        root.setCenter(carte);
        root.setBottom(null);
    }

    private void afficherConnexion(Runnable apresConnexion) {
        Pane scene = new Pane();
        scene.setPrefSize(1920, 1080);
        scene.getChildren().add(new ImageView(new Image("file:affichage/chargement/ConnexionScene.png")));
        String styleChamp = "-fx-background-color: transparent; -fx-text-fill: #fae8be;" + "-fx-font-size: 24px; -fx-padding: 0 18 0 18; -fx-highlight-fill: #e0a050;";
        String styleFocus = styleChamp + "-fx-border-color: #ffd58a; -fx-border-width: 2;" + "-fx-border-radius: 8; -fx-effect: dropshadow(gaussian, #ffb347, 14, 0.4, 0, 0);";
        TextField user = new TextField();
        placer(user, 720, 476, 480, 52);
        PasswordField mdp = new PasswordField();
        placer(mdp, 720, 564, 480, 52);
        for (TextField c : new TextField[]{user, mdp}) {
            c.setStyle(styleChamp);
            c.focusedProperty().addListener((o, ancien, focus) -> c.setStyle(focus ? styleFocus : styleChamp));
        }
        Button btn = new Button();
        placer(btn, 720, 644, 480, 54);
        String normal = "-fx-background-color: transparent; -fx-background-radius: 8;";
        String survol = "-fx-background-color: rgba(255,255,255,0.28); -fx-background-radius: 8;"+ "-fx-effect: dropshadow(gaussian, #ffd58a, 22, 0.5, 0, 0);";
        btn.setStyle(normal);
        btn.setCursor(Cursor.HAND);
        btn.setOnMouseEntered(e -> btn.setStyle(survol));
        btn.setOnMouseExited(e -> btn.setStyle(normal));
        Runnable connexion = () -> {
            String nom = user.getText();
            String mot = mdp.getText();
            if (identifiantsValides(nom, mot)) {
                apresConnexion.run();
            } else {
                mdp.clear();
            }
        };
  

        btn.setOnAction(e -> connexion.run());
        mdp.setOnAction(e -> connexion.run());
        scene.getChildren().addAll(user, mdp, btn);
        Group g = new Group(scene);
        g.scaleXProperty().bind(Bindings.min(root.widthProperty().divide(1920.0),root.heightProperty().divide(1080.0)));
        g.scaleYProperty().bind(g.scaleXProperty());
        Group g = new Group(scene);
        g.scaleXProperty().bind(Bindings.min(root.widthProperty().divide(1920.0),root.heightProperty().divide(1080.0)));
        g.scaleYProperty().bind(g.scaleXProperty());
        StackPane conteneur = new StackPane(g);
        conteneur.setMinSize(0, 0);         
        root.setCenter(conteneur);
        root.setCenter(new StackPane(g));
    }

    private void placer(Region r, double x, double y, double w, double h) {
        r.setLayoutX(x);
        r.setLayoutY(y);
        r.setPrefSize(w, h);
    }

    private boolean identifiantsValides(String nom, String mot) {
        return !nom.isBlank() && !mot.isBlank();
    }
}
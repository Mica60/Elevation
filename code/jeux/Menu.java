package jeux;

import interaction.*;
import java.io.IOException;

public class Menu {

    public static void lancementMenu() {
        TrieDecision lancement = new TrieDecision(new int[]{1,2,3,4,5});
        lancement.listerDecision();
        try {
            int choix = lancement.boucleDecision();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

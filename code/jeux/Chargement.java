package jeux;

import affichage.*;
import musique.GestionnaireMusique;

public class Chargement {
    
    public static void lancementJeux() {
        GestionnaireMusique musique = new GestionnaireMusique("audio/bobine.wav",false);
        new RequeteTexte("img/menu/credit.txt",ChoixEcriture.AUCUN,true);
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boucleAffichageMenu();
        boucleAffichageMenu();
        boucleAffichageMenu();
        musique.arreter();
    }

    private static void boucleAffichageMenu() {
        new RequeteTexte("img/menu/chargement1.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement2.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement3.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement4.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement5.txt",ChoixEcriture.AUCUN,true);
    }

}
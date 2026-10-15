package jeux;

import affichage.*;
import musique.GestionnaireMusique;

public class Chargement {
    
    public static void lancementJeux() {
        String[] listeChargement = new String[]{"ecran/menu/chargement1.txt","ecran/menu/chargement2.txt","ecran/menu/chargement3.txt","ecran/menu/chargement4.txt","ecran/menu/chargement5.txt"};
        String[] listeCredit = new String[]{"ecran/menu/credit1.txt","ecran/menu/credit2.txt","ecran/menu/credit3.txt"};
        GestionnaireMusique musiqueCredit = new GestionnaireMusique("audio/bobine.wav",false);
        boucleAffichageChargement(5, listeCredit);
        musiqueCredit.arreter();
        GestionnaireMusique musiqueChargement = new GestionnaireMusique("audio/musiqueChargement.wav",true);
        boucleAffichageChargement(3,listeChargement);
        musiqueChargement.arreter();

    }

    private static void boucleAffichageChargement(int boucle,String[] liste) {
        for(int idx = 0; idx < boucle; idx++) {
            for(int jdx = 0; jdx < liste.length; jdx++)   {
                new RequeteTexte(liste[jdx],ChoixEcriture.AUCUN,true);
            }
        } 
    }

}
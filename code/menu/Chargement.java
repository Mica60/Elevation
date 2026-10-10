package menu;

import affichage.*;

public class Chargement{
    
    public static void LancementJeux() {
        GestionnaireMusique musique = new GestionnaireMusique("audio/bobine.wav");
        new RequeteTexte("img/menu/credit.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement1.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement2.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement3.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement4.txt",ChoixEcriture.AUCUN,true);
        new RequeteTexte("img/menu/chargement5.txt",ChoixEcriture.AUCUN,true);
        musique.arreter();
    }

}
package menu;

import affichage.*;

public class Chargement{
    
    public static void LancementJeux() {
        GestionnaireMusique musique = new GestionnaireMusique("audio/bobine.wav");
        new RequeteTexte("img/menu/credit.txt",write.ANIM);
        new RequeteTexte("img/menu/loading1.txt",write.ANIM);
        new RequeteTexte("img/menu/loading2.txt",write.ANIM);
        new RequeteTexte("img/menu/loading3.txt",write.ANIM);
        new RequeteTexte("img/menu/loading4.txt",write.ANIM);
        new RequeteTexte("img/menu/loading5.txt",write.ANIM);
        musique.arreter();
    }

}
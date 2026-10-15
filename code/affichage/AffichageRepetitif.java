package affichage;

import musique.GestionnaireMusique;

public class AffichageRepetitif {
    private String[] animation;
    private String route;
    private int compteur = 0;
    private int max;
    private boolean affichageProposition = false;

    public AffichageRepetitif(String[] animation,String route) {
        this.animation = animation;
        this.route = route;
        this.max = animation.length;
    }

    public void setAffichageProposition(boolean affichageProposition) {
        this.affichageProposition = affichageProposition;
    }

    public void afficherSuite() {
       new RequeteTexte(animation[compteur],ChoixEcriture.AUCUN,true);
       if(affichageProposition) {
          new GestionnaireMusique(this.route, false);
          new RequeteTexte("ecran/outil/croix.txt",ChoixEcriture.AUCUN,true);
       }
       this.compteur += 1;
       if(this.compteur >= this.max) {
           this.compteur = 0;
       } 
    }
}

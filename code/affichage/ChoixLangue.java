package affichage;

public enum ChoixLangue{

    FRANCAIS("français"),ENGLISH("English");

    private final String affichage;

    ChoixLangue(String affichage) {
        this.affichage = affichage;
    }

    public String getAffichage() {
        return this.affichage;
    }

    public String langueActuel() {
        if(this.affichage.equals("français")) {
            return "La langue actuelle est le français.";
        } else {
            return "The current language is English.";
        }
    }

}

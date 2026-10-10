package affichage;

public class UtilisationLangue {
    private ChoixLangue langue;

    public UtilisationLangue(ChoixLangue langue) {
        this.langue = langue;
    }

    public ChoixLangue getLangue() {
        return this.langue;
    }

    public void setLanguage() {
        this.langue = langue;
    }

    public String toString() {
        if(this.langue.equals(langue.ENGLISH)) {
            return "English";
        } else {
            return "Francais";
        }
    }

}

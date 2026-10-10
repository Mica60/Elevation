package affichage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RequeteTexte {

    private String fichier;
    private ChoixEcriture durée;
    private String convertion;
    private boolean pause; 

    public RequeteTexte(String fichier, ChoixEcriture durée, boolean pause) {
        this.fichier = fichier;
        this.durée = durée;
        this.pause = pause; 
        lancementTexte();
    }

    public void lancementTexte() {
        try {
            convertion = Files.readString(Path.of(this.fichier));
        } catch(IOException e) {
            e.printStackTrace();
        } 
        MachineEcrire ecriture = new MachineEcrire(this.durée);
        if(this.durée.equals(ChoixEcriture.AUCUN)) {
            ecriture.ecrireInstantanement(convertion);
        } else {
            ecriture.ecrire(convertion);
       }
       if(this.pause) {
        ecriture.utiliserUnePause();
       }
    }
}

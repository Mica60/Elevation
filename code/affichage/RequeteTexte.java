package affichage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RequeteTexte {

    private String fichier;
    write durée;
    boolean instantané;
    private String convertion;

    public RequeteTexte(String fichier, write durée, boolean instantané) {
        this.fichier = fichier;
        this.durée = durée;
        this.instantané =instantané;
        lancementTexte();
    }

    public RequeteTexte(String file, write during) {
        this.fichier = fichier;
        this.durée = durée;
        this.instantané = true;
        lancementTexte();
    }

    public void lancementTexte() {
        try {
            convertion = Files.readString(Path.of(this.fichier));
        } catch(IOException e) {
            e.printStackTrace();
        } 
        useWrite write = new useWrite(this.durée);
        if(this.instantané) {
            write.writtinginst(convertion);
        } else {
            write.writting(convertion);
       }
    }
}

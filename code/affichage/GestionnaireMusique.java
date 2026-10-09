package affichage;

import java.io.File;
import javax.sound.sampled.*;

public class GestionnaireMusique {

    private Clip clip;
    private String route;
    private boolean boucle;

    public GestionnaireMusique(String route, boolean boucle) {
        this.route = route;
        this.boucle = boucle;
        démarrer();
    }

    public GestionnaireMusique(String chemin) {
        this.route = chemin;
        this.boucle = false;
        démarrer();
    }

    public void démarrer() {
        try{
            AudioInputStream audio=AudioSystem.getAudioInputStream(new File(route));
            clip=AudioSystem.getClip();
            clip.open(audio);
            if(boucle) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void arreter() {
        if(clip!=null){
            clip.stop();
        }
    }
      
}

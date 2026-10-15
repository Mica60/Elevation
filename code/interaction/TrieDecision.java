package interaction;

import affichage.AffichageRepetitif;
import java.io.*;

public class TrieDecision {
    private int decision;
    private int[] listeDecision;

    public TrieDecision(int[] listeDecision) {
        this.listeDecision = listeDecision;
    }

    public int boucleDecision() throws IOException, InterruptedException {
        boolean valide = false;
        boolean changement = false;
        AffichageRepetitif AR = new AffichageRepetitif(new String[]{"ecran/menu/menu1ang.txt","ecran/menu/menu2ang.txt","ecran/menu/menu3ang.txt","ecran/menu/menu4ang.txt","ecran/menu/menu5ang.txt"},"audio/erreur.wav");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!valide) {
            long debut = System.currentTimeMillis();
            while (!br.ready() && System.currentTimeMillis() - debut < 5000) {
                AR.afficherSuite();
                AR.setAffichageProposition(false);
                Thread.sleep(250);
            }
            if (br.ready()) {
                this.decision = Integer.parseInt(br.readLine().trim());
                changement = true;
            }
            for(int idx = 0; idx < this.listeDecision.length; idx++) {
                if(this.decision == this.listeDecision[idx]) {       
                    valide = true;
                }
                if(changement && !valide) {
                    AR.setAffichageProposition(true);
                    changement = false;
                }
            }
        }
        return this.decision;
    }
}

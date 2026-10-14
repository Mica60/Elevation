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
        AffichageRepetitif AR = new AffichageRepetitif(new String[]{"img/menu/menu1ang.txt","img/menu/menu2ang.txt","img/menu/menu3ang.txt","img/menu/menu4ang.txt","img/menu/menu5ang.txt"},"audio/erreur");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!valide) {
            long debut = System.currentTimeMillis();
            while (!br.ready() && System.currentTimeMillis() - debut < 5000) {
                AR.afficherSuite();
                Thread.sleep(100);
            }
            if (br.ready()) {
                this.decision = Integer.parseInt(br.readLine().trim());
                changement = true;
            }
            for(int idx = 0; idx < this.listeDecision.length; idx++) {
                if(this.decision == this.listeDecision[idx]) {
                    AR.setAffichageProposition(false);
                    valide = true;
                    changement = false;
                }
                if(changement && !valide) {
                    AR.setAffichageProposition(true);
                    changement = false;
                }
            }
        }
        return this.decision;
    }
    
    public String listerDecision() {
        String texteRetour = "";
        for(int idx = 0; idx < this.listeDecision.length; idx++ ) {
            texteRetour += " " + this.listeDecision[idx];
        }
        texteRetour += ".";
        return texteRetour;
    }
}

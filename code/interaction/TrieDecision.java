package interaction;

import java.io.*;

public class TrieDecision {
    private int decision;

    public int boucleDecision(int[] listeDecision) throws IOException, InterruptedException {
        boolean valide = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!valide) {
            long debut = System.currentTimeMillis();
            while (!br.ready() && System.currentTimeMillis() - debut < 5000) {
                Thread.sleep(100);
            }
            if (br.ready()) {
                this.decision = Integer.parseInt(br.readLine().trim());
            }
            for(int idx = 0; idx < listeDecision.length; idx++) {
                if(this.decision == listeDecision[idx]) {
                    valide = true;
                }
            }
            if(!valide) {
                System.out.println("Décision invalide, vous ne pouvez que rentrer une de ses valeurs :");
                listerDecision(listeDecision);
            }
        }
        return this.decision;
    }
    
    public void listerDecision(int[] listeDecision) {
        String texteRetour = "";
        for(int idx = 0; idx < listeDecision.length; idx++ ) {
            texteRetour += " " + listeDecision[idx];
        }
        texteRetour += ".";
        System.out.println(texteRetour);
    }
}

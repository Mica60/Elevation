package interaction;

import java.io.*;

public class TrieDecision {
    private int decision;
    private int[] listeDecision;

    public TrieDecision(int[] listeDecision) {
        this.listeDecision = listeDecision;
    }

    public int boucleDecision() throws IOException, InterruptedException {
        boolean valide = false;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!valide) {
            long debut = System.currentTimeMillis();
            while (!br.ready() && System.currentTimeMillis() - debut < 5000) {
                Thread.sleep(100);
            }
            if (br.ready()) {
                this.decision = Integer.parseInt(br.readLine().trim());
            }
            for(int idx = 0; idx < this.listeDecision.length; idx++) {
                if(this.decision == this.listeDecision[idx]) {
                    valide = true;
                }
            }
            if(!valide) {
                System.out.println("Décision invalide, vous ne pouvez que rentrer une de ses valeurs :");
                listerDecision();
            }
        }
        return this.decision;
    }
    
    public void listerDecision() {
        String texteRetour = "";
        for(int idx = 0; idx < this.listeDecision.length; idx++ ) {
            texteRetour += " " + this.listeDecision[idx];
        }
        texteRetour += ".";
        System.out.println(texteRetour);
    }
}

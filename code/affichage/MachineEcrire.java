package affichage;

public class MachineEcrire {

    private ChoixEcriture graduation;
    private long temps;

    public MachineEcrire(ChoixEcriture graduation) {
        this.graduation = graduation;
        if(this.graduation.equals(ChoixEcriture.LENT)) {
            this.temps = 300;
        }
        if(this.graduation.equals(ChoixEcriture.MOYEN)) {
            this.temps = 200;
        }
        if(this.graduation.equals(ChoixEcriture.RAPIDE)) {
            this.temps = 100;
        }
        if(this.graduation.equals(ChoixEcriture.AUCUN)) {
            this.temps = 0;
        }
    }

    public void setEcriture(ChoixEcriture graduation) {
        this.graduation = graduation;
    }

    public ChoixEcriture getWrite() {
        return this.graduation;
    }

    public void ecrire(String texte) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for(int dx=0;dx<texte.length();dx++) {
            System.out.print(texte.charAt(dx));
            try {
                Thread.sleep(this.temps);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void ecrireInstantanement(String texte) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(texte);
    }

    public void utiliserUnePause() {
        try {
            Thread.sleep(3500);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
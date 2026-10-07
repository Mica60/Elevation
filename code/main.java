import affichage.*;

public class main{

    public static void main(String[] args){

        music music = new music("audio/bobine.wav");
        new text("img/menu/credit.txt",during.ANIM);
        new text("img/menu/loading1.txt",during.ANIM);
        new text("img/menu/loading2.txt",during.ANIM);
        new text("img/menu/loading3.txt",during.ANIM);
        new text("img/menu/loading4.txt",during.ANIM);
        new text("img/menu/loading5.txt",during.ANIM);
        music.off();

    }
}

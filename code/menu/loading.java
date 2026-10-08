package menu;

import affichage.*;

public class loading{public static void startgame(){music music = new music("audio/bobine.wav");new text("img/menu/credit.txt",write.ANIM);new text("img/menu/loading1.txt",write.ANIM);new text("img/menu/loading2.txt",write.ANIM);new text("img/menu/loading3.txt",write.ANIM);new text("img/menu/loading4.txt",write.ANIM);new text("img/menu/loading5.txt",write.ANIM);music.off();}}
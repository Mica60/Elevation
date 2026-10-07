package affichage;

import java.io.File;
import javax.sound.sampled.*;

public class music{

    private Clip clip;private String road;private boolean loop;

    public music(String road,boolean loop){this.road=road;this.loop=loop;on();}
    public music(String road){this.road=road;this.loop=false;on();}

    public void on(){try{AudioInputStream audio=AudioSystem.getAudioInputStream(new File(road));clip=AudioSystem.getClip();clip.open(audio);if(loop){clip.loop(Clip.LOOP_CONTINUOUSLY);}else{clip.start();}}catch(Exception e){e.printStackTrace();}}
    public void off(){if(clip!=null){clip.stop();}}
      
}

import affichage.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main{

    public static void main(String[] args){

        String loadscre1="";String loadscre2="";String loadscre3="";String loadscre4="";String loadscre5="";String visualscre="";

        try {loadscre1=Files.readString(Path.of("img/menu/loadscre1.txt"));loadscre2=Files.readString(Path.of("img/menu/loadscre2.txt"));loadscre3=Files.readString(Path.of("img/menu/loadscre3.txt"));loadscre4=Files.readString(Path.of("img/menu/loadscre4.txt"));loadscre5=Files.readString(Path.of("img/menu/loadscre5.txt"));visualscre=Files.readString(Path.of("img/menu/visualscre.txt"));}catch(IOException e){e.printStackTrace();}
        
        during loadspe = new during(durgrade.ANIM);
        
        loadspe.writting(loadscre1);loadspe.writting(loadscre2);loadspe.writting(loadscre3);loadspe.writting(loadscre4);loadspe.writting(loadscre5);loadspe.writting(visualscre);
    }
}

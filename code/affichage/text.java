package affichage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class text{

    private String file;private String conv;during during;boolean cine;

    public text(String file,during during,boolean cine){this.file=file;this.during=during;this.cine=cine;writtingstart();}
    public text(String file,during during){this.file=file;this.during=during;this.cine=false;writtingstart();}

    public void writtingstart(){try{conv=Files.readString(Path.of(this.file));}catch(IOException e){e.printStackTrace();}write write=new write(this.during);write.writting(conv);if(this.cine){write.usePauseCine();}else{write.usePauseLauncher();}}
}

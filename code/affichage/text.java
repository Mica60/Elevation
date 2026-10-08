package affichage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class text{

    private String file;private String conv;write during;boolean cine;

    public text(String file,write during,boolean cine){this.file=file;this.during=during;this.cine=cine;writtingstart();}
    public text(String file,write during){this.file=file;this.during=during;this.cine=false;writtingstart();}

    public void writtingstart(){try{conv=Files.readString(Path.of(this.file));}catch(IOException e){e.printStackTrace();}useWrite write=new useWrite(this.during);write.writting(conv);if(this.cine){write.usePauseCine();}else{write.usePauseLauncher();}}

}

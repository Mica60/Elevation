package affichage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class text{

    private String file;private String conv;boolean cine;write during;boolean instant;

    public text(String file,write during,boolean cine,boolean instant){this.file=file;this.during=during;this.cine=cine;this.instant=instant;writtingstart();}
    public text(String file,write during){this.file=file;this.during=during;this.cine=false;this.instant=false;writtingstart();}
    public text(String file,boolean cine,write during){this.file=file;this.during=during;this.cine=cine;this.instant=false;writtingstart();}
    public text(String file,write during,boolean instant){this.file=file;this.during=during;this.cine=false;this.instant=instant;writtingstart();}

    public void writtingstart(){try{conv=Files.readString(Path.of(this.file));}catch(IOException e){e.printStackTrace();}useWrite write=new useWrite(this.during);if(this.instant){write.writtinginst(conv);}else{write.writting(conv);}if(this.cine){write.usePauseCine();}else{write.usePauseLauncher();}}

}

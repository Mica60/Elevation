package affichage;

public class write{

    private long time;private during grade;

    public write(during grade){this.grade=grade;chooseGrade();}
    public write(long time){this.time=time;this.grade=during.NONE;}

    public void setWrite(during grade){this.grade=grade;}
    public during getWrite(){return this.grade;}
    public String toString(){return ""+this.grade;}

    public void chooseGrade(){if(this.grade==during.SLOW){this.time=100;}if(this.grade==during.MEDIUM){this.time=50;}if(this.grade==during.FAST){this.time=1;}if(this.grade==during.ANIM){this.time=3000;}}
    public void writting(String text){System.out.print("\033[H\033[2J");System.out.flush();for(int dx=0;dx<text.length();dx++){System.out.println(text.charAt(dx));try{Thread.sleep(this.time);}catch(InterruptedException e){Thread.currentThread().interrupt();}}}
    public void usePauseLauncher(){try{Thread.sleep(1500);}catch(InterruptedException e){Thread.currentThread().interrupt();}}
    public void usePauseCine(){try{Thread.sleep(750);}catch(InterruptedException e){Thread.currentThread().interrupt();}}
}
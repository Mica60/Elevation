package affichage;

public class useWrite{

    private long time;private write grade;

    public useWrite(write grade){this.grade=grade;chooseGrade();}
    public useWrite(long time){this.time=time;this.grade=write.NONE;}

    public void setWrite(write grade){this.grade=grade;}
    public write getWrite(){return this.grade;}
    public String toString(){return ""+this.grade;}

    public void chooseGrade(){if(this.grade==write.SLOW){this.time=100;}if(this.grade==write.MEDIUM){this.time=50;}if(this.grade==write.FAST){this.time=1;}if(this.grade==write.ANIM){this.time=3000;}}
    public void writting(String text){System.out.print("\033[H\033[2J");System.out.flush();for(int dx=0;dx<text.length();dx++){System.out.println(text.charAt(dx));try{Thread.sleep(this.time);}catch(InterruptedException e){Thread.currentThread().interrupt();}}}
    public void usePauseLauncher(){try{Thread.sleep(1500);}catch(InterruptedException e){Thread.currentThread().interrupt();}}
    public void usePauseCine(){try{Thread.sleep(750);}catch(InterruptedException e){Thread.currentThread().interrupt();}}
    
}
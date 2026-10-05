public class during{
    private long time;private durgrade grade;

    public during(durgrade grade){this.grade=grade;chooseGrade();}

    public void setDuring(durgrade grade){this.grade=grade;}

    public durgrade getDuring(){return this.grade;}

    public String toString(){return ""+this.grade;}

    public void chooseGrade(){if(this.grade==durgrade.SLOW){this.time=1000;}if(this.grade==durgrade.MEDIUM){this.time=500;}if(this.grade==durgrade.FAST){this.time=1;}}

    public void writting(String text,boolean time){for(int dx=0;dx<text.length();dx++){System.out.println(text.charAt(dx));try{Thread.sleep(this.time);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}}}
}
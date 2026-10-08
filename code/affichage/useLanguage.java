package affichage;

public class useLanguage{
    private language language;

    public useLanguage(language language){this.language=language;}

    public language getLanguage(){return this.language;}
    public void setLanguage(){this.language=language;}
    public String toString(){if(this.language.equals(language.ENGLISH)){return "English";}else{return "Francais";}}

}

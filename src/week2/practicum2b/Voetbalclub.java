package week2.practicum2b;

public class Voetbalclub {

    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;
    private String voetbalClub;

    public Voetbalclub(String vc){
        if(vc == null || vc.trim().isEmpty()){
            voetbalClub = "FC";
        } else{
            voetbalClub = vc;
        }

    }

    public String getVoetbalClub(){
        return voetbalClub;
    }

    public void verwerkResultaat(char ch) {
        if (ch == 'w')
            aantalGewonnen = aantalGewonnen + 1;
        if (ch == 'g')
            aantalGelijk = aantalGelijk + 1;
        if (ch == 'v')
            aantalVerloren = aantalVerloren + 1;
    }

    public int aantalGespeeld(){
        return aantalGewonnen +  aantalGelijk + aantalVerloren;
    }

    public int aantalPunten(){
        return (aantalGewonnen * 3) + aantalGelijk;
    }

    public String toString(){
        return voetbalClub + " " + aantalGespeeld() + " " + aantalGewonnen + " " + aantalGelijk + " " + aantalVerloren + " " + aantalPunten();
    }
}

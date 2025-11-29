package week3.opdracht4_2;

public class Eigenaar {
    private String naam;
    private int giroNr;
    private Huisdier huisdier;

    public Eigenaar(String nm) {
        naam = nm;
    }

    public void setBeestje(Huisdier hd){
        huisdier = hd;
    }

    public Huisdier getBeestje(){
        return huisdier;
    }

    public String toString(){
        return naam + " heeft giro " + giroNr + ". En is het baasje van " + huisdier;
    }
}

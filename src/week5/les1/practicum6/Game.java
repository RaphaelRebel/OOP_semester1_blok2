package week5.les1.practicum6;

import java.time.LocalDate;

public class Game {

    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){

        int aantalJaren = LocalDate.now().getYear() - releaseJaar;
        double huidigePrijs = nieuwprijs;
        if(aantalJaren > 0){
            for(int i = 0; i < aantalJaren; i++){
                huidigePrijs = huidigePrijs * 0.70;
            }
        }

        return huidigePrijs;
    }

    public boolean equals(Object andereObject){
        boolean result = false;

        if(andereObject instanceof Game){
            Game andereGame = (Game) andereObject;

            if(naam.equals(andereGame.naam)
            && releaseJaar == andereGame.releaseJaar){
                result = true;
            }
        }

        return result;
    }

    public String toString(){
        return String.format("%s, uitgegeven in %d; nieuwprijs: \u20AC%.2f nu voor: \u20AC%.2f", naam, releaseJaar, nieuwprijs, huidigeWaarde());
    }

}

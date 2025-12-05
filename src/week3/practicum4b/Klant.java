package week3.practicum4b;

public class Klant {

    private String naam;
    private double kortingsPercentage = 0.0;

    public Klant(String nm){
        naam = nm;
    }

    public void setKorting(double kP) throws Exception{

        if(kP < 0){
            throw new IllegalArgumentException("Korting mag niet negatief zijn");
        }

        if(naam == null){
            throw new Exception("Geen huurder gevonden");
        }

        kortingsPercentage = kP;
    }

    public double getKorting(){
        return kortingsPercentage;
    }

    public String toString(){
        return String.format("%s (korting: %.1f%%)", naam, getKorting());
    }
}

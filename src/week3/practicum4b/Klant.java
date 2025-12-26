package week3.practicum4b;

public class Klant {

    private String naam;
    private double kortingsPercentage = 0.0;

    public Klant(String nm){
        if(nm == null || nm.isEmpty()){
            naam = "Huurder";
        } else {
            naam = nm;
        }

    }

    public void setKorting(double kP){

        if(kP < 0 || naam == null){
            kortingsPercentage = 0.0;
        } else{
            kortingsPercentage = kP;
        }

    }

    public double getKorting(){
        return kortingsPercentage;
    }

    public String toString(){
        return String.format("%s (korting: %.1f%%)", naam, getKorting());
    }
}

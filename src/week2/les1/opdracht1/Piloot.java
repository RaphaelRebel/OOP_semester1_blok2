package week2.les1.opdracht1;

public class Piloot {

    private String naam;
    private double salaris = 0;
    private int vlieguren = 0;


    public Piloot(String nm) {
        this.naam = nm;
    }

    public void setSalaris(double salaris){
        this.salaris = salaris;
    }

    public void verhoogVliegurenMet(int vlieguren){
        this.vlieguren = this.vlieguren + vlieguren;
    }

    public double getSalaris() {
        return salaris;
    }

    public int getVlieguren() {
        return vlieguren;
    }

    @Override
    public String toString() {
        return naam + " heeft " + vlieguren + " vlieguren gemaakt en verdient " +  salaris;
    }
}

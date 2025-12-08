package week4.les1.practicum5;

public class Leerling {

    private String naam;
    private double cijfer;

    public Leerling(String nm){
        naam = nm;
    }

    public String getNaam(){
        return naam;
    }

    public double getCijfer(){
        return cijfer;
    }

    public void setCijfer(double c){
        cijfer = c;
    }

    public String toString(){
        return String.format("%s heeft cijfer: %.1f", naam, cijfer);
    }
}

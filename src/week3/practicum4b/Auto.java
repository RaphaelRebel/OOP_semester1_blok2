package week3.practicum4b;

public class Auto {

    private String type;
    private double prijsPerDag;

    public Auto(String tp, double prPd) throws IllegalArgumentException{
        if(prPd < 0){
            prPd = 0;
        }
        type = tp;
        prijsPerDag = prPd;
    }

    public void setPrijsPerDag(double prPd) {
        if(prPd < 0){
            prijsPerDag = 0;
        } else{
            prijsPerDag = prPd;
        }

    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    public String toString(){
        return type + " met prijs per dag: " + prijsPerDag;
    }

}

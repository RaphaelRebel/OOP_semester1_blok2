package week2.practicum2;

public class Zwembad {

    private double lengte;
    private double breedte;
    private double diepte;

    public Zwembad(){
        this.lengte = 0;
        this.breedte = 0;
        this.diepte = 0;
    }
    public Zwembad(double breedte, double lengte, double diepte) {
        this.lengte = lengte;
        this.breedte = breedte;
        this.diepte = diepte;
    }

    public double getDiepte() {
        return diepte;
    }

    public void setDiepte(double diepte) {
        this.diepte = diepte;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double inhoud(){
        return this.lengte * this.breedte * this.diepte;
    }

    @Override
    public String toString() {
        return "Dit zwembad is "+ breedte +" meter breed, " + lengte + " meter lang, en " + diepte + " meter diep";
    }
}

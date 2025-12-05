package week3.practicum4a;

public class Huis {
    private String adres;
    private int bouwjaar;
    private Persoon huisbaas;

    public Huis(String adr, int bwjr){
        adres = adr;
        bouwjaar = bwjr;
    }

    public void setHuisbaas(Persoon hb){
        huisbaas = hb;
    }

    public Persoon getHuisbaas(){
        return huisbaas;
    }

    public String toString(){
        return "Huis " + adres + " is gebouwd in " + bouwjaar + " en heeft huisbaas " + huisbaas;
    }
}

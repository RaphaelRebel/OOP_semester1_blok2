package week3.practicum4b;

public class AutoHuur {
    private int aantalDagen;
    private Auto gehuurdeAuto;
    private Klant huurder;

    public void Autohuur(){}

    public void setAantalDagen(int aD) throws IllegalArgumentException{
        if(aD < 0){
            aantalDagen = 0;
        } else{
            aantalDagen = aD;
        }
    }

    public int getAantalDagen(){
        return aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA){

        gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto(){
        return gehuurdeAuto;
    }

    public void setHuurder(Klant k){
        huurder = k;
    }

    public Klant getHuurder(){
        return huurder;
    }

    public double totaalPrijs(){
        if(gehuurdeAuto == null){
            return 0.0;
        } else{

            double prijs;

            if(huurder.getKorting() != 0.0){
                prijs = (gehuurdeAuto.getPrijsPerDag() / 100 * (100 - huurder.getKorting())) * getAantalDagen();
            } else{
                prijs = gehuurdeAuto.getPrijsPerDag() * getAantalDagen();
            }

            if(prijs < 0){
                prijs = 0.0;
            }

            return prijs;

        }

    }


    public String toString(){
        String message = " ";

        if(gehuurdeAuto == null){
            message += "er is geen auto bekend";
        } else{
            message += "autotype: " + gehuurdeAuto;
        }

        if(huurder == null){
            message += "\n er is geen huurder bekend";
        } else{
            message += "\n op naam van: " + huurder;
        }

        try {
            return String.format("%s \n aantal dagen: %d en dat kost %.2f", message, aantalDagen, totaalPrijs());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

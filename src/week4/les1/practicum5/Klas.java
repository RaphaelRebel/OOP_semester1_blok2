package week4.les1.practicum5;

import java.util.ArrayList;


public class Klas {

    private String klasCode;
    private ArrayList<Leerling> deLeerlingen = new ArrayList<Leerling>();

    public Klas(String kC){
        klasCode = kC;
    }

    public void voegLeerlingToe(Leerling I){
        deLeerlingen.add(I);
    }

    public void wijzigCijfer(String nm, double nweCijfer){
        for(Leerling leerling : deLeerlingen){
            if(leerling.getNaam().equals(nm)){
                leerling.setCijfer(nweCijfer);
            }
        }
    }

    public ArrayList<Leerling> getLeerlingen(){
        return deLeerlingen;
    }

    public int aantalLeerlingen(){
         return deLeerlingen.size();
    }

    public String toString(){
        StringBuilder leerlingen = new StringBuilder("\n");

        for(Leerling leerling : deLeerlingen){
            leerlingen.append(leerling.toString()).append("\n");
        }


        return String.format("In klas %s zitten de volgende leerlingen%s", klasCode, leerlingen);
    }



}

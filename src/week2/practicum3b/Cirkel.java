package week2.practicum3b;

public class Cirkel {

    private int radius;
    private int xPositie;
    private int yPositie;


    public Cirkel(int r, int x, int y){

        if(r <= 0){
            throw new IllegalArgumentException("Radius moet groter dan 0 zijn!");
        }

        radius = r;
        xPositie = x;
        yPositie = y;
    }

    @Override
    public String toString() {
        return "cirkel (" + xPositie + ", " + yPositie + ") met radius " + radius;
    }
}

package week1.practicum1;

public class Opdracht4 {
    static void main() {
        int total = 0;

        for(int i = 0; i <= 39; i++){
            System.out.print(total + "+" + i + "= ");
            total = total + i;
            System.out.println(total);
        }

        System.out.println("Het antwoord is " + total);
    }
}

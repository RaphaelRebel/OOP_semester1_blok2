package week1.practicum1;
import java.lang.Math;

public class practicum {
    static void main() {

    System.out.println("Opdracht 1: ");

    for(int i = 1; i <= 10; i++){
		System.out.println(i);
	}

	System.out.println();
    System.out.println("Opdracht 2: ");

	int count = 1;

	while(count <= 10){
		System.out.println(count);
		count++;
	}
        System.out.println();
        System.out.println("Opdracht 3: ");
	for(int i = 0; i <= 10; i++){
		double random = Math.random();
		System.out.println(random);
	}
        System.out.println();
        System.out.println("Opdracht 4: ");
	int total = 0;
	
	for(int i = 0; i <= 39; i++){
		total = total + i;
	}

    System.out.println("Het antwoord is " + total);

    System.out.println();

    System.out.println("Opdracht 5: ");

	for(int i = 1; i <= 20; i++){
		if(i % 2 == 0){
			System.out.println("s");
		}else {
			System.out.println("ss");
		}
	}
 
    }
}

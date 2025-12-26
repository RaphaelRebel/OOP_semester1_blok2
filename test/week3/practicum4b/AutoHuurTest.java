package week3.practicum4b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.practicum2b.Voetbalclub;

import static org.junit.jupiter.api.Assertions.*;

class AutoHuurTest {

    private AutoHuur autoHuur;
    private Klant klant;
    private Auto auto;

    @BeforeEach
    public void init(){
        System.out.println("AutoHuur init");
        this.autoHuur = new AutoHuur();
        this.klant = new Klant("John Doe");
        this.auto = new Auto("Peugeot 108", 25);
    }
    @Test
    void test_heeftWelEenHuurderMaarGeenAuto_stuurtBericht() {
        System.out.println("Test: test_heeftWelEenHuurderMaarGeenAuto_stuurtBericht");
        this.autoHuur.setHuurder(this.klant);

        String expectedResult = String.format(" er is geen auto bekend\n op naam van: John Doe (korting: 0.0%%) \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }


    @Test
    void test_heeftEenAutoEnHuurderMetKorting_stuurtBericht() {
        System.out.println("Test: test_heeftEenAutoEnHuurderMetKorting_stuurtBericht");


            this.klant.setKorting(10.0);
            this.autoHuur.setAantalDagen(2);
            this.autoHuur.setHuurder(this.klant);
            this.autoHuur.setGehuurdeAuto(this.auto);


        String expectedResult = String.format(" autotype: Peugeot 108 met prijs per dag: 25.0\n op naam van: John Doe (korting: 10.0%%) \n aantal dagen: 2 en dat kost 45.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftGeenhuurderEnAuto_stuurtBericht(){
        System.out.println("Test: test_heeftGeenhuurderEnAuto_stuurtBericht");

        String expectedResult = String.format(" er is geen auto bekend\n er is geen huurder bekend \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftHuurderMetKortingMaarGeenAuto_stuurtBericht(){
        System.out.println("Test: test_heeftHuurderMetKortingMaarGeenAuto_stuurtBericht");

            this.autoHuur.setHuurder(this.klant);
            this.klant.setKorting(10.0);

        String expectedResult = String.format(" er is geen auto bekend\n op naam van: John Doe (korting: 10.0%%) \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftHuurderZonderKortingMetHuurAuto_stuurtBericht(){
        System.out.println("Test: test_heeftHuurderZonderKortingMetHuurAuto_stuurtBericht");

            this.autoHuur.setAantalDagen(2);
            this.autoHuur.setHuurder(this.klant);
            this.autoHuur.setGehuurdeAuto(this.auto);

        String expectedResult = String.format(" autotype: Peugeot 108 met prijs per dag: 25.0\n op naam van: John Doe (korting: 0.0%%) \n aantal dagen: 2 en dat kost 50.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftGeenHuurderOfAutoMaarWelKorting_geeftNaamHuurder(){
        System.out.println("Test: test_heeftGeenHuurderOfAutoMaarWelKorting_geeftNaamHuurder");

        this.klant = new Klant(null);
        this.klant.setKorting(10.0);
        this.autoHuur.setHuurder(this.klant);

        String expectedResult = String.format(" er is geen auto bekend\n op naam van: Huurder (korting: 10.0%%) \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftGeenHuurderMaarWelKortingEnAuto_geeftNaamHuurderMetAuto(){
        System.out.println("Test: test_heeftGeenHuurderOfAutoMaarWelKorting_geeftNaamHuurder");

        this.klant = new Klant(null);
        this.klant.setKorting(10.0);
        this.autoHuur.setHuurder(this.klant);
        this.autoHuur.setGehuurdeAuto(this.auto);

        String expectedResult = String.format(" autotype: Peugeot 108 met prijs per dag: 25.0\n op naam van: Huurder (korting: 10.0%%) \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_heeftGeenHuurderMaarWelAuto_geeftNaamHuurderMetAuto(){
        System.out.println("Test: test_heeftGeenHuurderOfAutoMaarWelKorting_geeftNaamHuurder");

        this.klant = new Klant(null);
        this.autoHuur.setHuurder(this.klant);
        this.autoHuur.setGehuurdeAuto(this.auto);

        String expectedResult = String.format(" autotype: Peugeot 108 met prijs per dag: 25.0\n op naam van: Huurder (korting: 0.0%%) \n aantal dagen: 0 en dat kost 0.00");

        assertTrue(this.autoHuur.toString().contains(expectedResult));
    }

    @Test
    void test_totalePrijsIsNegatief_geeftNul(){
        System.out.println("Test: test_totalePrijsIsNegatief_geeftNull");
        this.klant = new Klant(null);
        this.autoHuur.setHuurder(this.klant);
        this.auto.setPrijsPerDag(-2);

        this.autoHuur.setGehuurdeAuto(this.auto);

        assertEquals(0.0, this.autoHuur.totaalPrijs());
    }

    @Test
    void test_totalePrijsIsNietNegetief_geeftTotalePrijs(){
        System.out.println("Test: test_totalePrijsIsNietNegetief_geeftTotalePrijs");
        this.klant = new Klant(null);
        this.autoHuur.setHuurder(this.klant);
        this.auto.setPrijsPerDag(2);
        this.autoHuur.setAantalDagen(2);

        this.autoHuur.setGehuurdeAuto(this.auto);

        assertEquals(4.0, this.autoHuur.totaalPrijs());
    }


    @Test
    void test_aantalDagenIsNegatief_geeftNul(){
        System.out.println("Test: test_aantalDagenIsNegatief_geeftNul");

        this.autoHuur.setAantalDagen(-2);

        assertEquals(0, this.autoHuur.getAantalDagen());
    }

    @Test
    void test_aantalDagenIsNietNegetief_geeftAantalDagen(){
        System.out.println("Test: test_aantalDagenIsNietNegetief_geeftAantalDagen");

        this.autoHuur.setAantalDagen(2);

        assertEquals(2, this.autoHuur.getAantalDagen());
    }

    @Test
    void test_kortingsPercentageIsNegatief_geeftNul(){
        System.out.println("Test: test_kortingsPercentageIsNegatief_geeftNul");

        this.klant.setKorting(-2);

        assertEquals(0, this.klant.getKorting());
    }

    @Test
    void test_kortingsPercentageIsNietNegetief_geeftKortingsPercentage(){
        System.out.println("Test: test_kortingsPercentageIsNietNegetief_geeftKortingsPercentage");

        this.klant.setKorting(2);

        assertEquals(2, this.klant.getKorting());
    }

    @Test
    void test_prijsPerDagIsNegatief_geeftNul(){
        System.out.println("Test: test_prijsPerDagIsNegatief_geeftNul");

        this.auto.setPrijsPerDag(-2);

        assertEquals(0, this.auto.getPrijsPerDag());
    }

    @Test
    void test_prijsPerDagIsNietNegetief_geeftPrijsPerDag(){
        System.out.println("Test: test_prijsPerDagIsNietNegetief_geeftPrijsPerDag");

        this.auto.setPrijsPerDag(2);

        assertEquals(2, this.auto.getPrijsPerDag());
    }
}
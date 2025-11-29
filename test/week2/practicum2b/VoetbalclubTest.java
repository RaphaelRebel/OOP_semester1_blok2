package week2.practicum2b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoetbalclubTest {

	private Voetbalclub voetbalclub;

    @BeforeEach
    public void init(){
        System.out.println("VoetbalclubTest init");
	    voetbalclub = new Voetbalclub("");
    }


    @Test
    void test_isClubNaamLeeg_geefFC(){
        System.out.println("test_isClubNaamLeeg_geefFC");

        assertEquals("FC",  voetbalclub.getVoetbalClub());

        voetbalclub = new Voetbalclub(null);
        assertEquals("FC",  voetbalclub.getVoetbalClub());
    }

	@Test
	void test_resultaatToontPunten_win(){
        System.out.println("test_resultaatToontPunten_win");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
		voetbalclub.verwerkResultaat('w');

        assertEquals(puntenVoorVerwerking + 3, voetbalclub.aantalPunten());

	}

    @Test
    void test_resultaatToontPunten_verlies(){
        System.out.println("test_resultaatToontPunten_verlies");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('v');

        assertEquals(puntenVoorVerwerking, voetbalclub.aantalPunten());

    }

    @Test
    void test_resultaatToontPunten_gelijk(){
        System.out.println("test_resultaatToontPunten_gelijk");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('g');

        assertEquals(puntenVoorVerwerking + 1, voetbalclub.aantalPunten());

    }

    @Test
    void test_resultaatToontPunten_foutieveInvoer(){
        System.out.println("test_resultaatToontPunten_foutieveInvoet");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        int gespeeldVoorVerwerking = voetbalclub.aantalGespeeld();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('a');
        voetbalclub.verwerkResultaat('x');
        voetbalclub.verwerkResultaat('P');

        assertEquals(puntenVoorVerwerking, voetbalclub.aantalPunten());
        assertEquals(gespeeldVoorVerwerking, voetbalclub.aantalGespeeld());
    }

    @Test
    void test_resultaatToontPunten_inToString(){
        System.out.println("test_resultaatToontPunten_inToString");
        voetbalclub.verwerkResultaat('g');
        voetbalclub.verwerkResultaat('v');
        voetbalclub.verwerkResultaat('w');

        String expectedToString = "FC 3 1 1 1 4";

        assertEquals(expectedToString, voetbalclub.toString());
    }

    @Test
    void test_herhalendeVerwerkingen_geeftCorrecteTelling(){
        System.out.println("test_herhalendeVerwerkingen_geeftCorrecteTelling");
        voetbalclub.verwerkResultaat('g');
        voetbalclub.verwerkResultaat('v');
        voetbalclub.verwerkResultaat('w');
        voetbalclub.verwerkResultaat('g');
        voetbalclub.verwerkResultaat('g');
        voetbalclub.verwerkResultaat('w');
        voetbalclub.verwerkResultaat('v');

        int verwachtePunten = 6 + 3;
        int verwachteWedstrijdAantal = 7;

        assertEquals(verwachtePunten, voetbalclub.aantalPunten());
        assertEquals(verwachteWedstrijdAantal, voetbalclub.aantalGespeeld());
    }

}

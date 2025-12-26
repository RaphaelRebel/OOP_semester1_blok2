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
    void test_isClubnaamLeeg_geefFC(){
        System.out.println("test_isClubNaamLeeg_geefFC");

        assertEquals("FC",  voetbalclub.getVoetbalClub());
    }

    @Test
    void test_isClubnaamNull_geefFC(){
        System.out.println("test_isClubNaamNull_geefFC");
        Voetbalclub nullVoetbalclub = new Voetbalclub(null);
        assertEquals("FC",  nullVoetbalclub.getVoetbalClub());
    }

    @Test
    void test_heeftClubnaam_geefClubnaam(){
        System.out.println("test_heeftClubnaam_geefClubnaam");
        Voetbalclub MetNaamVoetbalclub = new Voetbalclub("Ajax");
        assertEquals("Ajax",  MetNaamVoetbalclub.getVoetbalClub());
    }

	@Test
	void test_resultaatToontPunten_win(){
        System.out.println("test_resultaatToontPunten_win");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
		voetbalclub.verwerkResultaat('w');

        assertEquals(puntenVoorVerwerking + 3, voetbalclub.aantalPunten());
        assertEquals(1, voetbalclub.aantalGespeeld());
	}



    @Test
    void test_resultaatToontPunten_gelijk(){
        System.out.println("test_resultaatToontPunten_gelijk");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('g');

        assertEquals(puntenVoorVerwerking + 1, voetbalclub.aantalPunten());
        assertEquals(1, voetbalclub.aantalGespeeld());

    }

    @Test
    void test_resultaatToontPunten_verlies(){
        System.out.println("test_resultaatToontPunten_verlies");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('v');

        assertEquals(puntenVoorVerwerking, voetbalclub.aantalPunten());
        assertEquals(1, voetbalclub.aantalGespeeld());

    }

    @Test
    void test_resultaatToontPunten_foutieveInvoer(){
        System.out.println("test_resultaatToontPunten_foutieveInvoet");
        int puntenVoorVerwerking = voetbalclub.aantalPunten();
        int gespeeldVoorVerwerking = voetbalclub.aantalGespeeld();
        System.out.println("puntenVoorVerwerking = " + puntenVoorVerwerking);
        voetbalclub.verwerkResultaat('w');
        voetbalclub.verwerkResultaat('X');

        assertTrue(puntenVoorVerwerking + 3 == voetbalclub.aantalPunten());
        assertTrue(gespeeldVoorVerwerking + 1 == voetbalclub.aantalGespeeld());
    }

    @Test
    void test_resultaatToontPunten_inToString(){
        System.out.println("test_resultaatToontPunten_inToString");
        voetbalclub.verwerkResultaat('w');
        voetbalclub.verwerkResultaat('g');
        voetbalclub.verwerkResultaat('v');

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

        int verwachtePunten = 6 + 3; //2 gewonnen (6 punten) en 3 gelijk gespeeld (3 punten)
        int verwachteWedstrijdAantal = 7;

        assertEquals(verwachtePunten, voetbalclub.aantalPunten());
        assertEquals(verwachteWedstrijdAantal, voetbalclub.aantalGespeeld());
    }

}

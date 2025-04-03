package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Village villageSansEtal;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	private Chef chefix;
	
	@BeforeEach
	void initialiserSituation() throws Exception {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréducibles",10,5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		villageSansEtal = new Village("Village sans Etal",5,0);
		chefix = new Chef("Chefix",10,villageSansEtal);
		villageSansEtal.setChef(chefix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal,"Constructeur ne revnoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		ControlPrendreEtal controlPrendreEtalVillageSansEtal = new ControlPrendreEtal(controlVerifierIdentite, villageSansEtal);
		assertFalse(controlPrendreEtalVillageSansEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendeEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(0,controlPrendeEtal.prendreEtal("Abraracourcix", "potions", 5));
		ControlPrendreEtal controlPrendreEtalVillageSansEtal = new ControlPrendreEtal(controlVerifierIdentite, villageSansEtal);
		assertEquals(-1,controlPrendreEtalVillageSansEtal.prendreEtal("Chefix", "kebabs", 5));
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendeEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendeEtal.verifierIdentite("Abraracourcix"));
		assertFalse(controlPrendeEtal.verifierIdentite("Pas un habitant"));

	}

}

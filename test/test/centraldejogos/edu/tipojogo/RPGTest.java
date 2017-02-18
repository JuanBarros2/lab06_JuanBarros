package test.centraldejogos.edu.tipojogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.tipojogo.RPG;

public class RPGTest {
	private RPG rpg;

	@Before
	public void setUp() throws Exception {
		rpg = new RPG("Super Mario", 80.99, null);
	}

	@Test
	public void testRegistraJogada() {
		assertEquals(10, rpg.registraJogada(1, true));
		assertEquals(20, rpg.registraJogada(1, false));
		assertEquals(30, rpg.registraJogada(1, false));
		assertEquals(40, rpg.registraJogada(1, true));
		assertEquals(50, rpg.registraJogada(4999, false));
		assertEquals(60, rpg.registraJogada(302, true));
		assertEquals(4999, rpg.getPontuacao());
		
		
		try{
			rpg.registraJogada(-1, false);
			fail("Aceita valor negativo");
		} catch(Exception e){
			assertEquals(e.getMessage(), "Parametro invalido");
		}
		assertEquals(3, rpg.getVezesConcluidas());
		assertEquals(6, rpg.getQuant_jogadas());
	}

	@Test
	public void testToString(){
		String ln = System.lineSeparator();
		assertTrue(rpg.toString().equals("Super Mario - RPG:" + ln
				+ "==> Jogou 0 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 0"));
		rpg.registraJogada(1, false);
		assertTrue(rpg.toString().equals("Super Mario - RPG:" + ln
				+ "==> Jogou 1 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 1"));
		rpg.registraJogada(2, true);
		assertTrue(rpg.toString().equals("Super Mario - RPG:" + ln
				+ "==> Jogou 2 vez(es)" + ln
				+ "==> Zerou 1 vez(es)" + ln
				+ "==> Maior score: 2"));
		rpg.registraJogada(2, true);
		rpg.registraJogada(2, true);
		rpg.registraJogada(2, true);
		assertTrue(rpg.toString().equals("Super Mario - RPG:" + ln
				+ "==> Jogou 5 vez(es)" + ln
				+ "==> Zerou 4 vez(es)" + ln
				+ "==> Maior score: 2"));
		rpg.registraJogada(1000, true);
		assertTrue(rpg.toString().equals("Super Mario - RPG:" + ln
				+ "==> Jogou 6 vez(es)" + ln
				+ "==> Zerou 5 vez(es)" + ln
				+ "==> Maior score: 1000"));
	}

}

package test.centraldejogos.edu.tipojogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.tipojogo.Luta;

public class LutaTest {
	private Luta luta;

	@Before
	public void setUp() throws Exception {
		luta = new Luta("Battlefield", 80.99);
	}

	@Test
	public void testRegistraJogada() {
		assertEquals(2, luta.registraJogada(2000, true));
		assertEquals(3, luta.registraJogada(3000, false));
		assertEquals(3, luta.registraJogada(3001, false));
		assertEquals(4, luta.registraJogada(4001, true));
		assertEquals(4, luta.registraJogada(4999, false));
		assertEquals(0, luta.registraJogada(302, true));
		assertEquals(4999, luta.getPontuacao());
		
		
		try{
			luta.registraJogada(-1, false);
			fail("Aceita valor negativo");
		} catch(Exception e){
			assertEquals(e.getMessage(), "Parametro invalido");
		}
		try{
			luta.registraJogada(100001, false);
		} catch(Exception e){
			assertEquals(e.getMessage(), "Parametro invalido");
		}
		
		assertEquals(4999, luta.getPontuacao());
		assertEquals(3, luta.getVezesConcluidas());
		assertEquals(6, luta.getQuant_jogadas());
		assertEquals(80, luta.registraJogada(80000, true));
		assertEquals(4, luta.getVezesConcluidas());
	}

	@Test
	public void testToString(){
		String ln = System.lineSeparator();
		assertTrue(luta.toString().equals("Battlefield - Luta:" + ln
				+ "==> Jogou 0 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 0"));
		luta.registraJogada(1, false);
		assertTrue(luta.toString().equals("Battlefield - Luta:" + ln
				+ "==> Jogou 1 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 1"));
		luta.registraJogada(2, true);
		assertTrue(luta.toString().equals("Battlefield - Luta:" + ln
				+ "==> Jogou 2 vez(es)" + ln
				+ "==> Zerou 1 vez(es)" + ln
				+ "==> Maior score: 2"));
		luta.registraJogada(2, true);
		luta.registraJogada(2, true);
		luta.registraJogada(2, true);
		assertTrue(luta.toString().equals("Battlefield - Luta:" + ln
				+ "==> Jogou 5 vez(es)" + ln
				+ "==> Zerou 4 vez(es)" + ln
				+ "==> Maior score: 2"));
		luta.registraJogada(1000, true);
		assertTrue(luta.toString().equals("Battlefield - Luta:" + ln
				+ "==> Jogou 6 vez(es)" + ln
				+ "==> Zerou 5 vez(es)" + ln
				+ "==> Maior score: 1000"));
	}

}

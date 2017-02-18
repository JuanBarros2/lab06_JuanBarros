package test.centraldejogos.edu.tipojogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.tipojogo.Plataforma;

public class PlataformaTest {

	private Plataforma plataforma;

	@Before
	public void setUp() throws Exception {
		plataforma = new Plataforma("Super Mario", 80.99);
	}

	@Test
	public void testRegistraJogada() {
		assertEquals(20, plataforma.registraJogada(1, true));
		assertEquals(20, plataforma.registraJogada(1, false));
		assertEquals(20, plataforma.registraJogada(1, false));
		assertEquals(40, plataforma.registraJogada(1, true));
		assertEquals(40, plataforma.registraJogada(4999, false));
		assertEquals(60, plataforma.registraJogada(302, true));
		assertEquals(4999, plataforma.getPontuacao());
		
		
		try{
			plataforma.registraJogada(-1, false);
			fail("Aceita valor negativo");
		} catch(Exception e){
			assertEquals(e.getMessage(), "Parametro invalido");
		}
		assertEquals(3, plataforma.getVezesConcluidas());
		assertEquals(6, plataforma.getQuant_jogadas());
	}

	@Test
	public void testToString(){
		String ln = System.lineSeparator();
		assertTrue(plataforma.toString().equals("Super Mario - Plataforma:" + ln
				+ "==> Jogou 0 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 0"));
		plataforma.registraJogada(1, false);
		assertTrue(plataforma.toString().equals("Super Mario - Plataforma:" + ln
				+ "==> Jogou 1 vez(es)" + ln
				+ "==> Zerou 0 vez(es)" + ln
				+ "==> Maior score: 1"));
		plataforma.registraJogada(2, true);
		assertTrue(plataforma.toString().equals("Super Mario - Plataforma:" + ln
				+ "==> Jogou 2 vez(es)" + ln
				+ "==> Zerou 1 vez(es)" + ln
				+ "==> Maior score: 2"));
		plataforma.registraJogada(2, true);
		plataforma.registraJogada(2, true);
		plataforma.registraJogada(2, true);
		assertTrue(plataforma.toString().equals("Super Mario - Plataforma:" + ln
				+ "==> Jogou 5 vez(es)" + ln
				+ "==> Zerou 4 vez(es)" + ln
				+ "==> Maior score: 2"));
		plataforma.registraJogada(1000, true);
		assertTrue(plataforma.toString().equals("Super Mario - Plataforma:" + ln
				+ "==> Jogou 6 vez(es)" + ln
				+ "==> Zerou 5 vez(es)" + ln
				+ "==> Maior score: 1000"));
	}

}

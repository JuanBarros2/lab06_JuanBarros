package test.centraldejogos.edu.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.Jogo;
import centraldejogos.edu.exceptions.ParametroInvalidoException;

public class JogoTest {
	private Jogo jogo;
	
	@Before
	public void setUp(){
		jogo = new Jogo("DST", 15.99);
	}

	@Test
	public void testConstrutorJogo() {
		try{
			new Jogo("The Sims", 3);
			new Jogo("1", 1);
			new Jogo("LoL", 1.0);
			new Jogo("DST", 0);
		}catch(ParametroInvalidoException e){
			fail();
		}
	}
	
	@Test(expected = ParametroInvalidoException.class)
	public void testConstrutorNomeInvalidoJogo() {
		new Jogo("", 3);
	}
	
	@Test(expected = NullPointerException.class)
	public void testConstrutorNomeNuloJogo() {
		new Jogo(null, 3);
	}
	
	@Test(expected = ParametroInvalidoException.class)
	public void testConstrutorPrecoInvalidoJogo() {
		new Jogo("DST", -1);
	}

	@Test
	public void testRegistraJogada() {
		jogo.registraJogada(100, false);
		assertEquals(jogo.getPontuacao(), 100);
		jogo.registraJogada(10, false);
		assertEquals(jogo.getPontuacao(), 100);
		jogo.registraJogada(200, false);
		assertEquals(jogo.getPontuacao(), 200);
		jogo.registraJogada(100, false);
		assertEquals(jogo.getPontuacao(), 200);
		jogo.registraJogada(100, true);
		assertEquals(jogo.getVezesConcluidas(), 1);
		jogo.registraJogada(100, true);
		assertEquals(jogo.getVezesConcluidas(), 2);
		jogo.registraJogada(300, true);
		assertEquals(jogo.getVezesConcluidas(), 3);
		assertEquals(jogo.getPontuacao(), 300);
	}

}

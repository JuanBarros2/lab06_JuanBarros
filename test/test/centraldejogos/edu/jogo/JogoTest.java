package test.centraldejogos.edu.jogo;

import static org.junit.Assert.*;

import org.junit.Test;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.jogo.Jogo;

public class JogoTest {

	@Test
	public void testJogo() {
		new Jogo("The Sims", 3);
		try{
			new Jogo("DST", -1);
		}catch(ParametroInvalidoException e){
			
		}
	}

	@Test
	public void testRegistraJogada() {
	}

}

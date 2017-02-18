package test.centraldejogos.edu.tipousuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.RPG;
import centraldejogos.edu.tipousuario.Noob;

public class NoobTest {
	private Noob usuario;

	@Before
	public void setUp() throws Exception {
		usuario = new Noob("Juan", "juan");
		usuario.adicionaCredito(100);
		usuario.compraJogo(new RPG("DST", 99, null));
	}

	@Test
	public void testUpgrade() {
		assertEquals(usuario.getX2p(), 990);
		try {
			usuario.upgrade();
		} catch (UpgradeInvalidoException e) {
			assertEquals(e.getMessage(), "O usuario ja eh veterano ou nao possui pontos suficientes");
		} 
		
		try{
			usuario.registraJogada("DST", 100, false);
			assertEquals(usuario.getX2p(), 1000);
			usuario.upgrade();
		} catch (JogoNaoEncontradoException e) {
			fail("Jogo nao encontrado");
		} catch (UpgradeInvalidoException e) {
			fail(e.getMessage());
		}
	}

}

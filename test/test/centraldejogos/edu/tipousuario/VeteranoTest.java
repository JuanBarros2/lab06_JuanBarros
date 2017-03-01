package test.centraldejogos.edu.tipousuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.RPG;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Veterano;

public class VeteranoTest {
	private Veterano usuario;

	@Before
	public void setUp() throws Exception {
		usuario = new Veterano("Juan", "juan");
		usuario.adicionaCredito(100);
		usuario.compraJogo(new RPG("DST", 99, null));
	}

	@Test
	public void testUpgrade() {
		assertEquals(usuario.getX2p(), 2485);
		try {
			usuario.upgrade();
		} catch (UpgradeInvalidoException e) {
			assertEquals(e.getMessage(), "O usuario ja eh veterano ou nao possui pontos suficientes");
		} //Tenta dar upgrade em usuario veterano com pontos acima de 1000
		
		try{
			usuario.setX2p(0);
			usuario.upgrade();
			fail("Veterano atualizado");
		} catch (UpgradeInvalidoException e) {
			assertEquals("O usuario ja eh veterano ou nao possui pontos suficientes", e.getMessage());
		}// Tenta dar upgrade em usuario veterano com pouco x2p
	}
	
	@Test
	public void testVeterano(){
		usuario = new Veterano("Juan", "juan");
		assertEquals(1000, usuario.getX2p());
	}

}

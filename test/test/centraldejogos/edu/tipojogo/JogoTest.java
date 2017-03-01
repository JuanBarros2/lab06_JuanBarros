package test.centraldejogos.edu.tipojogo;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.Jogabilidade;
import centraldejogos.edu.tipojogo.*;

public class JogoTest {
	
	private Jogo jogo;

	@Before
	public void setUp() throws Exception {
		jogo = new RPG("R", 10, new HashSet<Jogabilidade>());
	}

	@Test
	public void testEquals(){
		assertTrue(jogo.equals(new RPG("R", 12, null)));
		assertFalse(jogo.equals(new Plataforma("R", 12, null)));
		assertFalse(jogo.equals(new RPG("Rs", 12, null)));
		assertFalse(jogo.equals(new Plataforma("S", 10, null)));
		assertFalse(jogo.equals(new RPG("r", 10, null)));
	}
	
	@Test
	public void testJogo() {
		HashSet<Jogabilidade> estilos = new HashSet<Jogabilidade>();
		estilos.add(Jogabilidade.ONLINE);
		estilos.add(Jogabilidade.MULTIPLAYER);
		estilos.add(Jogabilidade.COMPETITIVO);
		estilos.add(Jogabilidade.ONLINE);
		assertEquals(estilos.size(), 3);
		try{
			jogo = new RPG("", 1, estilos);
			fail("Nome vazio");
		} catch(Exception e){
			assertEquals(e.getMessage(), "O nome nao pode estar vazio");
		}
		
		try{
			jogo = new RPG("  ", 1, estilos);
			fail("Nome vazio");
		} catch(Exception e){
			assertEquals(e.getMessage(),"O nome nao pode estar vazio");
		}
		
		try{
			jogo = new RPG(null, 1, estilos);
			fail("Nome nulo");
		} catch(Exception e){
			assertEquals(e.getMessage(), "O nome nao pode ser nulo");
		}

		try{
			jogo = new RPG("DST", -1, estilos);
			fail("Valor invalido");
		} catch(Exception e){
			assertEquals(e.getMessage(), "Preco nao pode ser negativo");
		}
		
		try{
			jogo = new RPG("DST", 2, null);
			assertEquals(jogo.getEstilos().size(), 0);
		} catch(Exception e){
			fail("Estilos nao inicializados");
		}
		
		jogo = new RPG("DST", 13.12, estilos);
		assertEquals(jogo.getNome(), "DST");
		assertEquals(jogo.getPontuacao(), 0);
		assertEquals(jogo.getPreco(), 13.12, 0.001);
		assertEquals(jogo.getQuant_jogadas(), 0);
		assertEquals(jogo.getVezesConcluidas(),0);
		assertEquals(jogo.getEstilos(), estilos);
		//Verifica se o jogo foi inicializado adequadamente
	}
}

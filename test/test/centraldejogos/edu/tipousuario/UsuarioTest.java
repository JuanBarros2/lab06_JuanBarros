package test.centraldejogos.edu.tipousuario;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.exceptions.SaldoInsuficienteException;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipojogo.RPG;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class UsuarioTest {
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		usuario = new Noob("Juan", "juan");
	}

	@Test
	public void testUsuario() {
		try{
			usuario = new Noob("", "juan");
			fail("Usuario com nome vazio");
		}catch(Exception e){
			assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			usuario = new Noob(null, "juan");
			fail("Usuario com nome nulo");
		}catch(Exception e){
			assertEquals("Nome nao pode ser nulo", e.getMessage());
		}

		try{
			usuario = new Noob("Juan", "");
			fail("Usuario com login vazio");
		}catch(Exception e){
			assertEquals("Login invalido", e.getMessage());
		}

		try{
			usuario = new Noob("Juan", null);
			fail("Usuario com login nulo");
		}catch(Exception e){
			assertEquals("Login nao pode ser nulo", e.getMessage());
		}
		
		usuario = new Noob("Juan", "juan");
		assertEquals(usuario.getJogos().size(), 0);
		assertEquals(usuario.getLogin(), "juan");
		assertEquals(usuario.getNome(), "Juan");
		assertEquals(usuario.getX2p(), 0);
	}

	@Test
	public void testCompraJogo() {
		try{
			usuario.compraJogo(null);
			fail();
		}catch(Exception e){
			assertEquals("Jogo nao pode ser nulo", e.getMessage());
		}
		
		Jogo jogo = new RPG("DST", 30, null);
		usuario.adicionaCredito(100);
		try{
			usuario.compraJogo(jogo);
			assertEquals(73, usuario.getSaldoJogos(), 0.001);
			usuario.compraJogo(jogo);
			fail();
		} catch (ParametroInvalidoException e) {
			assertEquals(e.getMessage(), "Jogo ja adicionado ao usuario");
		} catch (SaldoInsuficienteException e) {
			fail();
		}
		assertEquals(usuario.getX2p(), 300);
		
		jogo = new RPG("DS", 90, null);
		try {
			usuario.compraJogo(jogo);
			fail("Valor insuficiente");
		} catch (SaldoInsuficienteException e) {
			assertEquals("Saldo insuficiente", e.getMessage());
		}
		assertEquals(73, usuario.getSaldoJogos(), 0.001);
		jogo.setPreco(80);
		try {
			usuario.compraJogo(jogo);
		} catch (SaldoInsuficienteException e) {
			fail();
		}
		assertEquals(usuario.getX2p(), 1100);
		assertEquals(1, usuario.getSaldoJogos(), 0.001);
		
		
	}

	@Test
	public void testAdicionaCredito() {
		usuario.adicionaCredito(100);
		assertEquals(100, usuario.getSaldoJogos(), 0.0001);
		usuario.adicionaCredito(2000);
		assertEquals(2100, usuario.getSaldoJogos(), 0.0001);
		try {
			usuario.compraJogo(new RPG("DST", 2100, null));
		} catch (SaldoInsuficienteException e) {
			fail(e.getMessage());
		}
		assertEquals(210, usuario.getSaldoJogos(), 0.0001);
		usuario.adicionaCredito(2000);
		assertEquals(2210, usuario.getSaldoJogos(), 0.0001);
		try {
			usuario.adicionaCredito(0);
			fail("Credito invalido");
		} catch (Exception e) {
			assertEquals("Credito nao pode ser negativo", e.getMessage());
		}
		
		assertEquals(2210, usuario.getSaldoJogos(), 0.0001);
		try {
			usuario.adicionaCredito(-1);
			fail("Credito invalido");
		} catch (Exception e) {
			assertEquals("Credito nao pode ser negativo", e.getMessage());
		}
		assertEquals(2210, usuario.getSaldoJogos(), 0.0001);
	}

	@Test
	public void testEqualsObject() {
		Usuario user = new Noob("sa","juan");
		assertTrue(usuario.equals(user));
		assertFalse(usuario.equals(new Veterano("sa","j")));
		assertTrue(usuario.equals(new Veterano("sa","juan")));
	}
	
	@Test
	public void testToString(){
		String ln = System.lineSeparator();
		String result = "juan" + ln +
				"Juan - Jogador Noob" + ln +
				"Lista de Jogos:" +
		"Total de preco dos jogos: R$ 0,00" + ln +
		"--------------------------------------------";
		
		assertEquals(result,usuario.toString());
		
		
		usuario.adicionaCredito(100);
		RPG rpg = new RPG("DST", 100, null);
		try {
			usuario.compraJogo(rpg);
		} catch (SaldoInsuficienteException e) {
			fail();
		}
		result = "juan" + ln +
				"Juan - Jogador Noob" + ln +
				"Lista de Jogos:" +
				" + " + rpg + ln +
		"Total de preco dos jogos: R$ 90,00" + ln +
		"--------------------------------------------";
		
		rpg = new RPG("DS", 10, null);
		try {
			usuario.compraJogo(rpg);
		} catch (SaldoInsuficienteException e) {
			fail();
		}
		result = "juan" + ln +
				"Juan - Jogador Noob" + ln +
				"Lista de Jogos:" +
				" + " + rpg + ln +
				" + " + rpg + ln +
		"Total de preco dos jogos: R$ 99,00" + ln +
		"--------------------------------------------";
	}

}

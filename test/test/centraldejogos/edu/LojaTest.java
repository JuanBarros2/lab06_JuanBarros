package test.centraldejogos.edu;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.Loja;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.exceptions.UsuarioDesconhecidoException;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipojogo.Luta;
import centraldejogos.edu.tipojogo.Plataforma;
import centraldejogos.edu.tipojogo.RPG;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class LojaTest {
	private ArrayList<Jogo> jogos;
	private Loja loja;
	private ArrayList<Usuario> usuarios;
	
	private void constroeJogos(){
		jogos = new ArrayList<Jogo>();
		jogos.add(new RPG("Dont Starve Together(DST)", 30.00, null));
		jogos.add(new Plataforma("Mario", 10.20, null));
		jogos.add(new Luta("Street Fight", 16.57, null));
		jogos.add(new RPG("The Sims", 1.99, null));
		jogos.add(new Luta("Agar.io", 0.00, null));
		jogos.add(new Plataforma("Tibia", 10.69, null));
	}
	
	private void constroeUsuarios(){
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Noob("Juan","juan"));
		usuarios.add(new Veterano("Joao","joao"));
		usuarios.add(new Noob("Maria","maria"));
		usuarios.add(new Noob("Mateus","mateus"));
		usuarios.add(new Veterano("Lais","lais"));
	}

	@Before
	public void setUp(){
		loja = new Loja();
		constroeUsuarios();
		constroeJogos();
	}
	
	@Test
	public void testAdicionaCredito() {
		Usuario usuario1 = usuarios.get(0);
		Usuario usuario2 = usuarios.get(1);
		loja.adicionaUsuario(usuario1);
		loja.adicionaCredito(usuario1.getLogin(), 1999);
		assertEquals(usuario1.getSaldoJogos(), 1999, 0.0001);
		assertNotEquals(usuario2.getSaldoJogos(), 1999, 0.0001);
		//Testa se o efeito está sendo aplicado em todos os usuarios
		
		loja.adicionaCredito(usuario1.getLogin(), -1);
		assertEquals(usuario1.getSaldoJogos(), 1999, 0.0001);
		//Testa se está adicionando saldo incorreto
		
	}

	@Test
	public void testAdicionaUsuario() {
		for(Usuario usuario: usuarios){
			loja.adicionaUsuario(usuario);
		}
		int tamanho = loja.getUsuarios().size();
		loja.adicionaUsuario(usuarios.get(0));
		//Testa se adiciona o mesmo usuario
		assertEquals(tamanho, loja.getUsuarios().size());
		
		
		loja.adicionaUsuario(null);
		//Testa se adiciona o usuario nulo
		assertEquals(tamanho, loja.getUsuarios().size());
		
	}

	@Test
	public void testEncontraUsuario(){
		try {
			Usuario usuario = loja.encontraUsuario("juan");
			fail("Encontrou usuario inexistente");
		} catch (UsuarioDesconhecidoException e) {
			assertEquals("Usuario nao foi reconhecido", e.getMessage());
		}
		//Testa com usuario não existente
		
		loja.adicionaUsuario(usuarios.get(0));
		try {
			Usuario usuario = loja.encontraUsuario("juan");
			assertTrue(usuario.equals(usuarios.get(0)));
		} catch (UsuarioDesconhecidoException e) {
			fail("Não encontrou usuario existente");
		}
		//Testa equalidade dos usuarios
		
		try {
			Usuario usuario = loja.encontraUsuario(null);
			fail("Encontrou com parametro nulo");
		} catch (Exception e) {
		}// Testa com parametro invalido
	}
	
	@Test
	public void testImprimeUsuarios(){
		String LN = System.lineSeparator();
		String result = "=== Central P2-CG ===" + LN;
		assertEquals(result, loja.toString());
		//Testa sem usuario
		
		loja.adicionaUsuario(usuarios.get(0));
		result += usuarios.get(0).toString() + LN;
		assertEquals(result, loja.toString());
		//Testa com usuario
				
	}

	@Test
	public void testUpgrade(){
		Usuario usuario = usuarios.get(0);
		loja.adicionaUsuario(usuario);
		
		try {
			loja.upgradeUsuario(usuario.getLogin());
			fail();
		} catch (UpgradeInvalidoException e) {
			assertEquals("O usuario ja eh veterano ou nao possui pontos suficientes", e.getMessage());
		}// Tenta atualizar sem x2p
		
		
		usuario.setX2p(1100);
		try {
			loja.upgradeUsuario(usuario.getLogin());
		} catch (UpgradeInvalidoException e) {
			fail();
		}
		Usuario novo = null;
		try {
			novo = loja.encontraUsuario(usuario.getLogin());
		} catch (UsuarioDesconhecidoException e) {
			fail(e.getMessage());
		}// Atualiza usuario
		
		assertTrue(novo.getJogos().equals(usuario.getJogos()));
		assertTrue(novo.getNome().equals(usuario.getNome()));
		assertEquals(novo.getSaldoJogos(),usuario.getSaldoJogos(), 0.001);
		assertEquals(novo.getX2p(), usuario.getX2p(), 0.001);
		assertTrue(novo.getClass() == Veterano.class);
		assertEquals(1, loja.getUsuarios().size());
		//Testa atributos se batem
		
		
		try {
			loja.upgradeUsuario(novo.getLogin());
			fail();
		} catch (UpgradeInvalidoException e) {
		}
		//Tenta atualizar usuário já veterano
		
	}
	
	@Test
	public void testVendeJogo() {
		Usuario usuario = usuarios.get(2);
		loja.adicionaUsuario(usuario);
		loja.vendeJogo(usuario.getLogin(), jogos.get(1));
		assertEquals(usuario.getJogos().size(), 0);
		//Tenta vender sem credito
		
		loja.adicionaCredito(usuario.getLogin(), 10000);
		loja.vendeJogo(usuario.getLogin(), jogos.get(1));
		assertEquals(usuario.getJogos().size(), 1);
		//Tenta vender com credito
		
		Usuario novo = usuarios.get(3);
		loja.vendeJogo("invalido", jogos.get(1));
		assertEquals(usuario.getJogos().size(), 1);
		loja.adicionaUsuario(novo);
		loja.adicionaCredito(novo.getLogin(), 10000);
		loja.vendeJogo(novo.getLogin(), jogos.get(1));
		assertEquals(usuario.getJogos().size(), 1);
		assertEquals(novo.getJogos().size(), 1);
		//Certifica que o jogo não foi adicionado em outro usuario
		
		loja.vendeJogo(novo.getLogin(), jogos.get(1));
		assertEquals(novo.getJogos().size(), 1);
		//Certifica que só um jogo foi adicionado naquele usuario
		
		loja.vendeJogo(novo.getLogin(), jogos.get(2));
		loja.vendeJogo(novo.getLogin(), jogos.get(4));
		assertEquals(novo.getJogos().size(), 3);
		//Certifica que o usuario esteja com o numero certo de jogos
	}

}

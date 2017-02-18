package test.centraldejogos.edu.jogo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import centraldejogos.edu.Loja;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class LojaTest {
	private Loja loja;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	
	@Before
	public void setUp(){
		loja = new Loja();
		constroeUsuarios();
		
	}
	
	private void constroeUsuarios(){
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Noob("Juan","juan"));
		usuarios.add(new Veterano("Joao","joao"));
		usuarios.add(new Noob("Maria","maria"));
		usuarios.add(new Noob("Mateus","mateus"));
		usuarios.add(new Veterano("Lais","lais"));
	}

	private void constroeJogos(){
	}
	
	@Test
	public void testAdicionaUsuario() {
		for(Usuario usuario: usuarios){
			loja.adicionaUsuario(usuario);
		}
	}

	@Test
	public void testAdicionaCredito() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testVendeJogo() {
		fail("Not yet implemented"); // TODO
	}

}

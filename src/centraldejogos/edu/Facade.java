package centraldejogos.edu;

import java.util.ArrayList;
import java.util.HashSet;

import centraldejogos.edu.exceptions.LojaException;
import centraldejogos.edu.exceptions.UsuarioDesconhecidoException;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipojogo.TipoJogo;
import centraldejogos.edu.tipousuario.Usuario;

public class Facade {
	private LojaController loja;

	public Facade() {
		loja = new LojaController();
	}

	public void adicionaCredito(String login, double credito) throws LojaException {
		loja.adicionaCredito(login, credito);
	}

	public void adicionaUsuario(String nome, String login) {
		loja.adicionaUsuario(nome, login);
	}

	public Usuario encontraUsuario(String login) throws UsuarioDesconhecidoException {
		return loja.encontraUsuario(login);
	}

	public void imprimeUsuarios() {
		loja.imprimeUsuarios();
	}

	public void upgradeUsuario(String login) throws LojaException {
		loja.upgradeUsuario(login);
	}

	public void vendeJogo(String login, String nome, double preco, HashSet<Jogabilidade> estilos, TipoJogo tipo)
			throws LojaException {
		loja.vendeJogo(login, nome, preco, estilos, tipo);
	}

	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> estilos, TipoJogo tipo) {
		return loja.criaJogo(nome, preco, estilos, tipo);
	}

}

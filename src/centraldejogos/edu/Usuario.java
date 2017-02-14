package centraldejogos.edu;

import java.util.ArrayList;
import java.util.HashSet;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Perfil;

public class Usuario {
	
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogos;
	protected double saldoJogos;
	protected Perfil tipo;
	protected int x2p;

	/**
	 * Cria um novo usuário recebendo como atributo o seu nome e login.
	 * É inicializado uma lista vazia de jogos, o saldo vazio para compra de
	 * jogos, o tipo é inicializado com Noob e a pontuação inicial é 0.
	 * @param nome
	 */
	public Usuario(String nome, String login) {
		if (nome == null){
			throw new NullPointerException("Nome nao pode ser nulo");
		}
		if (nome.trim().equals("")){
			throw new ParametroInvalidoException("Nome inválido");
		}
		if (login == null){
			throw new NullPointerException("Login nao pode ser nulo");
		}
		if (login.trim().equals("")){
			throw new ParametroInvalidoException("Login inválido");
		}
		
		this.nome = nome;
		this.login = login;
		jogos = new ArrayList<Jogo>();
		tipo = new Noob();
		x2p = 0;
	}

	public void compraJogo(Jogo jogo){
		x2p += 
	}
}

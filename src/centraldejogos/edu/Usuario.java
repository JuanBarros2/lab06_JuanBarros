package centraldejogos.edu;

import java.util.HashSet;

import centraldejogos.edu.jogo.Jogo;

public class Usuario {
	
	protected String nome;
	protected String login;
	protected HashSet<Jogo> jogos;
	protected double saldoJogos;

	public Usuario(String nome) {
		this.nome = nome;
		jogos = new HashSet<Jogo>();
	}

}

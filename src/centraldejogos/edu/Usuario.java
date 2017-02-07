package centraldejogos.edu;

import java.util.HashSet;

import centraldejogos.edu.jogo.Jogo;

public abstract class Usuario {
	private String nome;
	private HashSet<Jogo> jogos;
	private double saldoJogos;

	public Usuario(String nome) {
		this.nome = nome;
		jogos = new HashSet<Jogo>();
	}
	
	public abstract void login();
	
	public abstract double calculaDesconto();

}

package centraldejogos.edu;

import java.util.ArrayList;
import java.util.HashSet;

import centraldejogos.edu.jogo.Jogo;
import centraldejogos.edu.tipousuario.PerfilFinanceiro;

public class Usuario {
	
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogos;
	protected double saldoJogos;
	protected PerfilFinanceiro tipo;

	public Usuario(String nome) {
		this.nome = nome;
		jogos = new HashSet<Jogo>();
	}

}

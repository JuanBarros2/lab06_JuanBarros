package centraldejogos.edu.jogo;

import java.util.HashSet;

/**
 * @author juanvlbb
 */
public class Jogo {
	private String nome;
	private double preco;
	private int pontuacao;
	private int quantJogadas;
	private int vezesConcluidas;
	private HashSet<Jogabilidade> estilos;
	
	/**
	 * Controi um objeto Jogo recebendo como parâmetros os valores do seu nome e preço.
	 * @param nome 
	 * @param preco
	 */
	public Jogo(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
		pontuacao = 0;
		quantJogadas = 0;
		vezesConcluidas = 0;
		estilos = new HashSet<Jogabilidade>();
	}
	
	/**
	 * Registra avanços em pontuação e registra zeramento de jogo.
	 * @param jogada
	 * @param zerou
	 * @return
	 */
	public int registraJogada(int jogada, boolean zerou){
		if (jogada > pontuacao){
			pontuacao = jogada;
		}
		if (zerou){
			vezesConcluidas++;
		}
		return 0;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getQuant_jogadas() {
		return quantJogadas;
	}

	public int getZerou() {
		return vezesConcluidas;
	}
	
	

}

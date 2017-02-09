package centraldejogos.edu.jogo;

import java.util.HashSet;

import centraldejogos.edu.exceptions.ParametroInvalidoException;

/**
 * @author juanvlbb
 */
public class Jogo {
	
	protected String nome;
	protected double preco;
	protected int pontuacao;
	protected int quantJogadas;
	protected int vezesConcluidas;
	protected HashSet<Jogabilidade> estilos;
	
	/**
	 * Controi um objeto Jogo recebendo como parametros os valores do seu nome e preco.
	 * @param nome 
	 * @param preco
	 */
	public Jogo(String nome, double preco){
		super();
		if (nome == null){
			throw new NullPointerException("O nome nao pode ser nulo");
		}
		if (nome.trim().equals("")){
			throw new ParametroInvalidoException("O nome nao pode estar vazio");
		}
		if (preco < 0){
			throw new ParametroInvalidoException("Preco nao pode ser repetido");
		}
		this.nome = nome;
		this.preco = preco;
		pontuacao = 0;
		quantJogadas = 0;
		vezesConcluidas = 0;
		estilos = new HashSet<Jogabilidade>();
	}
	
	/**
	 * Registra avancos em pontuacao e registra zeramento de jogo.
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

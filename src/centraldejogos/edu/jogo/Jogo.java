package centraldejogos.edu.jogo;

import java.util.HashSet;

import centraldejogos.edu.Produto;
import centraldejogos.edu.exceptions.ParametroInvalidoException;

/**
 * Representação de um Jogo eletrônico. Um Jogo é um filho de {@link Produto}
 * que é uma abstração de algo que pode ser comprado. Um jogo, além de ser um 
 * produto, ele tem comportamentos específicos para manipular pontuação e informações
 * próprias.
 * @author Juan
 */
public class Jogo extends Produto{
	protected int pontuacao;
	protected int quantJogadas;
	protected int vezesConcluidas;
	protected HashSet<Jogabilidade> estilos;
	
	/**
	 * Inicializa os parâmetros iniciais de jogo. Aceita os parametros nome e preco do jogo.
	 * @param nome 
	 * @param preco
	 */
	public Jogo(String nome, double preco){
		super(nome, preco);
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

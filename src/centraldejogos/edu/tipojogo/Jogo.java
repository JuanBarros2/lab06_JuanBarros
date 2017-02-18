package centraldejogos.edu.tipojogo;

import java.util.HashSet;

import centraldejogos.edu.Jogabilidade;
import centraldejogos.edu.exceptions.ParametroInvalidoException;

/**
 * @author Juan
 */
public abstract class Jogo{
	protected String nome;
	protected double preco;
	protected int pontuacao;
	protected int quantJogadas;
	protected int vezesConcluidas;
	protected HashSet<Jogabilidade> estilos;
	
	/**
	 * Inicializa o jogo com um nome e preço passado como parâmetro. É inicializado também
	 * a quantidade de vezes jogadas, as vezes que foi concluído o jogo e um conjunto vazio 
	 * com os possíveis estilos do jogo.
	 * 
	 * @param nome - É verificado se o parâmetro é nulo ou vazio
	 * @param preco - É verificado se é menor que 0
	 */
	public Jogo(String nome, double preco){
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
	 * Registra uma jogada do jogo. Uma jogada pode ser um batimento de record ou
	 * conclusão de jogo.
	 * @param pontuacao - valor referente ao score obtido no jogo.
	 * @param concluiu - valor que informa se foi zerado o jogo.
	 * @return x2p calculado de acordo com o tipo específico do jogo.
	 */
	public abstract int registraJogada(int pontuacao, boolean concluiu);
		
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

	public int getVezesConcluidas() {
		return vezesConcluidas;
	}

}

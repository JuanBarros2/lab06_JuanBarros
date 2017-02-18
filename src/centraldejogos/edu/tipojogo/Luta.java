package centraldejogos.edu.tipojogo;

import centraldejogos.edu.exceptions.ParametroInvalidoException;

public class Luta extends Jogo{
	//Representa a pontuação máxima que pode ser alcançada
	private final int MAX = 100000;
	private int x2p;

	public Luta(String nome, double preco) {
		super(nome, preco);
		x2p = 0;
	}

	@Override
	public int registraJogada(int pontuacao, boolean concluiu){
		quantJogadas++;
		if (pontuacao < 0 || pontuacao > MAX){
			throw new ParametroInvalidoException();
		}
		if (this.pontuacao < pontuacao){
			x2p += (int)(pontuacao - this.pontuacao)/1000 ;
			this.pontuacao = pontuacao;
		}
		if (concluiu){
			vezesConcluidas++;
		}
		return x2p;
	}

}

package centraldejogos.edu.tipojogo;

import centraldejogos.edu.exceptions.ParametroInvalidoException;

public class Luta extends Jogo{
	//Representa a pontuação máxima que pode ser alcançada
	private final int MAX = 100000;

	public Luta(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean concluiu){
		int x2p = 0;
		if (pontuacao < 0 || pontuacao > MAX){
			throw new ParametroInvalidoException();
		}
		if (this.pontuacao < pontuacao){
			x2p = (int) pontuacao / 1000 ;
			this.pontuacao = pontuacao;
		}
		if (concluiu){
			vezesConcluidas++;
		}
		quantJogadas++;
		return x2p;
	}

	@Override
	public String toString() {
		String ln = System.lineSeparator();
		return nome + " - Luta:" + ln
				+ "==> Jogou " + quantJogadas + " vez(es)" + ln
				+ "==> Zerou " + vezesConcluidas + " vez(es)" + ln
				+ "==> Maior score: " + pontuacao;
	}
	

}

package centraldejogos.edu.tipojogo;

import centraldejogos.edu.exceptions.ParametroInvalidoException;

public class Plataforma extends Jogo {
	// Representa o valor a ser multiplicado pelas vezes concluídas
	private final int PONT = 20;

	public Plataforma(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean concluiu) {
		if (pontuacao < 0 ){
			throw new ParametroInvalidoException();
		}
		if (this.pontuacao < pontuacao){
			this.pontuacao = pontuacao;
		}
		if (concluiu){
			vezesConcluidas++;
		}
		quantJogadas++;
		return (vezesConcluidas) * PONT;
	}
	
	@Override
	public String toString() {
		String ln = System.lineSeparator();
		return nome + " - Plataforma:" + ln
				+ "==> Jogou " + quantJogadas + " vez(es)" + ln
				+ "==> Zerou " + vezesConcluidas + " vez(es)" + ln
				+ "==> Maior score: " + pontuacao;
	}

}

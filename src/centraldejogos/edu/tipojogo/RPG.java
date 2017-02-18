package centraldejogos.edu.tipojogo;

import centraldejogos.edu.exceptions.ParametroInvalidoException;

public class RPG extends Jogo{
	
	//Quantidade que multiplica a quantidade de jogadas para geração do X2P
	private final int PONT = 10;

	public RPG(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean concluiu){
		
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
		return quantJogadas * PONT;
	}
	
	@Override
	public String toString() {
		String ln = System.lineSeparator();
		return nome + " - RPG:" + ln
				+ "==> Jogou " + quantJogadas + " vez(es)" + ln
				+ "==> Zerou " + vezesConcluidas + " vez(es)" + ln
				+ "==> Maior score: " + pontuacao;
	}

}

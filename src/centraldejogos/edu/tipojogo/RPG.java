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
		quantJogadas++;
		if (pontuacao < 0 ){
			throw new ParametroInvalidoException();
		}
		if (this.pontuacao < pontuacao){
			this.pontuacao = pontuacao;
		}
		if (concluiu){
			vezesConcluidas++;
		}
		return quantJogadas * PONT;
	}

}

package centraldejogos.edu.tipousuario;

import centraldejogos.edu.Jogabilidade;
import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.Jogo;

public class Veterano implements TipoDeUsuarioIF {

	@Override
	public int getDesconto() {
		return 20;
	}

	@Override
	public int getDeltaX2P() {
		return 15;
	}


	@Override
	public boolean upgrade(int x2p) {
		return false;
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int x2p = jogo.registraJogada(scoreObtido, zerou);
		if (jogo.getEstilos().contains(Jogabilidade.OFFLINE)) {
			x2p -= 20;
		}
		if (jogo.getEstilos().contains(Jogabilidade.COMPETITIVO)) {
			x2p -= 20;
		}

		return x2p;
	}

	@Override
	public int recompensar(Jogo jogo, int score, boolean zerou) {
		int x2p = jogo.registraJogada(score, zerou);
		if (jogo.getEstilos().contains(Jogabilidade.ONLINE)) {
			x2p += 10;
		}
		if (jogo.getEstilos().contains(Jogabilidade.COOPERATIVO)) {
			x2p += 20;
		}

		return x2p;
	}
	
	@Override
	public String toString(){
		return "Veterano";
	}

}

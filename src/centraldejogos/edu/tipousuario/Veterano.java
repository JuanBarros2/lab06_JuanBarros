package centraldejogos.edu.tipousuario;

import centraldejogos.edu.Jogabilidade;
import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.Jogo;

public class Veterano extends Usuario{

	public Veterano(String nome, String login) {
		super(nome, login);
		x2p = 1000;
	}

	@Override
	public void upgrade() throws UpgradeInvalidoException {
		throw new UpgradeInvalidoException();
	}

	@Override
	public int getDesconto() {
		return 20;
	}

	@Override
	public int getDeltaX2P() {
		return 15;
	}

	@Override
	public void recompensar(String nomeDoJogo, int score, boolean zerou) throws JogoNaoEncontradoException {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equals(nomeDoJogo)) {
				x2p += jogo.registraJogada(score, zerou);
				if (jogo.getEstilos().contains(Jogabilidade.ONLINE)){
					x2p += 10;
				}
				if (jogo.getEstilos().contains(Jogabilidade.COOPERATIVO)){
					x2p += 20;
				}
				return;
			}
		}
		throw new JogoNaoEncontradoException();
	}

	@Override
	public void pubir(String nomeJogo, int scoreObtido, boolean zerou) throws JogoNaoEncontradoException {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equals(nomeJogo)) {
				x2p += jogo.registraJogada(scoreObtido, zerou);
				if (jogo.getEstilos().contains(Jogabilidade.OFFLINE)) {
					x2p -= 20;
				}
				if (jogo.getEstilos().contains(Jogabilidade.COMPETITIVO)) {
					x2p -= 20;
				}
				return;
			}
		}
		throw new JogoNaoEncontradoException();
	}

}

package centraldejogos.edu.tipousuario;

import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.SaldoInsuficienteException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.Jogo;

public interface TipoDeUsuarioIF {
	public boolean upgrade(int x2p);
	public int punir(Jogo jogo, int scoreObtido, boolean zerou);
	public int recompensar(Jogo jogo, int score, boolean zerou);
	public String toString();
	/**
	 * Retorna o percentual de desconto que o usuário tem.
	 * @return
	 */
	public int getDesconto();
	/**
	 * Retorna o delta que indica a quantidade de pontos que o usuário ganha
	 * ao comprar um jogo.
	 * @return
	 */
	public int getDeltaX2P();
}

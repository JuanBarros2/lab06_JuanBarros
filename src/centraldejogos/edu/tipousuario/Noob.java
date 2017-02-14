package centraldejogos.edu.tipousuario;

public class Noob extends Perfil{
	
	/**
	 * Representa a porcentagem de desconto que aquele perfil apresenta
	 */
	private final int DESCONTO = 10;

	@Override
	public double calculaDesconto(double preco) {
		preco = (preco / 100) * DESCONTO;
		return preco;
	}
	
}

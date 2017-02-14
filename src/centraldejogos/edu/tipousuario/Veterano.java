package centraldejogos.edu.tipousuario;

public class Veterano extends Perfil{

	/**
	 * Representa a porcentagem de desconto que aquele perfil apresenta
	 */
	private final int DESCONTO = 20;

	@Override
	public double calculaDesconto(double preco) {
		preco = (preco / 100) * DESCONTO;
		return preco;
	}

}

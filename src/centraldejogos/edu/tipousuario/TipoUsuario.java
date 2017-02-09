package centraldejogos.edu.tipousuario;

public abstract class TipoUsuario {
	
	protected int desconto;
	
	/**
	 * Recebe um valor em real representando o valor do preco. De acordo com seu atributo
	 * desconto, eh calculado o valor a ser reduzido desse preco inicial.
	 * @param preco - Valor em double do preco
	 * @return - Valor a ser reduzido
	 */
	public abstract double calculaDesconto(double preco);

}

package centraldejogos.edu.tipousuario;

/**
 * Guardar� informa��es financeiras e 
 * @author Juan
 *
 */
public abstract class Perfil {

	/**
	 * Recebe um valor em real representando o valor do preco. 
	 * � calculado o valor a ser reduzido desse preco inicial.
	 * @param preco - Valor em double do preco
	 * @return - Valor a ser reduzido
	 */
	public abstract double calculaDesconto(double preco);

}

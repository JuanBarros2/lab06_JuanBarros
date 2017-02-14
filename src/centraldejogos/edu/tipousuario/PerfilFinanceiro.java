package centraldejogos.edu.tipousuario;

/**
 * Guardará informações financeiras e 
 * @author Juan
 *
 */
public abstract class PerfilFinanceiro {

	/**
	 * Recebe um valor em real representando o valor do preco. 
	 * É calculado o valor a ser reduzido desse preco inicial.
	 * @param preco - Valor em double do preco
	 * @return - Valor a ser reduzido
	 */
	public abstract double calculaDesconto(double preco);

}

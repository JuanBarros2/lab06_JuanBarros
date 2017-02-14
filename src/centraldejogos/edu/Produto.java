package centraldejogos.edu;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
/**
 * Representa uma entidade que pode ser comprada. Nela encontraremos informações
 * específicas de compra e venda.
 * @author Juan
 *
 */
public class Produto {
	protected String nome;
	protected double preco;
	
	public Produto(String nome, double preco) {
		if (nome == null){
			throw new NullPointerException("O nome nao pode ser nulo");
		}
		if (nome.trim().equals("")){
			throw new ParametroInvalidoException("O nome nao pode estar vazio");
		}
		if (preco < 0){
			throw new ParametroInvalidoException("Preco nao pode ser repetido");
		}
		this.nome = nome;
		this.preco = preco;
	}

}

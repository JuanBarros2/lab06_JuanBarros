package centraldejogos.edu.tipousuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;

import centraldejogos.edu.exceptions.JogoNaoEncontradoException;
import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.exceptions.SaldoInsuficienteException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.tipojogo.Jogo;

public abstract class Usuario {
	private String nome;
	private String login;
	private ArrayList<Jogo> jogos;
	private double saldoJogos;
	protected int x2p;

	/**
	 * Cria um novo usuário recebendo como atributo o seu nome e login.
	 * É inicializado uma lista vazia de jogos, o saldo vazio para compra de
	 * jogos, o tipo é inicializado com Noob e a pontuação inicial é 0.
	 * @param nome
	 */
	public Usuario(String nome, String login) {
		if (nome == null){
			throw new NullPointerException("Nome nao pode ser nulo");
		}
		if (nome.trim().equals("")){
			throw new ParametroInvalidoException("Nome invalido");
		}
		if (login == null){
			throw new NullPointerException("Login nao pode ser nulo");
		}
		if (login.trim().equals("")){
			throw new ParametroInvalidoException("Login invalido");
		}
		this.nome = nome;
		this.login = login;
		jogos = new ArrayList<Jogo>();
	}

	public abstract void upgrade() throws UpgradeInvalidoException;

	@Override
	public String toString() {
		String ln = System.lineSeparator();
		
		//Otimiza a indezação de novas posições na String
		StringBuilder result = new StringBuilder();
		result.append(login + ln + nome + " - Jogador " + (this.getClass() == Noob.class ? "Noob" : "Veterano")
				+ ln + "Lista de Jogos:");
		double gasto = 0;
		for (Jogo jogo : jogos) {
			result.append(" + " + jogo + ln);
			gasto += jogo.getPreco();
		}
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		result.append("Total de preco dos jogos: " + nf.format(gasto) + ln);
		result.append("--------------------------------------------");
		return result.toString();
	}

	/**
	 * Recebe um preço e calcula o seu valor retirado o desconto.
	 * A variável desconto é utilizada para abater o resultado e é inicializada
	 * nas classes filhas de Usuario.
	 * @param preco - Valor a ser calculado desconto
	 * @return preço aplicado ao desconto
	 */
	private double calculaPreco(double preco) {
		preco = preco - ((preco / 100) * getDesconto());
		return preco;
	}
	
	/**
	 * Adquire uma cópia do jogo passado como parâmetro. Para realizar
	 * a compra o usuário precisa tem crédito suficiente para compra-lo.
	 * Além disso, jogos que já foram comprados não podem ser comprados 
	 * novamente.
	 * @param jogo
	 * @throws SaldoInsuficienteException
	 */
	public void compraJogo(Jogo jogo) throws SaldoInsuficienteException{
		if (jogo == null){
			throw new NullPointerException("Jogo nao pode ser nulo");
		}
		if (jogos.contains(jogo)){
			throw new ParametroInvalidoException("Jogo ja adicionado ao usuario");
		}
		double valorTotal = calculaPreco(jogo.getPreco());
		if (saldoJogos < valorTotal){
			throw new SaldoInsuficienteException();
		}
		x2p += (int)(getDeltaX2P() * jogo.getPreco());
		jogos.add(jogo);
		saldoJogos -= valorTotal;
	}
	
	/**
	 * Retorna o percentual de desconto que o usuário tem.
	 * @return
	 */
	public abstract int getDesconto();
	
	/**
	 * Retorna o delta que indica a quantidade de pontos que o usuário ganha
	 * ao comprar um jogo.
	 * @return
	 */
	public abstract int getDeltaX2P();
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws JogoNaoEncontradoException{
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equals(nomeDoJogo)){
				x2p += jogo.registraJogada(score, zerou);
				return;
			}
		}
		throw new JogoNaoEncontradoException();
	}
	
	/**
	 * Adiciona uma quantidade de créditos que poderá ser usado na compra de
	 * jogos. 
	 * @param credito - valor em double maior que 0.
	 */
	public void adicionaCredito(double credito) {
		if (credito <= 0){
			throw new ParametroInvalidoException("Credito nao pode ser negativo");
		}
		saldoJogos += credito;		
	}


	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public double getSaldoJogos() {
		return saldoJogos;
	}

	public int getX2p() {
		return x2p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*Nesse caso, usei o instanceof pois não pode haver repetições na minha
		 * lista de usuários. Dessa forma, não podemos ter um usuario noob e veterano
		 * com o mesmo login.
		 */
		if (!(this instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSaldoJogos(double saldoJogos) {
		this.saldoJogos = saldoJogos;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
}

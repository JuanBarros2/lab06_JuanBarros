package centraldejogos.edu;

import java.util.ArrayList;
import java.util.HashSet;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.Perfil;

public abstract class Usuario {
	protected int desconto;
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogos;
	protected double saldoJogos;
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
	
	public double calculaDesconto(double preco) {
		preco = (preco / 100) * desconto;
		return preco;
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
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public void compraJogo(Jogo jogo){
	}

	public void adicionaCredito(double credito) {
		saldoJogos += credito;		
	}
}

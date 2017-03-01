package centraldejogos.edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import centraldejogos.edu.exceptions.LojaException;
import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.exceptions.SaldoInsuficienteException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.exceptions.UsuarioDesconhecidoException;
import centraldejogos.edu.factory.JogoFactory;
import centraldejogos.edu.factory.UsuarioFactory;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipojogo.TipoJogo;
import centraldejogos.edu.tipousuario.TipoUsuarioEnum;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class LojaController {
	private final String LN = System.lineSeparator();
	private ArrayList<Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private JogoFactory jogoFabrica; 
	private UsuarioFactory usuarioFabrica;
	
	public LojaController(){
		usuarios = new ArrayList<Usuario>();
		jogoFabrica = new JogoFactory();
		usuarioFabrica = new UsuarioFactory();
		jogos = new ArrayList<Jogo>();
	}
	
	/**
	 * Adiciona uma quantidade de crédito em um dado usuário.
	 * É pesquisado na lista de usuários aquele que tiver o login igual ao
	 * passado como parâmetro. Se encontrado, esse usuário recebe os créditos
	 * que podem ser gastos na compra de jogos.
	 * @param login - identificador do usuário
	 * @param credito - valor a ser adicionado
	 * @throws LojaException 
	 */
	public void adicionaCredito(String login, double credito) throws LojaException{
		Usuario usuario = null;
		try {
			usuario = encontraUsuario(login);
			usuario.adicionaCredito(credito);
		} catch (UsuarioDesconhecidoException | ParametroInvalidoException e) {
			throw new LojaException(e.getMessage(), e);
		}
		
	}
	
	/**
	 * Recebe um usuário e o adiciona a lista de usuários válidos.
	 * Se o usuário já estiver na lista, a ação é desconsiderada.
	 * @param usuario
	 */
	public void adicionaUsuario(String nome, String login){
		Usuario usuario = usuarioFabrica.criaUsuario(nome, login, TipoUsuarioEnum.NOOB);
		if (usuarios.contains(usuario)){
			System.out.println("Ja existe um usuario com essas caracteristicas");
			return;
		}
		usuarios.add(usuario);
	}	
	
	/**
	 * Encontra um usuário na lista de usuários disponíveis de acordo com o login passado.
	 * @param login - identificador do usuario
	 * @return O usuário encontrado
	 * @throws UsuarioDesconhecidoException Se o usuário não for encontrado, é lançado essa exception
	 */
	public Usuario encontraUsuario(String login) throws UsuarioDesconhecidoException{
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)){
				return usuario;
			}
		}
		throw new UsuarioDesconhecidoException();
	}

	/**
	 * Imprime as informações de todos os usuários e seus jogos.
	 */
	public void imprimeUsuarios(){
		System.out.println(this.toString());
	}

	public void upgradeUsuario(String login) throws LojaException{
		try {
			Usuario usuario = encontraUsuario(login);
			usuario.upgrade();
		} catch (UsuarioDesconhecidoException | UpgradeInvalidoException e) {
			throw new LojaException(e.getMessage(), e);
		}
	}

	public void vendeJogo(String login, String nome, double preco, HashSet<Jogabilidade> estilos, TipoJogo tipo) throws LojaException{
		Jogo jogo = jogoFabrica.criaJogo(nome, preco, estilos, tipo);
		try {
			Usuario usuario = encontraUsuario(login);
			usuario.compraJogo(jogo);
		} catch (UsuarioDesconhecidoException | SaldoInsuficienteException | ParametroInvalidoException e) {
			throw new LojaException(e.getMessage(), e);
		}
	}
	
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> estilos, TipoJogo tipo){
		return jogoFabrica.criaJogo(nome, preco, estilos, tipo);
	}
	
 	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("=== Central P2-CG ===" + LN );
		
		Iterator<Usuario> iterator = usuarios.iterator();
		while (iterator.hasNext()) {
			Usuario usuario = (Usuario) iterator.next();
			result.append(usuario + LN);
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		LojaController other = (LojaController) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
}

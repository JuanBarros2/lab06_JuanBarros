package centraldejogos.edu;

import java.util.ArrayList;
import java.util.Iterator;

import centraldejogos.edu.exceptions.ParametroInvalidoException;
import centraldejogos.edu.exceptions.SaldoInsuficienteException;
import centraldejogos.edu.exceptions.UpgradeInvalidoException;
import centraldejogos.edu.exceptions.UsuarioDesconhecidoException;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class Loja {
	private final String LN = System.lineSeparator();
	private ArrayList<Usuario> usuarios;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
	}
	
	/**
	 * Adiciona uma quantidade de crédito em um dado usuário.
	 * É pesquisado na lista de usuários aquele que tiver o login igual ao
	 * passado como parâmetro. Se encontrado, esse usuário recebe os créditos
	 * que podem ser gastos na compra de jogos.
	 * @param login - identificador do usuário
	 * @param credito - valor a ser adicionado
	 */
	public void adicionaCredito(String login, double credito){
		Usuario usuario = null;
		try {
			usuario = encontraUsuario(login);
			usuario.adicionaCredito(credito);
		} catch (UsuarioDesconhecidoException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Recebe um usuário e o adiciona a lista de usuários válidos.
	 * Se o usuário já estiver na lista, a ação é desconsiderada.
	 * @param usuario
	 */
	public void adicionaUsuario(Usuario usuario){
		if (usuario == null){
			System.out.println("Erro: usuario nulo.");
			return;
		}
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
	

	public void upgradeUsuario(String login) throws UpgradeInvalidoException{
		try {
			Usuario usuario = encontraUsuario(login);
			usuario.upgrade();
			Veterano novo = new Veterano(usuario.getNome(), usuario.getLogin());
			novo.setJogos(usuario.getJogos());
			novo.setSaldoJogos(usuario.getSaldoJogos());
			novo.setX2p(usuario.getX2p());
			usuarios.remove(usuario);
			usuarios.add(novo);
		} catch (UsuarioDesconhecidoException  e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void vendeJogo(String login, Jogo jogo){
		try {
			Usuario usuario = encontraUsuario(login);
			usuario.compraJogo(jogo);
		} catch (UsuarioDesconhecidoException | SaldoInsuficienteException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}
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
}

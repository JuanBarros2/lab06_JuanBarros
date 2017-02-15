package centraldejogos.edu;

import java.util.ArrayList;

import centraldejogos.edu.exceptions.UsuarioDesconhecidoException;

public class Loja {
	private ArrayList<Usuario> usuarios;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
	}
	
	public void adicionaUsuario(Usuario usuario){
		if (usuarios.contains(usuario)){
			System.out.println("Ja existe um usuario com essas caracteristicas");
		}
		usuarios.add(usuario);
	}
	
	public void adicionaCredito(String login, double credito){
		Usuario usuario = null;
		try {
			usuario = encontraUsuario(login);
			usuario.adicionaCredito(credito);
		} catch (UsuarioDesconhecidoException e) {
			
		}
		
	}
	
	private Usuario encontraUsuario(String login) throws UsuarioDesconhecidoException{
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)){
				return usuario;
			}
		}
		throw new UsuarioDesconhecidoException();
	}

	public void vendeJogo(){
		
	}
}

package centraldejogos.edu.factory;

import centraldejogos.edu.tipojogo.TipoJogo;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.TipoUsuario;
import centraldejogos.edu.tipousuario.Usuario;

public class UsuarioFactory {
	
	public Usuario criaUsuario(String nome, String login, TipoUsuario tipo){
		Usuario usuario = null; 
		switch (tipo) {
			case NOOB:
				usuario = new Noob(nome, login);
				break;
			case VETERANO:
				//TODO
				break;

		}
		
		return usuario;
	}

}

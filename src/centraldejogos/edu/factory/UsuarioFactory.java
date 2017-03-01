package centraldejogos.edu.factory;

import centraldejogos.edu.tipojogo.TipoJogo;
import centraldejogos.edu.tipousuario.Noob;
import centraldejogos.edu.tipousuario.TipoUsuarioEnum;
import centraldejogos.edu.tipousuario.Usuario;
import centraldejogos.edu.tipousuario.Veterano;

public class UsuarioFactory {
	
	public Usuario criaUsuario(String nome, String login, TipoUsuarioEnum tipo){
		Usuario usuario = null; 
		switch (tipo) {
			case NOOB:
				usuario = new Usuario(nome, login, new Noob());
				break;
			case VETERANO:
				usuario = new Usuario(nome, login, new Veterano());
				break;

		}
		
		return usuario;
	}

}

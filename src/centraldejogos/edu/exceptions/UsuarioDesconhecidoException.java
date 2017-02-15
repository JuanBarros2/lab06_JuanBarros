package centraldejogos.edu.exceptions;

public class UsuarioDesconhecidoException extends Exception {

	public UsuarioDesconhecidoException(){
		super("Usuario nao foi reconhecido");
	}
}

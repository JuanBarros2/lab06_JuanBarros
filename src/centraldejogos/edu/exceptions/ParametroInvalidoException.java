package centraldejogos.edu.exceptions;

public class ParametroInvalidoException extends RuntimeException{

	public ParametroInvalidoException(){
		super("Parametro invalido");
	}
	
	public ParametroInvalidoException(String mensagem){
		super(mensagem);
	}
}

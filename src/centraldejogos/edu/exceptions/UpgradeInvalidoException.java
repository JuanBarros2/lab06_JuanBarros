package centraldejogos.edu.exceptions;

public class UpgradeInvalidoException extends Exception{
	public UpgradeInvalidoException(){
		super("O usuario ja eh veterano ou nao possui pontos suficientes");
	}
}

package centraldejogos.edu.tipousuario;

import centraldejogos.edu.exceptions.UpgradeInvalidoException;

public class Noob extends Usuario {
	
	public Noob(String nome, String login) {
		super(nome, login);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upgrade() throws UpgradeInvalidoException {
		if (x2p < 1000){
			throw new UpgradeInvalidoException();
		}
	}
}

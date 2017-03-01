package centraldejogos.edu.tipousuario;

import centraldejogos.edu.exceptions.UpgradeInvalidoException;

public class Noob extends Usuario {
	
	public Noob(String nome, String login) {
		super(nome, login);
	}

	@Override
	public void upgrade() throws UpgradeInvalidoException {
		if (x2p < 1000){
			throw new UpgradeInvalidoException();
		}
	}

	@Override
	public int getDesconto() {
		return 10;
	}

	@Override
	public int getDeltaX2P() {
		return 10;
	}
}

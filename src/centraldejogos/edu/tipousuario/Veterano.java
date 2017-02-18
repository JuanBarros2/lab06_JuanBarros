package centraldejogos.edu.tipousuario;

import centraldejogos.edu.exceptions.UpgradeInvalidoException;

public class Veterano extends Usuario{

	public Veterano(String nome, String login) {
		super(nome, login);
	}

	@Override
	public void upgrade() throws UpgradeInvalidoException {
		throw new UpgradeInvalidoException();
	}

	@Override
	public int getDesconto() {
		return 20;
	}

	@Override
	public int getDeltaX2P() {
		return 15;
	}

}

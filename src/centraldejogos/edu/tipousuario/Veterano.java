package centraldejogos.edu.tipousuario;

import centraldejogos.edu.Usuario;

public class Veterano extends Usuario{
	public Veterano(String nome, String login) {
		super(nome, login);
		x2p = 1000;
		desconto = 15;
	}	

}

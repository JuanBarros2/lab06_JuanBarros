package centraldejogos.edu.factory;

import java.util.HashSet;

import centraldejogos.edu.Jogabilidade;
import centraldejogos.edu.tipojogo.Jogo;
import centraldejogos.edu.tipojogo.Luta;
import centraldejogos.edu.tipojogo.Plataforma;
import centraldejogos.edu.tipojogo.RPG;
import centraldejogos.edu.tipojogo.TipoJogo;

public class JogoFactory {
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> estilos, TipoJogo tipo) {
		Jogo jogo = null;

		switch (tipo) {
		case RPG:
			jogo = criaJogoRPG(nome, preco, estilos);
			break;
		case LUTA:
			jogo = criaJogoLuta(nome, preco, estilos);
			break;
		case PLATAFORMA:
			jogo = criaJogoPlataforma(nome, preco, estilos);
			break;
		}
		return jogo;
	}

	private Plataforma criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> estilos) {
		return new Plataforma(nome, preco, estilos);
	}

	private Luta criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> estilos) {
		return new Luta(nome, preco, estilos);
	}

	private RPG criaJogoRPG(String nome, double preco, HashSet<Jogabilidade> estilos){
		return new RPG(nome, preco, estilos);
	}
}

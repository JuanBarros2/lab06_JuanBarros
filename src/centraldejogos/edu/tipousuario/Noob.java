package centraldejogos.edu.tipousuario;

public class Noob extends TipoUsuario{

	@Override
	public double calculaDesconto(double preco) {
		preco = (preco / 100) * desconto;
		return preco;
	}
	
}

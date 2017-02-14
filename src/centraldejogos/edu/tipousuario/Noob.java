package centraldejogos.edu.tipousuario;

public class Noob extends PerfilFinanceiro{
	

	@Override
	public double calculaDesconto(double preco) {
		preco = (preco / 100);
		return preco;
	}
	
}

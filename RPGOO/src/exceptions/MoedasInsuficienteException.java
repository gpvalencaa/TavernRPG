package exceptions;

public class MoedasInsuficienteException extends Exception{
	private static String message = "Moedas insuficientes";
	public MoedasInsuficienteException(){
		super(message);
	}

}

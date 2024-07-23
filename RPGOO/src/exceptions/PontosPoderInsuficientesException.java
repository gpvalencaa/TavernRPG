package exceptions;

public class PontosPoderInsuficientesException extends Exception{
	private static String message = "Pontos de poder insuficientes";
	public PontosPoderInsuficientesException(){
		super(message);
	}
	

}

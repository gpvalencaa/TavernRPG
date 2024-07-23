package exceptions;

public class InventarioCheioException extends Exception{
	static String message = "Impossível, inventário cheio";
	public InventarioCheioException() {
		super(message);
	}
	

}

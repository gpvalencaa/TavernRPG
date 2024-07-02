package exceptions;

public class DanoNegativoException extends Exception{
			private static String message = "Dano negativo";
			public DanoNegativoException() {
				super(message);
			}
}

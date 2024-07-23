package exceptions;

public class ClasseNaoEscolhidaException extends Exception{
	static String message = "Classe não escolhida";
		public ClasseNaoEscolhidaException() {
			super(message);
		}

}

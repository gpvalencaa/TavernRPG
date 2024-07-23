package cenarios;

import jplay.Window;
import seres.Jogador;

public class Cenario3 extends Cenario{
	public Cenario3(Window janela, Jogador personagemPrincipal) {
		super(janela, "Cenario3.scn", personagemPrincipal);
		System.out.println("Entrou no cenário 3");
	}
}
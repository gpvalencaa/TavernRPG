package cenarios;

import jplay.Window;
import seres.Jogador;

public class Cenario2 extends Cenario{
	public Cenario2(Window janela, Jogador personagemPrincipal) {
		super(janela, "Cenario2.scn", personagemPrincipal);
		System.out.println("Entrou no cenário 2");
	}
}

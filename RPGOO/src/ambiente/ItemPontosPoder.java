package ambiente;

import seres.Jogador;

public class ItemPontosPoder extends Item{
	public ItemPontosPoder() {
		super("Elixir", 300);	
	}
	
	public void usaElixir(Jogador jogador) {
		jogador.alteraPontosPoder(300);
	}
	

}

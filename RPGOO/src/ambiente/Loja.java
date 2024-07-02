package ambiente;

import exceptions.MoedasInsuficienteException;
import seres.Jogador;

public class Loja {
	
	public void compraItem(Jogador jogador, Item item) throws MoedasInsuficienteException {
		if(jogador.getMoedas() > item.getPrecoItem()) {
			jogador.addItemInventario(item);
		}
		else throw new MoedasInsuficienteException();
	}
}

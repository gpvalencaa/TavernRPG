package ambiente;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exceptions.MoedasInsuficienteException;
import seres.Jogador;

public class Loja {
	private Jogador jogador;
	
	public Loja(Jogador jogador) {
		this.jogador = jogador;
	}
	
	/*public void compraItem(Jogador jogador, Item item) throws MoedasInsuficienteException {
		if(jogador.getMoedas() >+ item.getPrecoItem()) {
			jogador.addItemInventario(item);
			jogador.alteraMoedas(-item.getPrecoItem());
		}
		else throw new MoedasInsuficienteException();
	}
	try {
			compraItem(jogador, item);
			System.out.println("Comprou");
		} catch (Exception e) {
			e.getMessage();
			new JOptionPane("Moedas insuficientes");
		}
		*/

	public void compraItem(ActionListener actionListener, Item item) {
			try {
				compraItem(this.jogador, item);
			} catch (Exception e) {
				e.getMessage();
				new JOptionPane("Moedas insuficientes");
				
			}
		
	}
	
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public void compraItem(Jogador jogador, Item item) throws MoedasInsuficienteException{
		if(jogador.getMoedas() >= item.getPrecoItem()) {
			jogador.addItemInventario(item);
			jogador.alteraMoedas(-item.getPrecoItem());
		} else {
			throw new MoedasInsuficienteException();
		}
	}
	
	public void compraItem(JButton button, Item item) {
		
		try{
			compraItem(this.jogador, item);
		}catch (MoedasInsuficienteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
        System.out.println("Item comprado!");
        System.out.println(this.jogador.getMoedas());
    }
}

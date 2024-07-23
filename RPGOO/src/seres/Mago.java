package seres;

import javax.swing.JOptionPane;

import exceptions.PontosPoderInsuficientesException;

public class Mago extends Jogador{
	public Mago(int x, int y) {
		super(x, y, "tentativasprite3.png");
		this.alteraMoedas(7000);
		super.setVida(100);
		super.setPontosPoder(300);
		super.setDanoNormal(50);
		super.setDanoEspecial(70);
		super.setPrecoAtaqueNormal(100);
		super.setPrecoAtaqueEspecial(100);
		super.setNome("Mago");
	}
	
	public boolean ataqueNormal(Opp atacada) {
		//Nome: Flechada
		try{
			super.ataqueNormal(atacada, this.danoNormal, this.precoAtaqueNormal);
			return true;
		} catch(PontosPoderInsuficientesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public boolean ataqueEspecial(Opp atacada) {
		//Nome: Flecha poderosa
		return super.ataqueEspecial(atacada, this.danoEspecial, this.precoAtaqueEspecial);
		
	}
	
	
}

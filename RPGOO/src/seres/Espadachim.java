package seres;

import javax.swing.JOptionPane;

import exceptions.PontosPoderInsuficientesException;

public class Espadachim extends Jogador{
	public Espadachim(int x, int y) {
		super(x, y, "tentativasprite3.png");
		this.alteraMoedas(7000);
		this.setVida(100);
		this.setPontosPoder(200);
		super.setDanoNormal(30);
		super.setDanoEspecial(50);
		super.setPrecoAtaqueNormal(50);
		super.setPrecoAtaqueEspecial(80);
		super.setNome("Espadachim");
		
	}
	
	public boolean ataqueNormal(Opp atacada) {
		//Nome: Flechada
		try{
			return super.ataqueNormal(atacada, this.danoNormal, this.precoAtaqueNormal);
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

package seres;

import javax.swing.JOptionPane;

import exceptions.PontosPoderInsuficientesException;

public class Arqueiro extends Jogador{
	public Arqueiro(int x, int y) {
		super(x, y, "tentativasprite3.png");
		alteraMoedas(7000);
		setVida(100);
		setPontosPoder(100);
		super.setDanoNormal(15);
		super.setDanoEspecial(40);
		super.setPrecoAtaqueNormal(15);
		super.setPrecoAtaqueEspecial(30);
		super.setNome("Arqueiro");
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
		return super.ataqueEspecial(atacada, this.danoEspecial, 30);
	}
	
	
}

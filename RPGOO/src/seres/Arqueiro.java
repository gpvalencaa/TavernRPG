package seres;

public class Arqueiro extends Jogador{
	public Arqueiro(int x, int y) {
		super(x, y, "tentativasprite3.png");
		super.alteraMoedas(7000);
		super.setVida(100);
		super.setPontosPoder(100);
	}

}

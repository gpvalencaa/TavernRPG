package seres;

public class Mago extends Jogador{
	public Mago(int x, int y) {
		super(x, y, "tentativasprite3.png");
		this.alteraMoedas(7000);
		super.setVida(100);
		super.setPontosPoder(300);
	}

}

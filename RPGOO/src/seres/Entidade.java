package seres;
import jplay.Sprite;
import jplay.URL;

public class Entidade extends Sprite {
	protected int vida;
	protected String nome;

	public Entidade(int x, int y, String sprite) {
		super(URL.sprite(sprite), 20);	
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	
	public void mover() {
		moveX(0.3);
		moveY(0.3);
		}	



	public void setVida(int vida){
    this.vida = vida;
	}


	public int getVida () {
    return this.vida;
	}
	
	public void alteraVida (int quantidade) {
        vida = vida + quantidade;
    }
	
	public void ataque (Entidade atacado,int quantidadePV){
        atacado.alteraVida(-quantidadePV);
    }
}

	

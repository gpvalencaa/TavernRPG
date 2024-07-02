package seres;

public class Oponente extends Entidade {
    public Oponente(int x, int y, String sprite, String nomeOponente){
    	super(x, y, sprite);
        super.nome = nomeOponente;
        super.vida = 100;

    }

    
    
}

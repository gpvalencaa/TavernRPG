package progressao;

import seres.Jogador;

public abstract class Nivel {

	    private int numeroNivel;
	    
	    public void setNumeroNivel(int numeroNivel) {
	        this.numeroNivel = numeroNivel;
	    }

	    public boolean avancouNivel(Jogador personagem){
	        this.numeroNivel++;
	        return true;
	    }

	    public void xpRewards (Jogador personagem){
	        personagem.alteraMoedas(this.numeroNivel*20);
	        personagem.alteraPontosPoder(this.numeroNivel*50);
	        personagem.alteraVida(this.numeroNivel*50);
	    }

	    public int getNumeroNivel() {
	        return numeroNivel;
	    }

}

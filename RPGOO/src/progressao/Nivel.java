package progressao;

import javax.swing.JOptionPane;

import seres.Jogador;

public class Nivel {

	    private int numeroNivel;
	    public Nivel() {
	    	this.numeroNivel = 1;
	    }
	    public void setNumeroNivel(int numeroNivel) {
	        this.numeroNivel = numeroNivel;
	    }

	    /*public boolean avancouNivel(Jogador personagem){
	        this.numeroNivel++;
	        return true;
	    }*/

	    public void xpRewards (Jogador personagem){
	    	int premioMoedas = this.numeroNivel*300;
	    	int premioPP = this.numeroNivel*100;
	    	int premioVida = this.numeroNivel*50;
	    	int aumentoDanoNormal = personagem.getDanoNormal() + 25;
	    	int aumentoDanoEspecial = personagem.getDanoEspecial() + 50;
	    	
	    
	        personagem.alteraMoedas(premioMoedas);
	        personagem.alteraPontosPoder(premioPP);
	        personagem.alteraVida(premioVida);
	        personagem.setDanoNormal(aumentoDanoNormal);
	        personagem.setDanoEspecial(aumentoDanoEspecial);
	        this.numeroNivel = this.numeroNivel + 1;
	        try {
	    	    Thread.sleep(500);// pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	        JOptionPane.showMessageDialog(null, "<html>Você ganhou: <br>" + premioMoedas + " Moedas <br>" + premioPP + " Pontos de Poder<br>" + premioVida + " Pontos de Vida <br> Seu nível agora é: " + this.numeroNivel + " <br> Seu ataque normal agora causa " + personagem.getDanoNormal() + " de dano <br> Seu ataque especial agora causa " + personagem.getDanoEspecial() + " de dano");
	        try {
	    	    Thread.sleep(500);// pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	    }

	    public int getNumeroNivel() {
	        return numeroNivel;
	    }

}

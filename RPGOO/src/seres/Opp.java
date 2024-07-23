package seres;

public abstract class Opp {
	private String nome;
	private int vida;
	private int danoNormal;
    public Opp(String nome, int danoNormal){
    	this.nome = nome;
    	this.danoNormal = danoNormal;
    }
    
    public void ataque(Entidade atacada) {
    	atacada.alteraVida(-danoNormal);
    }
    
    public void alteraVida(int quantidade) {
    	this.vida = vida + quantidade;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public int getVida() {
    	return this.vida;
    }
    
    public void setVida(int vida) {
    	this.vida = vida;
    }
    
    public void setDanoNormal(int danoNormal) {
    	this.danoNormal = danoNormal;
    }
    public int getDanoNormal() {
    	return this.danoNormal;
    }
    
    
}

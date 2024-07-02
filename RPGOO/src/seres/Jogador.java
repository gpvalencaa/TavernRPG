package seres;

import jplay.*;
import progressao.Inventario;
import progressao.Nivel;

import java.awt.Point;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ambiente.Item;
import ambiente.Loja;
import ambienteTecnico.Controle;

public abstract class Jogador extends Entidade{
	private double velocidade = 1;
	private int direcao = 3;
	private boolean movendo = false;
	
	
	
	private int moedas;
	private int pontosPoder;
    public Nivel nivel; 
    Inventario inventario;
	
	
	public Jogador(int x, int y, String spriteSheet) {
		super(x,y,spriteSheet);
		super.setTotalDuration(2000);
	}
	
	public void progressaoPersonagem(){
        if (nivel.avancouNivel(this)== true){
            nivel.xpRewards(this);
        }
    }
	
	public int getNivel() {
        return this.nivel.getNumeroNivel();
    }
	
	public int getContadorItemInventario(){
        return inventario.getContadorItem();
    }
	
	public void addItemInventario(Item item){
        inventario.addItem(item);
    }
	public void alteraMoedas (int quantidade) {
        moedas = moedas + quantidade;

    }
	public int getMoedas() {
		return this.moedas;
	}
	
	public int getPontosPoder () {
        return this.pontosPoder;
    }

    public void alteraPontosPoder(int quantidade){
        pontosPoder = pontosPoder + quantidade;
    }

    public void setPontosPoder(int quantidade){
        pontosPoder = quantidade;
    }

	
	
	
	
	
	
	
	
	
	public void mover(Window janela, Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x > 0) {
				this.x -= velocidade;
			}
			if (direcao != 1) {
				super.setSequence(4, 8);
				direcao = 1;
			} movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
			//if(this.x < janela.getWidth()) {
				this.x += velocidade;
			//}
			if (direcao != 2) {
				super.setSequence(8, 12);
				direcao = 2;
				
			} movendo = true;
			
		} else if (teclado.keyDown(Keyboard.UP_KEY)) {
			if(this.y > 0) {
				this.y -= velocidade;
			}
			if (direcao != 4) {
				super.setSequence(12, 16);
				direcao = 4;
			} movendo = true;
			
			
		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
			if(this.y < janela.getHeight()+ 60) {
				this.y += velocidade;
			}
			if (direcao != 5) {
				super.setSequence(0, 4);
				direcao = 5;
			} movendo = true;
			
		}
		
		if (movendo == true) {
			update();
			movendo = false;
		}
		
		}
	
	public Controle controle = new Controle();

	public void caminho(Scene cena) {
			Point min = new Point((int)this.x,(int)this.y);
			Point max = new Point((int)this.x + this.width,(int)this.y + this.height);
			
			Vector<?>tiles = cena.getTilesFromPosition(min, max);
			
			for(int i = 0; i < tiles.size(); i++) {
				TileInfo tile = (TileInfo) tiles.elementAt(i);
			
				
				
				if (controle.colisao(this, tile) == true) {
					if(colisaoVertical(this,tile)) {
						if(tile.y + tile.height - 2 < this.y) {
							this.y = tile.y + tile.height;
						} 
						
						else if (tile.y > this.y + this.height - 2) {
							System.out.println("Entrou");
							this.y = tile.y - this.height;
						}
					}
					
					if(colisaoHorizontal(this,tile)) {
						//System.out.println("yes");
						if(tile.x + tile.width - 2 < this.x) {
							this.x = tile.x + tile.width;
						} 
						
						else if (tile.x > this.x + this.width - 2) {
							System.out.println("aa");
							this.x = tile.x - this.width;
						}
					}
					
				}
			}
		
	}
	
	private boolean colisaoVertical(GameObject obj, GameObject obj2) {
		if(obj2.x + obj2.width <= obj.x) 
			return false;
		if(obj.x + obj.width <= obj2.x) 
			return false;
		return true;
	}
	
	private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		if(obj2.y+ obj2.height <= obj.y) 
			return false;
		
		if(obj.y + obj.height <= obj2.y) 
			return false;
		return true;
	}
	
	public void confereInventario(Keyboard teclado) {
		if(teclado.keyDown(Keyboard.M_KEY)) {
			try {
	    	    Thread.sleep(500);// pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	    	JFrame frame = new JFrame("Inventário");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(400, 300);
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel(Integer.toString(moedas));
	        panel.add(label);
	        frame.add(panel);
	        frame.setVisible(true);
	        try {
	    	    Thread.sleep(500); // pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
			
		}
		
	}
	
	public void confereLoja(Keyboard teclado) {
		if(teclado.keyDown(Keyboard.S_KEY)) {
			try {
	    	    Thread.sleep(500);// pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	    	JFrame frame = new JFrame("Loja");
	    	Loja loja = new Loja();
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(400, 300);
	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("<html>Preços:<br>Cura: 200 moedas<br>Maldicao: 300 moedas<br>Elixir: 300 moedas<html>");
	        JButton buttonCura = new JButton("Cura");
	        JButton buttonMaldicao = new JButton("Maldicao");
	        JButton buttonElixir = new JButton("Elixir");
	        
	        // Adiciona os botões ao painel
	        panel.add(buttonCura);
	        panel.add(buttonMaldicao);
	        panel.add(buttonElixir);
	        
	        panel.add(label);
	        frame.add(panel);
	        frame.setVisible(true);
	        try {
	    	    Thread.sleep(500); // pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
			
		}
		
	}


}

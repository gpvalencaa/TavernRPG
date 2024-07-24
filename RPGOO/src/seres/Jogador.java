package seres;

import jplay.*;
import progressao.Inventario;
import progressao.Nivel;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ambiente.*;
import ambiente.ItemCura;
import ambiente.Loja;
import ambienteTecnico.Controle;
import exceptions.InventarioCheioException;
import exceptions.PontosPoderInsuficientesException;
import interfaces.ataques;

public abstract class Jogador extends Entidade implements ataques{
	private double velocidade = 1;
	private int direcao = 3;
	private boolean movendo = false;
	//private Keyboard confereTecla;
	//public Controle controle = new Controle(this, confereTecla);
	public Controle controle;
	protected int danoNormal;
	protected int danoEspecial;
	protected int precoAtaqueNormal;
	protected int precoAtaqueEspecial;
	
	
	
	private int moedas;
	private int pontosPoder;
    public Nivel nivel; 
    Inventario inventario;
	 
	
	public Jogador(int x, int y, String spriteSheet) {
		super(x,y,spriteSheet);
		super.setTotalDuration(2000);
		controle = new Controle(this);
		inventario = new Inventario(this);
		nivel = new Nivel();
	}
	
	
	public void progressaoPersonagem(){
            nivel.xpRewards(this);
    }
	
	public int getNivel() {
        return this.nivel.getNumeroNivel();
    }
	
	public int getContadorItemInventario(){
        return inventario.getContadorItem();
    }
	
	public void addItemInventario(Item item){
	  //boolean catchExecutado;
      try {
    	  inventario.addItem(item);
    	  for (int i = 0; i<inventario.getContadorItem(); i++){
    		  System.out.println(inventario.getArrItem()[i]); 
    	  }
      } catch(Exception e) {
    	  System.out.println("oi");
    	  JOptionPane.showMessageDialog(null, "Inventário cheio!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    	  this.alteraMoedas(item.getPrecoItem());
    	  //catchExecutado = true;
      }
    }
	
	
	public void alteraMoedas (int quantidade) {
        this.moedas = moedas + quantidade;

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
    
    private void usaItem(JButton button, Item item) {
    	if (item instanceof ItemCura) {
    		for(int i = 0; i<inventario.getLenghtArrItem(); i++) {
    			if(inventario.getArrItem()[i] instanceof ItemCura) {
    				((ItemCura) item).curaEntidade(this);
    				System.out.println(this.getVida());
    				inventario.removeItem(i);
    				break;
    			}
    		}
    	} else if(item instanceof ItemMaldicao) {
    		for(int i = 0; i<inventario.getLenghtArrItem(); i++) {
    			if(inventario.getArrItem()[i] instanceof ItemMaldicao) {
    				((ItemMaldicao) item).tiraVida(this);
    				System.out.println(this.getVida());
    				inventario.removeItem(i);
    				break;
    			}
    		}
    	} else if(item instanceof ItemPontosPoder) {
    		for(int i = 0; i<inventario.getLenghtArrItem(); i++) {
    			if(inventario.getArrItem()[i] instanceof ItemPontosPoder) {
    				((ItemPontosPoder) item).usaElixir(this);
    				System.out.println(this.getPontosPoder());
    				inventario.removeItem(i);
    				break;
    			}
    		}
    	 }
    		else if(item instanceof ItemTavern) {
    			JOptionPane.showMessageDialog(null, "Você está no reino de nora");
    		}
    }

	
	public int getDanoNormal() {
		return this.danoNormal;
	}
	public void setDanoNormal(int danoAtaqueNormal) {
		this.danoNormal = danoAtaqueNormal;
	}
	
	public int getDanoEspecial() {
		return this.danoEspecial;
	}
	public void setDanoEspecial(int danoAtaqueEspecial) {
		this.danoEspecial = danoAtaqueEspecial;
	}
	
	public int getPrecoAtaqueNormal() {
		return precoAtaqueNormal;
	}

	public void setPrecoAtaqueNormal(int precoAtaqueNormal) {
		this.precoAtaqueNormal = precoAtaqueNormal;
	}

	public int getPrecoAtaqueEspecial() {
		return precoAtaqueEspecial;
	}

	public void setPrecoAtaqueEspecial(int precoAtaqueEspecial) {
		this.precoAtaqueEspecial = precoAtaqueEspecial;
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
	
	//public Controle controle = new Controle();

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
	    	mostraInventario(this);
	        try {
	    	    Thread.sleep(500); // pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
			
		}
		
	
		
	}

	/*public void apertouBotaoLoja(ActionEvent action, Loja loja, Item item) {
		try {
			loja.compraItem(this, item);
			System.out.println("Entrou");
		} catch (Exception e1) {
			e1.getMessage();
			new JOptionPane("Moedas Insuficientes");	
    }
	}*/
	
	public void confereLoja(Keyboard teclado) {
		if(teclado.keyDown(Keyboard.S_KEY)) {
			try {
	    	    Thread.sleep(500);// pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	    	mostraLoja(this);
	        try {
	    	    Thread.sleep(500); // pausa por 0.5 segundos
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
			
		}
		
	}

	public boolean ataqueNormal(Opp atacada,int quantidadeDano, int precoPPAtaque) throws PontosPoderInsuficientesException {
			if (this.pontosPoder > precoPPAtaque) {
				atacada.alteraVida(-quantidadeDano);
				this.alteraPontosPoder(-precoPPAtaque);
				return true;
			} else {
				throw new PontosPoderInsuficientesException();
			}
			
		
	}
	public boolean ataqueEspecial(Opp atacada, int quantidadeDano, int precoPPataque) {
		try{
			ataqueNormal(atacada, quantidadeDano, precoPPataque);
			System.out.println("Entrou no try ataque especial");
			return true;
		} catch(PontosPoderInsuficientesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("Exception - ataqueespecial 3 params - jogador");
			return false;
		}
		 
	}

	public void mostraInventario(Jogador jogador) {
		JFrame frame = new JFrame("Inventário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Moedas: " + Integer.toString(moedas) + "<br>Vida:" + Integer.toString(vida) + "<br>Pontos de Poder: " + Integer.toString(pontosPoder)+ "<br>Nível:" + nivel.getNumeroNivel());
        
        
        JButton buttonUsaCura = new JButton("Cura");
        buttonUsaCura.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	inventario.jogador.usaItem(buttonUsaCura, new ItemCura());  
        	label.setText("<html>Moedas: " + Integer.toString(moedas) + "<br>Vida:" + Integer.toString(vida) + "<br>Pontos de Poder: " + Integer.toString(pontosPoder)+ "<br>Nível:" + nivel.getNumeroNivel());
        	
        	//System.out.println(Jogador.getMoedas());
        }
        });
    			
        JButton buttonUsaMaldicao = new JButton("Maldicao");
        buttonUsaMaldicao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	inventario.jogador.usaItem(buttonUsaMaldicao, new ItemMaldicao());		
        	label.setText("<html>Moedas: " + Integer.toString(moedas) + "<br>Vida:" + Integer.toString(vida) + "<br>Pontos de Poder: " + Integer.toString(pontosPoder)+ "<br>Nível:" + nivel.getNumeroNivel());
	    }
	    });
	    			
        
        JButton buttonUsaElixir = new JButton("Elixir");
        buttonUsaElixir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	inventario.jogador.usaItem(buttonUsaElixir, new ItemPontosPoder());	
        	label.setText("<html>Moedas: " + Integer.toString(moedas) + "<br>Vida:" + Integer.toString(vida) + "<br>Pontos de Poder: " + Integer.toString(pontosPoder)+ "<br>Nível:" + nivel.getNumeroNivel());
		}
		});
        
        JButton buttonReinoDeNora = new JButton("Reino de Nora");
        buttonReinoDeNora.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	inventario.jogador.usaItem(buttonReinoDeNora, new ItemTavern());	
        	label.setText("<html>Moedas: " + Integer.toString(moedas) + "<br>Vida:" + Integer.toString(vida) + "<br>Pontos de Poder: " + Integer.toString(pontosPoder)+ "<br>Nível:" + nivel.getNumeroNivel());
		}
		});
        
        
        
        
        // Adiciona os botões ao painel
        panel.add(buttonUsaCura);
        panel.add(buttonUsaMaldicao);
        panel.add(buttonUsaElixir);
        panel.add(buttonReinoDeNora);
        
        
        
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
	}
	public void mostraLoja(Jogador jogador) {
		JFrame frame = new JFrame("Loja");
    	Loja loja = new Loja(this);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Preços:<br>Cura: 200 moedas<br>Maldicao: 300 moedas<br>Elixir: 300 moedas<br>Suas moedas: <html>" + Integer.toString(getMoedas()));
        
        JButton buttonCompraCura = new JButton("Cura");
        buttonCompraCura.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	loja.compraItem(buttonCompraCura, new ItemCura());
        	label.setText("<html>Preços:<br>Cura: 200 moedas<br>Maldicao: 300 moedas<br>Elixir: 300 moedas<br>Suas moedas: <html>" + Integer.toString(getMoedas()));
        	//System.out.println(Jogador.getMoedas());
        }
        });
    			
        JButton buttonCompraMaldicao = new JButton("Maldicao");
        buttonCompraMaldicao.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	loja.compraItem(buttonCompraMaldicao, new ItemMaldicao());		
	    	label.setText("<html>Preços:<br>Cura: 200 moedas<br>Maldicao: 300 moedas<br>Elixir: 300 moedas<br>Suas moedas: <html>" + Integer.toString(getMoedas()));
	    }
	    });
	    			
        
        JButton buttonCompraElixir = new JButton("Elixir");
        buttonCompraElixir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loja.compraItem(buttonCompraElixir, new ItemPontosPoder());		
			label.setText("<html>Preços:<br>Cura: 200 moedas<br>Maldicao: 300 moedas<br>Elixir: 300 moedas<br>Suas moedas: <html>" + Integer.toString(getMoedas()));
		}
		});
        
        
        
        
        // Adiciona os botões ao painel
        panel.add(buttonCompraCura);
        panel.add(buttonCompraMaldicao);
        panel.add(buttonCompraElixir);
        
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
        
        
        
        
	}
	
	
	
	
	
	
}

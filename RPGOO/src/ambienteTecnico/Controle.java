




package ambienteTecnico;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
	
	public boolean janelaInterrogacaoExibida = false;
	public boolean janelaAnciaoExibida = false;
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		//colidiuInterrogacao(obj, tile);
		colidiuTileCaminho(obj, tile,05, this.janelaInterrogacaoExibida);
		colidiuTileCaminho(obj, tile, 11,this.janelaAnciaoExibida);
		if ((tile.id >= 7) && obj.collided(tile)){
			return true;
		} 
		return false;
	}
	
	/*public boolean colisao(GameObject obj, TileInfo tile, int tileid) {
		colidiuTileCaminho(obj, tile, tileid);
		if ((tile.id >= 7) && obj.collided(tile)){
			return true;
		}
		return false;
	}*/
	
	public boolean colidiuTileCaminho(GameObject obj, TileInfo tile, int tileid, boolean janelaExibida) {
		if((tile.id == tileid) && obj.collided(tile) && !janelaExibida){
			
			if (tileid == 05) {
			frameInterrogacao();
			return true;
		}
			if(tileid == 11) {
			frameAnciao();
			}
		return false;
		}
		return false;
	}

	public void frameInterrogacao(){
    
    	try {
    	    Thread.sleep(500);// pausa por 0.5 segundos
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    	this.janelaInterrogacaoExibida = true; 
    	JFrame frame = new JFrame("?");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Seja bem vindo à taverna do reino de Nora!<br>Aqui fomos informados que seu dever é nos salvar da maldição<br>Tome cuidado ao sair daqui... eles estão por todo lado<br>Ah, leve com você essas moedas e esse amuleto</html>");
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
        try {
    	    Thread.sleep(500); // pausa por 0.5 segundos
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
        
        
        }
	
	public void frameAnciao() {
		try {
    	    Thread.sleep(500);// pausa por 0.5 segundos
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    	this.janelaAnciaoExibida = true; 
    	JFrame frame = new JFrame("Roland");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Oh, meu deus...<br>Sempre soube que essa hora ia chegar<br>Sou o morador mais antigo do reino, me chamo Roland<br>Você poderia me dar algumas moedas?</html>");
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
	
	




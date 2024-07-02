package cenarios;
import jplay.Window;
import seres.Espadachim;
import seres.Jogador;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;

public class Cenario {
	private Window janela; 
	private Scene cena;
	private Jogador personagemPrincipal;
	private Keyboard teclado;
	public boolean passouCenario = false;
	//private Controle controleCen;
	
	public Cenario(Window janela, String enderecoscn) {
		this.janela = janela;
		cena = new Scene();
		cena.loadFromFile(URL.scenario(enderecoscn));
		personagemPrincipal = new Espadachim(60,500);
		teclado = janela.getKeyboard();
		//controleCen = new Controle();
		run();
		
		
		}
	
	private void run() {
		while(true) {
			personagemPrincipal.mover(janela, teclado);
			personagemPrincipal.caminho(cena);
			cena.moveScene(personagemPrincipal);
			personagemPrincipal.x += cena.getXOffset();
			personagemPrincipal.y += cena.getYOffset();
			personagemPrincipal.draw();
			personagemPrincipal.confereInventario(teclado);
			personagemPrincipal.confereLoja(teclado);
			janela.update();
			janela.delay(2);
			if (passouCenario == true) {
				break;
			}
		}
	}
	
	public Window getJanela() {
		return janela;
	}
	
	
	
}


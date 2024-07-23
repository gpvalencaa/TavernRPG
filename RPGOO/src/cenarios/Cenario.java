package cenarios;
import jplay.Window;
import seres.Espadachim;
import seres.Jogador;
import ambienteTecnico.Controle;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;

public class Cenario {
	private Window janela; 
	private Scene cena;
	public Jogador personagemPrincipal;
	private Keyboard teclado;
	public boolean passouCenario = false;
	private Controle controleCen;
	
	public Cenario(Window janela, String enderecoscn, Jogador personagemPrincipal) {
		this.janela = janela;
		cena = new Scene();
		cena.loadFromFile(URL.scenario(enderecoscn));
		this.personagemPrincipal = personagemPrincipal;
		teclado = janela.getKeyboard();
		controleCen = personagemPrincipal.controle;
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
			if (controleCen.mudaCenario == true) {
				controleCen.mudaCenario = false;
				break;
			}
		}
	}
	
	public Window getJanela() {
		return janela;
	}
	
	
	
}


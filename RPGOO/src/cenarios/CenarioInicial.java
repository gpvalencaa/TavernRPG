package cenarios;
import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;

public class CenarioInicial {
	private Window janela; 
	private GameImage plano;
	
	
	public CenarioInicial(Window janela) {
		this.janela = janela;
		plano = new GameImage("src/recursos/tavernhistoria4.jpg");
		run();
		}
	
	private void run() {
		while(true) {
			plano.draw();
			janela.update();
			if(janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
				break;
			}
			}
	}
}

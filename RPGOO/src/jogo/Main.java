package jogo;
import jplay.Window;
import jplay.Keyboard;
import jplay.GameImage;
import javax.swing.*;

import cenarios.Cenario;
import cenarios.Cenario1;
import cenarios.CenarioInicial;


public class Main {
	
	public static void main(String[] args) {
	
	Window janela = new Window(800,600);
	GameImage plano = new GameImage("src/recursos/menutestetavern.png");
	Keyboard teclado = janela.getKeyboard();
	
	while(true) {
		plano.draw();
		janela.update();
		
		if(teclado.keyDown(Keyboard.ENTER_KEY)) {
		System.out.println("Pressionou");
		new CenarioInicial(janela);
		new Cenario1(janela);
		}
		}
		
		
	}
}


	
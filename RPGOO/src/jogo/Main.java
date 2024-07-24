package jogo;
import jplay.Window;
import seres.Entidade;
import seres.Espadachim;
import seres.Jogador;
import jplay.Keyboard;
import jplay.GameImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import cenarios.Cenario;
import cenarios.Cenario1;
import cenarios.Cenario2;
import cenarios.Cenario3;
import cenarios.Cenario4;
import cenarios.CenarioInicial;
import ambienteTecnico.EscolhaPersonagem;


public class Main {
	//static Jogador personagemPrincipal;
	public static void main(String[] args) {
	
	Window janela = new Window(800, 600); //800, 600
	GameImage plano = new GameImage("src/recursos/menutestetavern.png");
	Keyboard teclado = janela.getKeyboard();
	Jogador personagemPrincipal;
	//boolean rodando = true;
	
	
	while(true) {
		plano.draw();
		janela.update();
		
		if(teclado.keyDown(Keyboard.ENTER_KEY)) {
		System.out.println("Pressionou");
		new CenarioInicial(janela);
		
		EscolhaPersonagem escolha = new EscolhaPersonagem();
		personagemPrincipal = escolha.personagem;
		//personagemPrincipal = new Espadachim(40, 500);
		//final Cenario fase1 =
		new Cenario1(janela, personagemPrincipal);
		System.out.println("main");
		new Cenario2(janela, personagemPrincipal);
		new Cenario3(janela, personagemPrincipal);
		new Cenario4(janela, personagemPrincipal);
		
		
		}
		}
		
		
	}
	
	
	
	
	}


	
	




	
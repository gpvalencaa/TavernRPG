package ambienteTecnico;

import javax.swing.*;

import exceptions.ClasseNaoEscolhidaException;
import seres.Arqueiro;
import seres.Espadachim;
import seres.Jogador;
import seres.Mago;

public class EscolhaPersonagem {
    public Jogador personagem = null;
    public EscolhaPersonagem() {
        insist();
    }

    private void criarOpcoes() throws ClasseNaoEscolhidaException{
        String[] options = {"Espadachim", "Mago", "Arqueiro"};
        int escolha = JOptionPane.showOptionDialog(null, 
                                                   "Escolha uma classe:", 
                                                   "Classe do Personagem", 
                                                   JOptionPane.DEFAULT_OPTION, 
                                                   JOptionPane.INFORMATION_MESSAGE, 
                                                   null, 
                                                   options, 
                                                   options[0]);
        
        switch (escolha) {
            case 0:
                this.personagem = new Espadachim(40,500);
                
                mostrarMensagem(this.personagem.getNome());
                break;
            case 1:
            	this.personagem = new Mago(40,500);
                mostrarMensagem(this.personagem.getNome());
                break;
            case 2:
            	this.personagem = new Arqueiro(40,500);
                mostrarMensagem(this.personagem.getNome());
                break;
            default:
            	throw new ClasseNaoEscolhidaException();
                
        }
    }

    private void mostrarMensagem(String nome) {
        JOptionPane.showMessageDialog(null, "Você escolheu: " + nome, "Classe Escolhida", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void insist() {
    	boolean conseguiu = false;
    	while(conseguiu == false) {
        	try{
        		criarOpcoes();
        		conseguiu = true;
        	} catch (ClasseNaoEscolhidaException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }
    

    
}
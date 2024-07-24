package ambienteTecnico;

import javax.swing.*;

import seres.Jogador;
import seres.Opp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combate {
    private Jogador jogador;
    private Opp inimigo;
    private JLabel lblStatusJogador;
    private JLabel lblStatusInimigo;
    private JButton btnAtacar;
    private JButton btnAtaqueEspecial;
    private JFrame frame;
   // public boolean acabouBatalha;
    //public boolean perdeu = false;

    public Combate(Jogador player, Opp adversario) {
    	try {
    	    Thread.sleep(500);// pausa por 0.5 segundos
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
        this.jogador = player;
        this.inimigo = adversario;
    	
        frame = new JFrame(inimigo.getNome());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        lblStatusJogador = new JLabel("Sua saúde: " + jogador.getVida() + " Seus pontos de poder: " + jogador.getPontosPoder());
        lblStatusInimigo = new JLabel("Saúde do " + inimigo.getNome()  + ": "+ inimigo.getVida());
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(2, 1));
        statusPanel.add(lblStatusJogador);
        statusPanel.add(lblStatusInimigo);
        frame.add(statusPanel, BorderLayout.NORTH);

        btnAtacar = new JButton("Atacar");
        btnAtaqueEspecial = new JButton("Ataque Especial");
        btnAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atacarNormal();
            }
        });
        btnAtaqueEspecial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atacarEspecial();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAtacar);
        buttonPanel.add(btnAtaqueEspecial);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        try {
    	    Thread.sleep(500);// pausa por 0.5 segundos
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    }

    private void atacarNormal() {
        //int danoCausado = jogador.() - inimigo.defender();
        //if (danoCausado < 0) danoCausado = 0;
    	boolean deuCertoAtaque = jogador.ataqueNormal(inimigo);
    	if(deuCertoAtaque == true) {
        JOptionPane.showMessageDialog(null, "Você causou " + jogador.getDanoNormal() + " de dano no inimigo.");
    	}
        if (inimigo.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Você venceu!");
           // acabouBatalha = true;
            frame.dispose();
        } else {
        turnoInimigo();
        }
    }

    private void atacarEspecial() {
    	
    	boolean deuCertoAtaqueEspecial = jogador.ataqueEspecial(inimigo);
        //JOptionPane.showMessageDialog(null, "Você causou " + jogador.getDanoEspecial() + " de dano no inimigo.");
    	
    	if (deuCertoAtaqueEspecial == true) {
    		JOptionPane.showMessageDialog(null, "Você causou " + jogador.getDanoEspecial() + " de dano no inimigo.");
    	} 
    	if (inimigo.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Você venceu!");
           // acabouBatalha = true;
            frame.dispose();
        } else {
        turnoInimigo();
        }
    }

    private void turnoInimigo() {
        //int danoCausado = inimigo.() - jogador.defender();
        //if (danoCausado < 0) danoCausado = 0;
        inimigo.ataque(jogador);
        JOptionPane.showMessageDialog(null, "O inimigo causou " + inimigo.getDanoNormal() + " de dano em você.");
        if (jogador.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Você foi derrotado!");
            frame.dispose();
            System.exit(0);
        }

        atualizarStatus();

    }

    private void atualizarStatus() {
        lblStatusJogador.setText("Sua saúde: " + jogador.getVida() + " Seus pontos de poder: " + jogador.getPontosPoder());
        lblStatusInimigo.setText("Saúde do " + inimigo.getNome()  + ": "+ inimigo.getVida());
    }
    
    /*public boolean getAcabouBatalha() {
    	return this.acabouBatalha;
    }*/

  
}
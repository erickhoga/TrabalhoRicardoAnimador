package br.unifil.dc.lab2;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.util.ListIterator;

/**
 * Write a description of class Tocador here.
 * 
 * @author Ricardo Inacio
 * @version 20200409
 */
public class Tocador extends JPanel {

    public Tocador(ListIterator<Transparencia> quadrosFilme) {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        carregarFilme(quadrosFilme);
    }
    public Tocador() {
        this(null);
    }
    
    public void carregarFilme(ListIterator<Transparencia> quadrosFilme) {
        this.quadrosFilme = quadrosFilme;
        this.quadroAtual = null;
        numQuadro = 0;
    }
    
    public void avancarFilme() {
        if (quadrosFilme.hasNext()) {
            quadroAtual = quadrosFilme.next();
            numQuadro++;
        }
    }
    
    public void voltarFilme() {
        if (quadrosFilme.hasPrevious()) {
            quadroAtual = quadrosFilme.previous();
            numQuadro--;
        }
    }
    
    public void rebobinarFilme() {
        while (quadrosFilme.hasPrevious()) {
            quadroAtual = quadrosFilme.previous();
            numQuadro--;
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D pincel = (Graphics2D) g;
        
        if (quadroAtual != null) {
            quadroAtual.pintar(pincel, this);
        } else {
            String frase = "O Filme ainda não iniciou";
            // ESCREVER NO MEIO DA TELA "O Filme ainda não iniciou."
            pincel.setFont(new Font("Courier New", Font.PLAIN, 50));
            pincel.drawString(frase,(int) ((getSize().width*0.275f)), (int) (getSize().height/2));
        }
        
        // ESCREVER NO CANTO INFERIOR DIREITO DA TELA "Quadro 'numQuadro'"
            String numeroAtual = String.valueOf(numQuadro);
            pincel.drawRect((int) (getSize().width*0.94), (int) (getSize().height*0.9), (int) (getSize().width*0.07f), (int) (getSize().height*0.1f));
            pincel.setFont(new Font("Courier New", Font.PLAIN, 50));
            pincel.drawString(numeroAtual,(int)(getSize().width*0.96), (int) (getSize().height*0.97));
    }


    private int numQuadro = 0;
    private Transparencia quadroAtual = null;
    private ListIterator<Transparencia> quadrosFilme = null;
}

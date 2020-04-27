package br.unifil.dc.lab2;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Area;
import java.util.List;

/**
 * Write a description of class ListaGravada here.
 * 
 * @author Ricardo Inacio
 * @version 20200409
 */
public class ListaGravada implements Transparencia
{
    /**
     * Constructor for objects of class ListaGravada
     */
    public ListaGravada(List<Integer> lista, List<Color> coresIndices, String nome) {
        this.lista = lista;
        this.nome = nome;
        this.coresIndices = coresIndices;
    }
    
    
    public void pintar(Graphics2D pincel, JPanel contexto) {
        pincel.setColor(Color.BLACK);;
        pincel.setStroke(new BasicStroke(3));
        Dimension dim = contexto.getSize();
        float pilar = this.lista.size();
        int x = (int)(dim.width*0.0165f/pilar*10);
        int y = (int)(dim.height*0.1f);
        int largurabarras = (int)(dim.width*0.06f/pilar*10);
        int maiornumero = 0;
        int pixelTamanho = (int)(dim.height*0.6f);
        int espacocolunas = (int)(dim.width*0.0415f/pilar*10);

        for(int i = 0; i<this.lista.size();i++){
                maiornumero = maiornumero < this.lista.get(i) ? this.lista.get(i) : maiornumero;
        }


        for (int i = 0; i < this.lista.size() ; i++) {
            int tamanhoBarra = ((this.lista.get(i)*pixelTamanho)/maiornumero);
            if(coresIndices.get(i) == null) pincel.setColor(Color.BLUE);
            else pincel.setColor(coresIndices.get(i));
            pincel.fillRect(x,y+pixelTamanho-tamanhoBarra , largurabarras,tamanhoBarra);
            pincel.setColor(Color.BLACK);
            pincel.drawRect(x,y+pixelTamanho-tamanhoBarra , largurabarras,tamanhoBarra);
            x += largurabarras+espacocolunas;
        }
    }
    
    
    private List<Integer> lista;;
    private List<Color> coresIndices;
    private String nome;
}

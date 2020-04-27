package br.unifil.dc.lab2;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Write a description of class Gravador here.
 *
 * @author Ricardo Inacio
 * @version 20200409
 */
public class Gravador
{
    public Gravador() {
        this.seqGravacoes = new ArrayList<Transparencia>();
    }

    /**
     * Método para gravar na lista da sequencia de gravações para ir printando o Desenho na tela
     * @param lista
     * @param nome
     */
    public void gravarLista(List<Integer> lista, String nome) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, nome);
        seqGravacoes.add(gravacao);
    }

    /**
     * Método para percorrer a lista 1 por 1 mudando a cor da barra de azul para amarelo até achar a chave
     * @param lista
     * @param i
     * @param nome
     */
    public void gravarIndiceDestacado(List<Integer> lista, int i, String nome) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, nome);
        seqGravacoes.add(gravacao);
    }

    public void gravarComparacaoSimples(List<Integer> lista, int i, int j) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i-1, Color.RED);
        cores.set(j-1, Color.magenta);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, "Comparação");
        seqGravacoes.add(gravacao);
    }


    public void gravarPosTrocas(List<Integer> lista, int i, int j) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i, Color.YELLOW);
        cores.set(j, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, "Pós-troca");
        seqGravacoes.add(gravacao);
    }

    public ListIterator<Transparencia> getFilme() {
        return seqGravacoes.listIterator();
    }

    private static List<Color> novaListaColors(int numElems, Color cor) {
        ArrayList<Color> lista = new ArrayList<>(numElems);
        for (; numElems > 0; numElems--) lista.add(cor);
        return lista;
    }

    private List<Transparencia> seqGravacoes;
}

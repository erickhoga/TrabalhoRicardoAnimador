package br.unifil.dc.lab2;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

/**
 * Write a description of class AlgoritmosAnimados here.
 *
 * @author Ricardo Inacio
 * @version 20200408
 */
public class AlgoritmosAnimados
{
    public static Gravador listaEstatica(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Valores da lista imutável");
        return anim;
    }

    public static Gravador pesquisaSequencial(List<Integer> valores, int chave) {
        Gravador anim = new Gravador();
        //instancioa o Gravador
        anim.gravarLista(valores, "Inicio de pesquisa sequencial");
        //grava a lista com os parametros Lista valores e uma String (chave)
        int i = 0;
        anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
        //grava em valores o indice da chave, no meu exemplo a barrinha que fica amarela
        while (i < valores.size() && valores.get(i) != chave) {
            i++;
            anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
        }
        //percorre o array até achar o indice da chave

        if (i < valores.size()) {
            anim.gravarIndiceDestacado(valores, i, "Chave encontrada");
            //se passar pelo array inteiro e totod forem diferente da cha indice então i = .size, então ele grava a chave encontrada com o método gravarIndiceDestacado
        } else {
            anim.gravarLista(valores, "Chave não encontrada");
            //aqui ele deu i = valores.size pois percorreu inteiro o array e não encontrou a chave passada por parametro
        }

        return anim;
    }

    //(1,2,3,4,5_
    private static void permutar(List<Integer> lista, int a, int b) {
        Integer permutador = lista.get(a); // permutador = lista[a]
        lista.set(a, lista.get(b)); // lista[a] = lista[b]
        lista.set(b, permutador); // lista[b] = permutador
        Gravador anim = new Gravador();
        anim.gravarPosTrocas(lista,a,b);
    }

    public static Gravador classificarPorBolha(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");
        boolean houvePermuta;
        do {
            houvePermuta = false;

            for (int i = 1; i < valores.size(); i++) {
                if (valores.get(i-1) > valores.get(i)) {
                    anim.gravarComparacaoSimples(valores,i , i+1);
                    permutar(valores, i - 1, i);
                    houvePermuta = true;
                }
            }
        } while (houvePermuta);

        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    public static Gravador pesquisaBinaria(List<Integer> valores, int chave) {
        Gravador anim = new Gravador();
//        anim.gravarLista(valores, "Inicio de pesquisa sequencial");
//        int i = 0;
//        int r = -1;
//        anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
//        int indiceFinal = valores.size();
//        int meio;
//        while (i <= indiceFinal)
//        {
//            meio = (i + indiceFinal)/2;
//            if (chave == valores.get(meio)) r =  meio;
//            if (chave < valores.get(meio)) indiceFinal = meio-1;
//            else i = meio+1;
//            anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
//        }
//        anim.gravarIndiceDestacado(valores, i, "Chave encontrada");
        return anim;
    }


    public static Gravador classificarPorInsercao(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");
        for (int i = 1; i < valores.size(); i++) {
            Integer elem = valores.get(i);
            int j = i;

            while (j > 0 && valores.get(j-1) > elem) {
                anim.gravarComparacaoSimples(valores,j+1,j);
                valores.set(j, valores.get(j-1));
                j--;
            }
            valores.set(j, elem);
        }
        anim.gravarLista(valores, "Disposição final");
        return anim;
    }
    public static Gravador classificarPorSelecao(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");
            for (int i = 0; i < valores.size(); i++) {
                int menorValor = encontrarMenorValor(valores, i);
                anim.gravarComparacaoSimples(valores,menorValor+1,i+1);
                permutar(valores, menorValor, i);
            }
        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    private static int encontrarMenorValor(List<Integer> lista, int Inicio) {
        Gravador anim = new Gravador();
        anim.gravarLista(lista, "Disposição inicial");
        int menor = Inicio;
        for (int i = Inicio+1; i < lista.size(); i++) {
            if (lista.get(menor) > lista.get(i))
                menor = i;
        }
        return menor;
    }

    //██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
            //O QUE FALTA IMPLEMENTAR
    //██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
            //completar alguens sorts que faltou, em vez de só marcar as posições que estão sendo trocadas, marcar o deslocamento,
            //Alterar as cores.
            //Pesquisa Binária (não deu certo.)
            //Mergesort.
            //Quicksort.
    //██ e por fim o filme que eu não entendi como funciona o código não :/
    //fiz tudo o que consegui.
}
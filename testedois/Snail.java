package testedois;

import java.util.ArrayList;
import java.util.List;

public class Snail {
    
    public List<Integer> retornarMatrizOrganizada(int[][] bidimensional, List<Integer> matrizUnidimensional, int linhasColunas) {
        int linhaFinal = linhasColunas;
        int colunaFinal = linhasColunas;
        int colunaDeTransicao = 0;
        int linhasDeTransicao = 0;
        int numeroDePosicoes = linhasColunas * linhasColunas;

        if(bidimensional == null || bidimensional.length == 0) {
            return new ArrayList<>();
        }

        while(numeroDePosicoes > 0) {
            for(int j = colunaDeTransicao ; j < colunaFinal ; j ++ ) {
                matrizUnidimensional.add(bidimensional[linhasDeTransicao][j]);
                numeroDePosicoes--;
            }
            linhasDeTransicao++;

            for(int i = linhasDeTransicao ; i < linhaFinal ; i++) {
                matrizUnidimensional.add(bidimensional[i][colunaFinal -1]);
                numeroDePosicoes--;
            }
            colunaFinal--;

            for(int j = (colunaFinal-1) ; j >= colunaDeTransicao; j-- ) {
                matrizUnidimensional.add(bidimensional[linhaFinal -1][j]);
                numeroDePosicoes--;
            }
            linhaFinal--;

            for(int i = (linhaFinal -1 ); i >= linhasDeTransicao; i-- ) {
                matrizUnidimensional.add(bidimensional[i][colunaDeTransicao]);
                numeroDePosicoes--;
            }
            colunaDeTransicao++;
        }
        System.out.println("Finally!!!!!!!!!!!!!!!");
        System.out.println("congratulations for you!!!!!!!!!!!!!!!");
      
        return matrizUnidimensional;
    }
}

package testedois;

import java.util.ArrayList;
import java.util.List;

public class SnailTest {
    public static void main(String ...args) {
        List<Integer> matrizUnidimensional = new ArrayList<>();
        Snail snail = new Snail();
        int linhaColuna = 0;
    
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // int[][] matriz = {
        //     {1, 2, 3, 4},
        //     {5, 6, 7, 8},
        //     {9, 10, 11, 12},
        //     {13, 14, 15, 16}
        // };

        // int[][] matriz = {
        // };


        if(matriz != null) {
            linhaColuna = matriz.length;
        }

        matrizUnidimensional = snail.retornarMatrizOrganizada(matriz, matrizUnidimensional, linhaColuna);

        for(Integer valor : matrizUnidimensional) {
            System.out.println(valor);
        }
    }
}

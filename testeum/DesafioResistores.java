package testeum;

import java.util.HashMap;
import java.util.Map;

public class DesafioResistores {
    public String getCorResistor(String resistor) {
        String resultado;
        StringBuilder builder = new StringBuilder();
        resistor = resistor.replace(" ohms", "");
        resistor = resistor.replace(".", "");
        Map<Integer, String> cor = new HashMap<>();

        cor.put(0, "preto");
        cor.put(1, "marrom");
        cor.put(2, "vermelho");
        cor.put(3, "laranja");
        cor.put(4, "amarelo");
        cor.put(5, "verde");
        cor.put(6, "azul");
        cor.put(7, "violeta");
        cor.put(8, "cinza");
        cor.put(9, "branco");

        resultado = converterResistorParaNumero(resistor);

        if(resultado.length() < 4) {
            for(int i =0 ; (i < resultado.length()) ; i++) {
                if(resultado.charAt(i) == '0' && (resultado.length() - 1) == i) {
                    builder.append(cor.get(resultado.length() > 1 ? resultado.length() - 2 : resultado.length() - 1)).append(" ");
                } else {
                    builder.append(cor.get(( Character.getNumericValue(resultado.charAt(i))))).append(" ");
                }
            }
            builder.append("dourado");
        }

        if(resultado.length() >= 4 && resultado.length() < 7) {
            for(int i =0 ; (i < resultado.length()) ; i++) {
                if(resultado.charAt(i) == '0' && (resultado.charAt(i -1) == '0')) {
                    builder.append(cor.get(resultado.length() - 2)).append(" ");
                    break;
                } else {
                    builder.append(cor.get((Character.getNumericValue(resultado.charAt(i))))).append(" ");
                }
            }
            builder.append("dourado");
        }

        if(resultado.length() >= 7 && resultado.length() < 10) {
            for(int i =0 ; (i < resultado.length()) ; i++) {
                if(resultado.charAt(i) == '0' && (resultado.charAt(i -1) == '0')) {
                    builder.append(cor.get(resultado.length() - 2)).append(" ");
                    break;
                } else {
                    builder.append(cor.get((Character.getNumericValue(resultado.charAt(i))))).append(" ");
                }
            }
            builder.append("dourado");
        }

        return builder.toString();
    }

    private String converterResistorParaNumero(String resistor) {
        Integer conversao;      
      
        if (resistor.endsWith("k")) {
            conversao = Integer.parseInt(resistor.replace("k", ""));
           return (conversao = conversao* 1000).toString();
        } else if (resistor.endsWith("M")) {
            conversao = Integer.parseInt(resistor.replace("M", ""));
           return (conversao = conversao* 1000000).toString();
        }
        
        return resistor;
    }
}

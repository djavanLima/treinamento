package testeum;

public class DesafioResistoresTest {
    public static void main(String ...args) {
        final String[] entradas = {
            "10 ohms",
            "100 ohms",
            "220 ohms",
            "330 ohms",
            "470 ohms",
            "680 ohms",
            "1k ohms",
            "2M ohms"
        };

        DesafioResistores desafioResistores = new DesafioResistores();
        for(String resistor: entradas) {
            System.out.println(desafioResistores.getCorResistor(resistor));
        }
     
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ayudantia2Test {

    private static final double EPSILON = 0.01; // Definir una pequeña cantidad para la precisión

    @Test
    public void testCalcularIMC() {
        // Caso de prueba 1: Datos válidos
        double[] pesos1 = {20.0, 25.0, 30.0};
        double[] alturas1 = {1.0, 1.2, 1.5};
        double[] imc1 = new double[3];
        ayudantia2.calcularIMC(pesos1, alturas1, imc1);
        assertEquals(20.0, imc1[0], EPSILON); // Aproximadamente 20.0
        assertEquals(17.36, imc1[1], EPSILON); // Aproximadamente 17.36
        assertEquals(13.33, imc1[2], EPSILON); // Aproximadamente 13.33

        // Caso de prueba 3: Peso negativo (imc indefinido)
        double[] pesos3 = {20.0, -25.0, 30.0};
        double[] alturas3 = {1.0, 1.2, 1.5};
        double[] imc3 = new double[3];
        ayudantia2.calcularIMC(pesos3, alturas3, imc3);
        assertEquals(20.0, imc3[0], EPSILON); // Aproximadamente 20.0
        assertEquals(13.33, imc3[2], EPSILON); // Aproximadamente 13.33
    }
}

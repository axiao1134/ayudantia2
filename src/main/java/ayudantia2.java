import java.util.Scanner;
import java.util.InputMismatchException;

public class ayudantia2 {
    public static void main(String[] args) {
        String[] nombres = new String[3];
        double[] pesos = new double[3];
        double[] alturas = new double[3];
        double[] imc = new double[3];
        ingresarDatosNinos(nombres, pesos, alturas); // Ingresa los datos de los niños.
        calcularIMC(pesos, alturas, imc); // Calcula el IMC para cada niño.
        imprimirResultados(nombres, pesos, alturas, imc); // Imprime los resultados.
    }

    public static void calcularIMC(double[] pesos, double[] alturas, double[] imc) {
        for (int i = 0; i < pesos.length; i++) {
            imc[i] = pesos[i] / (alturas[i] * alturas[i]);
        }
    }

    public static void imprimirResultados(String[] nombres, double[] pesos, double[] alturas, double[] imc) {
        System.out.println("Resultados:");

        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Niño " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Peso: " + pesos[i] + " kg");
            System.out.println("Altura: " + alturas[i] + " metros");
            System.out.println("IMC: " + imc[i]);
            System.out.print("Estado IMC: ");
            calculadoraIMC(imc[i]); // Llama al método calculadoraIMC para imprimir el estado del IMC.
            System.out.println(); // Línea en blanco para separar los resultados de cada niño.
        }

        // Imprime los promedios de peso y altura.
        System.out.println("Promedio de Peso: " + promedioPeso(pesos) + " kg");
        System.out.println("Promedio de Altura: " + promedioAltura(alturas) + " metros");
    }

    public static void ingresarDatosNinos(String[] nombres, double[] pesos, double[] alturas) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Ingresa el nombre del niño " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            double peso = ingresarPeso(); // Usa tu método ingresarPeso para obtener el peso del niño.
            double altura = ingresarAltura(); // Usa tu método ingresarAltura para obtener la altura del niño.

            // Almacena los datos en los arreglos correspondientes.
            pesos[i] = peso;
            alturas[i] = altura;
        }
    }

    public static double ingresarPeso() {
        Scanner scanner = new Scanner(System.in);
        double peso = 0.0; // Inicializamos la variable peso

        try {
            System.out.println("Ingresa el peso en kg: ");
            peso = scanner.nextDouble();
            if (peso <= 0 || peso > 343) {
                System.out.println("Peso ingresado no válido,for favor, reinicie el programa.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un valor decimal válido, for favor, reinicie el programa.");
        } finally {
            // Consume la nueva línea pendiente
            scanner.nextLine();
        }

        return peso; // Devolvemos el valor de peso ingresado
    }

    public static double ingresarAltura() {
        Scanner scanner = new Scanner(System.in);
        double altura = 0.0;

        try {
            System.out.println("Ingresa la altura en metros: ");
            altura = scanner.nextDouble();
            if (altura <= 0 || altura > 3) {
                System.out.println("Altura ingresada no válida,for favor, reinicie el programa.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un valor decimal válido, for favor, reinicie el programa.");
        } finally {
            // Consume la nueva línea pendiente
            scanner.nextLine();
        }

        return altura;
    }

    public static void calculadoraIMC(double imc) {
        if (imc < 18.5) {
            System.out.println("Bajo peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Normal");
        } else if (imc >= 25 && imc <= 29.9) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obesidad");
        }
    }

    public static double promedioPeso(double[] pesos) {
        double sumaPesos = 0.0;

        for (double peso : pesos) {
            sumaPesos += peso;
        }

        return sumaPesos / pesos.length;
    }

    public static double promedioAltura(double[] alturas) {
        double sumaAlturas = 0.0;

        for (double altura : alturas) {
            sumaAlturas += altura;
        }

        return sumaAlturas / alturas.length;
    }
}



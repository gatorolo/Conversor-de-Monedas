/*import java.util.Scanner;

@SuppressWarnings("ALL")
public class ConvertirMoneda {

    public static void convertir(String from, String to, ConsultarMoneda consulta, Scanner scanner) {

        double cantidad;
        double cantidadConvertida;

        Moneda moneda = consulta.buscarMoneda(from, to);

        System.out.println("Ingrese la cantidad de " + from);
        cantidad = Double.parseDouble(scanner.nextLine());
        cantidadConvertida = cantidad * moneda.conversion_rate();
        System.out.println("La Tasa de conversión de hoy para " +to+ "📈\n 1 "
                + from + " = " + moneda.conversion_rate()+"✔ Checked");
        System.out.println(cantidad + " " + from + " = " + cantidadConvertida + " " + to +"✔");
    }

    public static void convertirMoneda(ConsultarMoneda consulta, Scanner scanner) {
        System.out.println("Ingrese el Código de la moneda a convertir");
        String from = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la moneda destino");
        String to = scanner.nextLine().toUpperCase();
        convertir(from, to, consulta, scanner);
    }
}*/

import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class ConvertirMoneda {

    public static void convertir(String from, String to, ConsultarMoneda consulta, Scanner scanner) {
        double cantidad = 0; // Inicializamos en 0 para tener un valor por defecto
        double cantidadConvertida;
        Moneda moneda = null; // Inicializamos en null

        try {
            moneda = consulta.buscarMoneda(from, to);
            if (moneda == null) {
                System.out.println("Error: No se pudo encontrar información para la conversión de " + from + " a " + to + ".");
                return; // Salimos del método si no se encontró la moneda
            }

            System.out.println("Ingrese la cantidad de " + from);
            try {
                cantidad = scanner.nextDouble();
                if (cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser mayor que cero.");
                    return; // Salimos del método si la cantidad no es válida
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: La cantidad ingresada no es un número válido.");
                scanner.next(); // Limpiamos el buffer del scanner
                return; // Salimos del método si la entrada no es un número
            }
            scanner.nextLine(); // Consumir la nueva línea pendiente

            cantidadConvertida = cantidad * moneda.conversion_rate();
            System.out.println("La Tasa de conversión de hoy para " + to + "📈\n 1 "
                    + from + " = " + moneda.conversion_rate() + "✔ Checked");
            System.out.println(cantidad + " " + from + " = " + cantidadConvertida + " " + to + "✔");

        } catch (RuntimeException e) {
            System.out.println("Error: Ocurrió un problema al obtener la información de la moneda. Por favor, inténtelo de nuevo más tarde.");
            System.out.println("Detalles del error: " + e.getMessage()); // Opcional: para debugging
        }
    }

    public static void convertirMoneda(ConsultarMoneda consulta, Scanner scanner) {
        String from = "";
        String to = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Ingrese el Código de la moneda a convertir (ej: USD)");
            from = scanner.nextLine().toUpperCase();
            if (!from.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Error: El código de la moneda no puede estar vacío.");
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.println("Ingrese la moneda destino (ej: EUR)");
            to = scanner.nextLine().toUpperCase();
            if (!to.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Error: El código de la moneda destino no puede estar vacío.");
            }
        }

        convertir(from, to, consulta, scanner);
    }
}

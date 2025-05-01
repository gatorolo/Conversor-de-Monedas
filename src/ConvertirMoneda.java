import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String from, String to, ConsultarMoneda consulta, Scanner scanner) {

        double cantidad;
        double cantidadConvertida;

        Moneda moneda = consulta.buscarMoneda(from, to);

        System.out.println("Ingrese la cantidad de " + from);
        cantidad = Double.parseDouble(scanner.nextLine());
        cantidadConvertida = cantidad * moneda.conversion_rate();
        System.out.println("La Tasa de conversión de hoy para " +to+ "📈\n 1 "
                + from + " = " + moneda.conversion_rate()+"✔");
        System.out.println(cantidad + " " + from + " = " + cantidadConvertida+"✔");
    }

    public static void convertirMoneda(ConsultarMoneda consulta, Scanner scanner) {
        System.out.println("Ingrese el Código de la moneda a convertir");
        String from = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la moneda destino");
        String to = scanner.nextLine().toUpperCase();
        convertir(from, to, consulta, scanner);
    }


}

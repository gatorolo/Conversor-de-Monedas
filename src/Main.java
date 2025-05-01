import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int option;


        do {
            System.out.println("-------------------------------");
            System.out.println("Ingresa la opción que deseas");
            System.out.println("1. Convertir");
            System.out.println("9. Salir");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("""
                            "conversion_rates Keys 🤑":
                              "USD":Usa,
                              "AED": United Arab Emirates,
                              "AFN":Afghanistan,
                              "ALL":Albania,
                              "AMD": Armenia,
                              "ANG": Curacao y Saint Maarten (Países Bajos Caribeños),
                              "AOA":Angola,
                              "ARS":Argentina,
                              "AUD":Australia,
                              "AWG":Aruba (Países Bajos Caribeños),
                              "AZN":Azerbaiyán,
                              "BAM":Bosnia y Herzegovina,
                              "BBD":Barbados,
                              "BDT":Bangladesh,
                              "BGN":Bulgaria,
                              "BHD": Baréin,
                              "BIF":Burundi,
                              "BMD":Bermudas (Territorio Británico de Ultramar),
                              "BND":Brunéi,
                              "BOB":Bolivia,
                              "BRL":Brasil,
                              "BSD":Bahamas,
                              "BTN":Bután,
                              "BWP":Botsuana,
                              "BYN":Bielorrusia,
                              "BZD":Belice,
                              "CAD":Canadá,
                              "CDF":República Democrática del Congo,
                              "CHF":Suiza y Liechtenstein,
                              "CLP":Chile,
                              "CNY": China,
                              "COP": Colombia,
                              "CRC":Costa Rica,
                              "CUP":Cuba,
                              "CVE":Cabo Verde,
                              "CZK":República Checa,
                              "DJF":Yibuti,
                              "DKK":Dinamarca, Groenlandia e Islas Feroe,
                              "DOP": República Dominicana,
                              "DZD":Argelia,
                              "EGP":Egipto,
                              "ERN": Eritrea,
                              "ETB":Etiopía,
                              "EUR":Zona Euro (muchos países de Europa),
                              "FJD":Fiyi,
                              "FKP":Islas Malvinas (Argentina),
                              "FOK":Islas Feroe (parte del Reino de Dinamarca),
                              "GBP":Reino Unido,
                              "GEL":Georgia,
                              "GGP":Guernsey (Dependencia de la Corona Británica),
                              "GHS": Ghana,
                              "GIP": Gibraltar (Territorio Británico de Ultramar),
                              "GMD":Gambia,
                              "GNF": Guinea,
                              "GTQ":Guatemala,
                              "GYD":Guyana,
                              "HKD":Hong Kong (Región Administrativa Especial de China),
                              "HNL":Honduras,
                              "HRK":Croacia (reemplazado por el EUR en 2023),
                              "HTG":Haití,
                              "HUF":Hungría,
                              "IDR":Indonesia,
                              "ILS":Israel,
                              "IMP":Isla de Man,
                              "INR":India,
                              "IQD":Irak,
                              "IRR":Irán,
                              "ISK":Islandia,
                              "JEP":Jersey,
                              "JMD":Jamaica,
                              "JOD":Jordania,
                              "JPY":Japón,
                              "KES":Kenia,
                              "KGS":Kirguistán,
                              "KHR":Camboya,
                              "KID":Kiribati,
                              "KMF":Comoras,
                              "KRW":Corea del Sur,
                              "KWD":Kuwait,
                              "KYD":Islas Caimán,
                              "KZT": Kazajistán,
                              "LAK":Laos,
                              "LBP":89500.0000,
                              "LKR":299.2235,
                              "LRD":199.8420,
                              "LSL":18.5792,
                              "LYD":5.4554,
                              "MAD":9.2595,
                              "MDL":17.1443,
                              "MGA":4457.7403,
                              "MKD":54.0956,
                              "MMK":2098.1932,
                              "MNT":3563.3333,
                              "MOP":7.9887,
                              "MRU":39.6852,
                              "MUR":45.0326,
                              "MVR":15.4452,
                              "MWK":1738.0973,
                              "MXN":19.5871,
                              "MYR":4.3154,
                              "MZN":63.8548,
                              "NAD":18.5792,
                              "NGN":1601.6158,
                              "NIO":36.7672,
                              "NOK":10.3942,
                              "NPR":135.5454,
                              "NZD":1.6853,
                              "OMR":0.3845,
                              "PAB":1.0000,
                              "PEN":3.6684,
                              "PGK":4.0874,
                              "PHP":55.8252,
                              "PKR":280.9017,
                              "PLN":3.7657,
                              "PYG":8017.9799,
                              "QAR":3.6400,
                              "RON":4.3774,
                              "RSD":103.0279,
                              "RUB":81.7135,
                              "RWF":1444.6677,
                              "SAR":3.7500,
                              "SBD":8.5189,
                              "SCR":14.4992,
                              "SDG":543.8693,
                              "SEK":9.6598,
                              "SGD":1.3061,
                              "SHP":0.7497,
                              "SLE":22.7249,
                              "SLL":22724.9437,
                              "SOS":571.1500,
                              "SRD":36.6899,
                              "SSP":4534.6828,
                              "STN":21.6021,
                              "SYP":12931.2691,
                              "SZL":18.5792,
                              "THB":33.3806,
                              "TJS":10.5540,
                              "TMT":3.4997,
                              "TND":2.9690,
                              "TOP":2.3838,
                              "TRY":38.5190,
                              "TTD":6.7615,
                              "TVD":1.5627,
                              "TWD":31.9700,
                              "TZS":2673.9172,
                              "UAH":41.4728,
                              "UGX":3657.8320,
                              "UYU":42.0421,
                              "UZS":12918.6656,
                              "VES":87.5681,
                              "VND":25988.3961,
                              "VUV":120.4543,
                              "WST":2.7782,
                              "XAF":578.3684,
                              "XCD":2.7000,
                              "XCG":1.7900,
                              "XDR":0.7369,
                              "XOF":578.3684,
                              "XPF":105.2170,
                              "YER":244.6058,
                              "ZAR":18.5788,
                              "ZMW":27.9038,
                              "ZWL":26.8158
                             }
                            """);
                    ConvertirMoneda.convertirMoneda(consulta, scanner);
                    break;
                case 9:
                    System.out.println("Gracias por utilizar ExchangeRateAPI 👍");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 9);
        scanner.close();
    }
}




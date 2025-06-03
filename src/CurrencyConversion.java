import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> exchangeRates = new HashMap<>();

        exchangeRates.put("USD", 0.85);
        exchangeRates.put("JPY", 110.50);
        exchangeRates.put("GBP", 0.90);
        exchangeRates.put("AUD", 1.45);
        exchangeRates.put("CAD", 1.32);
        exchangeRates.put("SEK", 9.70);
        exchangeRates.put("DKK", 7.45);
        exchangeRates.put("CHF", 1.12);
        exchangeRates.put("PLN", 4.93);
        exchangeRates.put("CZK", 24.39);

        List<String> currencies = new ArrayList<>(exchangeRates.keySet());

        System.out.println("Verfügbare Währungen: ");

        int columnCount = 3;
        int rowCount = (currencies.size() + columnCount - 1) / columnCount;

        for (int i = 0; i < rowCount; i++) {

            System.out.printf("%3d. %-4s", i + 1, currencies.get(i));

            if (i + rowCount < currencies.size()) {
                System.out.printf("%3d. %-4s", i + rowCount + 1, currencies.get(i));
            } else {
                System.out.println(" ");
            }

            if (i + 2 * rowCount < currencies.size()) {
                System.out.printf("%3d. %-4s%n", i + 2 * rowCount + 1, currencies.get(i));
            } else {
                System.out.println(" ");
            }
        }

        String currency = selectCurrency(scanner, currencies);

        BigDecimal amount = enteredAmount(scanner);

        showResult(currency, exchangeRates, amount);

        scanner.close();
    }

    private static String selectCurrency(Scanner scanner, List<String> currencies) {
        System.out.println("Wählen Sie eine Zahl (1 - " + currencies.size() + "): ");

        while (true) {
            try {
                int index = Integer.parseInt(scanner.nextLine());

                if (index >= 1 && index <= currencies.size()) {
                    return currencies.get(index - 1);
                }

                System.out.println("Bitte eine Zahl zwischen 1 und " + currencies.size() + " eingeben.");
            } catch (NumberFormatException e) {
                System.out.println("Nur Nummern sind zur Eingabe verfügbar.");
            }
        }
    }

    private static BigDecimal enteredAmount(Scanner scanner) {
        System.out.println("Geben Sie den Betrag in EUR ein: ");

        while (true) {
            try {
                String summa = scanner.nextLine().replace(',', '.');

                if (summa.isEmpty()) {
                    System.out.println("Das Eingabefeld darf nicht leer sein");
                    continue;
                }

                BigDecimal amount = new BigDecimal(summa);

                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    return amount;
                }

                System.out.println("Betrag muss größer als 0 sein.");
            } catch (NumberFormatException e) {
                System.out.println("Nur Nummern sind zur Eingabe verfügbar.");
            }
        }
    }

    private static void showResult(String currency, Map<String, Double> exchangeRates, BigDecimal amount) {
        BigDecimal currencyAmount = BigDecimal.valueOf(exchangeRates.get(currency));
        BigDecimal calculatedAmount = amount.multiply(currencyAmount).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Ergebnis: %n%.2f EUR = %.2f %s", amount, calculatedAmount, currency);
    }
}


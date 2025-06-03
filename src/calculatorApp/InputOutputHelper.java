package calculatorApp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputOutputHelper {
    private final Scanner scanner = new Scanner(System.in);

    public double inputDouble(String infoText) {
        System.out.println(infoText);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Nur Nummern sind zur Eingabe verfügbar. Bitte " +
                        Character.toLowerCase(infoText.charAt(0)) + infoText.substring(1));
            }
        }
    }

    public int inputInteger(String infoText, List<Integer> keys, Map<Integer, String> availableOperations) {
        System.out.println(infoText);

        for (Integer key : keys) {
            System.out.printf("%d. %s%n", key, availableOperations.get(key));
        }

        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number <= 0 || number > keys.size()) {
                    throw new IllegalArgumentException("Der ausgewählte Vorgang existiert nicht oder ist nicht vorhanden.");
                }

                return number;

            } catch (NumberFormatException e) {
                System.out.println("Nur Nummern sind zur Eingabe verfügbar. Bitte " +
                        Character.toLowerCase(infoText.charAt(0)) + infoText.substring(1));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Bitte " +
                        Character.toLowerCase(infoText.charAt(0)) + infoText.substring(1));
            }
        }
    }

    public void result(double result) {
        if (result == (long) result) {
            System.out.println("Ergebnis: " + (long) result);
        } else {
            System.out.println("Ergebnis: " + result);
        }
    }

    public boolean isContinue(String text) {
        System.out.println(text);
        String answer = scanner.nextLine();
        return "Ja".equalsIgnoreCase(answer);
    }

    public void close() {
        scanner.close();
    }
}

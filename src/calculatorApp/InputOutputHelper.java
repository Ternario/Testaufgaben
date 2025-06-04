package calculatorApp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

//  Es wird eine Hilfsklasse erstellt, in der Methoden zur Verarbeitung von Eingabe- und Ausgabewerten
//  sowie zur Beendigung des Programms definiert werden.
public class InputOutputHelper {
    private final Scanner scanner = new Scanner(System.in);

    //  Funktion (Klassenmethode) zur Verarbeitung von Eingabewerten (Zahlen).
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

    //  Funktion (Klassenmethode) zur Verarbeitung der vom Benutzer eingegebenen Nummer der mathematischen Operation.
    public int inputInteger(String infoText, List<Integer> keys, Map<Integer, String> availableOperations) {
        System.out.println(infoText);

        for (Integer key : keys) {
            System.out.printf("%d. %s%n", key, availableOperations.get(key));
        }

        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number <= 0 || number > keys.size()) {
                    throw new IllegalArgumentException("Der ausgewählte Vorgang existiert nicht " +
                            "oder ist nicht vorhanden.");
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

    //  Funktion (Klassenmethode) für eine schönere Ausgabe von Ganzzahlen.
    public void result(double result) {
        if (result == (long) result) {
            System.out.println("Ergebnis: " + (long) result);
        } else {
            System.out.println("Ergebnis: " + result);
        }
    }

    //  Eine Funktion (Klassenmethode) zur Fortsetzung oder Beendigung des Programms.
    public boolean isContinue(String text) {
        System.out.println(text);
        String answer = scanner.nextLine();
        return "Ja".equalsIgnoreCase(answer);
    }

    public void close() {
        scanner.close();
    }
}

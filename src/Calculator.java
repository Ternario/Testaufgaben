import java.util.*;
import java.util.Collections;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }

    public void start() {
        InputOutputHelper inpOutHelper = new InputOutputHelper();
        CalculatorFunctions calculatorFunctions = new CalculatorFunctions(inpOutHelper);

        Map<Integer, String> availableOperations = new HashMap<>();
        {
            availableOperations.put(1, "Addition (+)");
            availableOperations.put(2, "Subtraction (-)");
            availableOperations.put(3, "Multiplication (*)");
            availableOperations.put(4, "Division (/)");
            availableOperations.put(5, "Modulo (%)");
            availableOperations.put(6, "Exponential (^)");
        }

        List<Integer> keys = new ArrayList<>(availableOperations.keySet());
        Collections.sort(keys);


        boolean isContinueFlag = true;

        while (isContinueFlag) {
            double firstNumb = inpOutHelper.inputDouble("Geben Sie die erste Zahl ein: ");

            int operator = inpOutHelper.inputInteger("Wählen Sie einen der verfügbaren Vorgänge: 1 - " + keys.size(), keys, availableOperations);

            double secondNumb = inpOutHelper.inputDouble("Geben Sie die zweite Zahl ein: ");

            double result = calculations(firstNumb, secondNumb, operator, calculatorFunctions);

            inpOutHelper.result(result);

            isContinueFlag = inpOutHelper.isContinue("Möchten Sie weiterfahren? (Ja/Nein oder drücken Sie die Leertaste.)");
        }

        inpOutHelper.close();
    }

    private double calculations(double firstNumb, double secondNumb, int operator, CalculatorFunctions calculatorFunctions) {
        switch (operator) {
            case 1:
                return calculatorFunctions.addition(firstNumb, secondNumb);
            case 2:
                return calculatorFunctions.substraction(firstNumb, secondNumb);
            case 3:
                return calculatorFunctions.multiplication(firstNumb, secondNumb);
            case 4:
                return calculatorFunctions.division(firstNumb, secondNumb);
            case 5:
                return calculatorFunctions.modulo(firstNumb, secondNumb);
            case 6:
                return calculatorFunctions.exponential(firstNumb, secondNumb);
            default:
                throw new IllegalArgumentException("Der ausgewählte Vorgang existiert nicht oder ist nicht vorhanden.");
        }
    }
}

class InputOutputHelper {
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

class CalculatorFunctions {
    private final InputOutputHelper inpOutHelper;

    public CalculatorFunctions(InputOutputHelper inpOutHelper) {
        this.inpOutHelper = inpOutHelper;
    }

    public double addition(double a, double b) {
        return a + b;
    }

    public double substraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        while (true) {
            try {
                if (b == 0) {
                    throw new ArithmeticException("Division durch 0 ist nicht erlaubt.");
                }

                return a / b;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                b = inpOutHelper.inputDouble("Geben Sie eine Zahl größer als 0 ein.");
            }
        }
    }

    public double modulo(double a, double b) {
        while (true) {
            try {
                if (b == 0) {
                    throw new ArithmeticException("Modulation mit 0 ist nicht erlaubt.");
                }

                return a % b;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                b = inpOutHelper.inputDouble("Geben Sie eine Zahl größer als 0 ein.");
            }
        }
    }

    public double exponential(double a, double b) {
        return Math.pow(a, b);
    }
}
package calculatorApp;

import java.util.*;
import java.util.Collections;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorApp calculator = new CalculatorApp();
        calculator.start();
    }

    public void start() {
        InputOutputHelper inpOutHelper = new InputOutputHelper();
        MathOperations mathOperations = new MathOperations(inpOutHelper);

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

            double result = calculate(firstNumb, secondNumb, operator, mathOperations);

            inpOutHelper.result(result);

            isContinueFlag = inpOutHelper.isContinue("Möchten Sie weiterfahren? (Ja/Nein oder drücken Sie die Leertaste.)");
        }

        inpOutHelper.close();
    }

    private double calculate(double firstNumb, double secondNumb, int operator, MathOperations mathOperations) {
        switch (operator) {
            case 1:
                return mathOperations.addition(firstNumb, secondNumb);
            case 2:
                return mathOperations.substraction(firstNumb, secondNumb);
            case 3:
                return mathOperations.multiplication(firstNumb, secondNumb);
            case 4:
                return mathOperations.division(firstNumb, secondNumb);
            case 5:
                return mathOperations.modulo(firstNumb, secondNumb);
            case 6:
                return mathOperations.exponential(firstNumb, secondNumb);
            default:
                throw new IllegalArgumentException("Der ausgewählte Vorgang existiert nicht oder ist nicht vorhanden.");
        }
    }
}


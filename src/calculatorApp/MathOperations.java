package calculatorApp;

//  Eine Klasse mit verfügbaren mathematischen Operationen wird erstellt.
public class MathOperations {
    private final InputOutputHelper inpOutHelper;

    public MathOperations(InputOutputHelper inpOutHelper) {
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

public interface CalculatorStrategy {

    double calculate(double a, double b);
}

class AdditionStrategy implements CalculatorStrategy {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

class SubtractionStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

class MultiplicationStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

class DivisionStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double a, double b) {
        if(b == 0){
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}

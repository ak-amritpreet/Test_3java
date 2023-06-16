public class Calculator01 {
    public static float ADD(float a, float b) {
        return a + b;
    }

    public static float SUBTRACT(float a, float b) {
        return a - b;
    }

    public static float MULTIPLY(float a, float b) {
        return a * b;
    }

    public static float DIVIDE(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}

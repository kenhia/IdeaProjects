package com.kenhia.calcengine;

public class Main {

    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        for (int i = 0; i < opCodes.length; i++) {
            switch (opCodes[i]) {
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                case 'd':
                    results[i] = (rightVals[i] == 0) ? Float.NaN : leftVals[i] / rightVals[i];
                    if (rightVals[i] == 0) System.err.println("Error - divide by zero");
                    break;
                default:
                    System.err.println("Error - invalid opCode");
                    results[i] = Float.NaN;
                    break;
            }
        }

        for (double result : results)
            System.out.println(result);
        System.out.println(factorial(5));

        float[] theVals = {10.0f, 20.0f, 15.5f};
        float sum = 0.0f;
        for (float val : theVals) {
            sum += val;
        }
        System.out.println(sum);
    }

    private static long factorial(int n) {
        if (n > 39) {
            System.err.println("factorial(n) for n > 39 overflows");
            return -1;
        }

        long f = 1;
        while (n > 1) {
            f *= n;
            n--;
        }
        return f;
    }
}

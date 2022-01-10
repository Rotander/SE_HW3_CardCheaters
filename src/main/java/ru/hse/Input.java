package ru.hse;

import java.util.Scanner;

/**
 * Input processing.
 */
class Input {
    /**
     * Number input mechanism.
     *
     * @param min    minimum number to input
     * @param output message to be print
     * @return input number or minimum
     */
    static int inputCount(int min, String output) {
        int result;
        do {
            System.out.print(output);
            result = validateNumber(min - 1);
        } while (result <= min - 1 || result > 100);
        return result;
    }

    /**
     * Check what is input.
     *
     * @param min minimum number to input
     * @return input number or minimum
     */
    private static int validateNumber(int min) {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (RuntimeException e) {
            return min;
        }
    }
}

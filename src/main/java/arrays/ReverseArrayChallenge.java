package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 7, 11, 9, 15, 16};

        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed Array = " + Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }

    }
}

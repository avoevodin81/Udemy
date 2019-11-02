package politechnica;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        float xMin, xMax, deltaX, a, step;

        xMin = 15;
        xMax = 200;
        deltaX = abs(xMax - xMin);
        step = deltaX / 10;

        for (float i = xMin; i <= xMax; i+=step) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println(deltaX);
    }
}
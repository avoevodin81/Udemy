package politechnica;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        print(sort(new int[]{9, 5, 8, 1, 0}));
    }

    public static int[] sort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            //сохраняем во временную переменную текущий элемент массива
            int temp = mas[i];
            //создаем индекс для прохода по отсортированной части
            int j = i - 1;
            //проверяем что индекс сортированной части массива в диапазоне
            //проверяем что элемент с текущим индексом больше элемента
            // из неотсортированной части
            while (j >= 0 && mas[j] > temp) {
                //присваевам значение следующему элементу текущего,
                // подготавливаем место под вставку
                mas[j + 1] = mas[j];
                //уменьшаем индекс отсортированной части на 1
                j --;
                //вставляем элемент из неотсортированной части в отсортированную
                mas[j + 1] = temp;
            }
        }
        return mas;
    }

    public static void print(int[] mas) {
        for (Integer i : mas) {
            System.out.print(i + " ");
        }
    }
}
package zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\tursu\\IdeaProjects\\roza\\src\\zadanie1\\a.txt";

        // Создаем и запускаем поток для вычисления суммы первого массива
        Thread sumThread1 = new Thread(() -> {
            double sum1 = calculateSum(readArrayFromFile(fileName, 0));
            System.out.println("Сумма первого массива: " + sum1);
        });
        sumThread1.start();

        // Создаем и запускаем поток для вычисления суммы второго массива
        Thread sumThread2 = new Thread(() -> {
            double sum2 = calculateSum(readArrayFromFile(fileName, 1));
            System.out.println("Сумма второго массива: " + sum2);
        });
        sumThread2.start();

        // Ждем завершения потоков вычисления суммы
        try {
            sumThread1.join();
            sumThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вычисляем произведение сумм
        double product = calculateSum(readArrayFromFile(fileName, 0)) * calculateSum(readArrayFromFile(fileName, 1));
        System.out.println("Произведение сумм: " + product);
    }

    private static double[] readArrayFromFile(String fileName, int lineNumber) {
        double[] array = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i <= lineNumber; i++) {
                String line = reader.readLine();
                if (i == lineNumber) {
                    String[] elements = line.split(" ");
                    array = new double[elements.length];
                    for (int j = 0; j < elements.length; j++) {
                        array[j] = Double.parseDouble(elements[j]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static double calculateSum(double[] array) {
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        return sum;
    }
}

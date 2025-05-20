import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размерность матрицы: ");
        int a = scanner.nextInt();
        int[][] matrix = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                matrix[i][j] = random.nextInt(0, 10);
            }
        }

        System.out.println("Оригинальная матрица:\n" + printMatrix(matrix));
        //-----------------------------------------------------------------------------------------
        //2.1
        int[][] resMatrix = matrix.clone();
        for (int i = 0; i < resMatrix.length; i++) {
            resMatrix[i][i] *= resMatrix[i][i];
        }
        System.out.println("Главная диагональ возведенная в квадрат:\n" + printMatrix(resMatrix));
        //-----------------------------------------------------------------------------------------
        //2.3
        List<Integer> list = new ArrayList<>();
        for (int[] i : matrix) {
            for (int j : i) {
                if (j % 2 == 0)
                    list.add(j);
            }
        }

        System.out.println("Одномерный массив из четных элементов: " + list);

    }

    public static String printMatrix(int[][] matrix) {
        String res = "";
        for (int[] a : matrix) {
            for (int b : a) {
                res += b + " ";
            }
            res += "\n";
        }
        return res;
    }
}

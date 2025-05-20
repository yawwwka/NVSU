import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Введите размерность массива: ");
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(-10, 10);

        //Вывод оригинального массива
        System.out.println("Оригинальный массив: " + printArr(arr));

        //-----------------------------------------------------------------------------------------
        //1.1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
                if (arr[i] % 10 == 5)
                    list.add(1);
            }
        }

        System.out.println("Массив без нулей и с заменой: " + list);
        //-----------------------------------------------------------------------------------------
        //1.2
        System.out.print("Введите начало промежутка: ");
        int a = scanner.nextInt();
        System.out.print("Введите конец промежутка: ");
        int b = scanner.nextInt();

        int[] resArr = arr.clone();

        for (int i = a; i < b; i++) {
            if (arr[i] % 2 == 0 && i >= 1 && i <= arr.length - 1) {
                resArr[i] = resArr[i - 1] + resArr[i + 1];
            }
        }

        System.out.println("Замена на сумму соседей в промежутке: " + printArr(resArr));
        //-----------------------------------------------------------------------------------------
        //1.3
        System.out.print("Введите минимум: ");
        int min = scanner.nextInt();
        System.out.print("Введите максимум: ");
        int max = scanner.nextInt();
        max = max > arr.length ? arr.length : max;
        resArr = new int[arr.length - (max - min)];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!(i >= min && i < max))
                resArr[count++] = arr[i];
        }
        System.out.println("Массив с удаленными значениями в указанном промежутке: " + printArr(resArr));
        //-----------------------------------------------------------------------------------------
        //1.4
        resArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            resArr[i] = arr[arr.length - i - 1];
        }

        System.out.println("Перевернутый массив: " + printArr(resArr));

        //-----------------------------------------------------------------------------------------
        //1.5
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && i % 2 == 0)
                count++;
        }

        System.out.println("Количество четных элементов на четных местах: " + count);
        //-----------------------------------------------------------------------------------------
        //1.6
        int firstElement = arr[0] % 10;
        System.out.print("Индексы элементов, которые содержат два раза последнюю цифру первого числа: ");
        int[][] digits = getDigitsList(arr);
        for (int i = 0; i < digits.length; i++) {
            count = 0;
            for (int j = 0; j < digits[i].length; j++) {
                if (digits[i][j] == firstElement) {
                    count++;
                }
            }
            if (count == 2)
                System.out.print(i + " ");
        }
        //-----------------------------------------------------------------------------------------
        //1.7
        System.out.print("\nИндексы элементов кратных трем и пяти: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0 && arr[i] % 5 == 0)
                System.out.print(i + " ");
        }
        //-----------------------------------------------------------------------------------------
        //1.8
        System.out.print("\nВведите цифру, количество которой нужно вывести: ");
        a = scanner.nextInt();
        count = 0;

        for (int[] digit : digits) {
            for (int number : digit) {
                if (number == a)
                    count++;
            }
        }

        System.out.printf("Цифра %d встречается в массиве %d раз \n", a, count);

        //-----------------------------------------------------------------------------------------
        //1.9
        System.out.print("Элементы, которые встречаются больше одного раза: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    System.out.print(arr[i] + " ");
            }
        }
        //-----------------------------------------------------------------------------------------
        //1.10
        System.out.print("\nЧисла, для которых a(i) >= i: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= i) {
                System.out.print(arr[i] + " ");
            }
        }
        //-----------------------------------------------------------------------------------------
        //1.11
        System.out.print("\nЭлементы, индексы которых являются степенями двойки: ");
        for (int i = 0; i < arr.length; i = (int) Math.pow(2, i++)) {
            System.out.print(arr[i] + " ");
        }
        //-----------------------------------------------------------------------------------------
        //1.12
        System.out.print("\nВведите K: ");
        a = scanner.nextInt();
        int lessK = 0,
                equalsK = 0,
                moreK = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > a)
                moreK++;
            else if (arr[i] < a)
                lessK++;
            else
                equalsK++;
        }
        System.out.printf("Чисел, меньших K: %d\n"
                + "Чисел, равных K: %d\n"
                + "Чисел, больших K: %d\n", lessK, equalsK, moreK);
        //-----------------------------------------------------------------------------------------
        //1.13
        count = 0;
        boolean isPositive = arr[0] >= 0;

        System.out.print("Индексы элементов, в которых меняется знак: ");
        for (int i = 0; i < arr.length; i++) {
            if (isPositive != arr[i] >= 0) {
                System.out.print(arr[i] + " ");
                isPositive = arr[i] >= 0;
                count++;
            }
        }
        System.out.println("\nЗнак поменялся " + count + " раз");
        //-----------------------------------------------------------------------------------------
        //1.14
        a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isSimple(i)) {
                a += arr[i];
            }
        }
        System.out.println("Сумма чисел, порядковые номера которых - простые числа: " + a);
        //-----------------------------------------------------------------------------------------
        //1.15
        System.out.print("Введите начало промежутка: ");
        a = scanner.nextInt();
        System.out.print("Введите конец промежутка: ");
        b = scanner.nextInt();

        System.out.print("Элементы в промежутке: ");
        for (int i = a; i <= b; i++) {
            System.out.print(arr[i] + " ");
        }
        //-----------------------------------------------------------------------------------------
        //1.16
        resArr = arr.clone();
        bubbleSort(resArr);
        System.out.println("\nОтсортированный массив: " + printArr(resArr));
        //-----------------------------------------------------------------------------------------
        //1.17
        System.out.print("Введите X: ");
        a = (int) Math.pow(scanner.nextInt(), 2);

        System.out.print("Индексы чисел, которые являются квадратом числа X: ");
        for (int i = 0; i < arr.length; i++) {
            if (a == arr[i]) {
                System.out.print(i + " ");
            }
        }
        //-----------------------------------------------------------------------------------------
        //1.18
        count = 0;
        int mx = -1;
        int mx_digit = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > mx) {
                mx = count;
                mx_digit = arr[i];
            } else if (count == mx) {
                mx_digit = Math.min(arr[i], mx_digit);
            }
        }
        System.out.println("\nНаиболее часто встречающееся число - " + mx_digit);
        //-----------------------------------------------------------------------------------------
        //1.19
        resArr = new int[(arr.length + 1) / 2];
        for (int i = 0; i < (arr.length + 1) / 2; i++) {
            resArr[i] = arr[i * 2];
        }
        System.out.println("Сжатый массив: " + printArr(resArr));
        //-----------------------------------------------------------------------------------------
        //1.20
        list.clear();
        System.out.print("Введите K: ");
        a = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == a)
                list.add(arr[i]);
        }
        System.out.println("Массив, элементы которого оканчиваются на K: " + list);
        //-----------------------------------------------------------------------------------------
        //1.21
        System.out.print("Введите X: ");
        a = scanner.nextInt();
        resArr = new int[2];
        mx = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(a - ((arr[i] + arr[j]) / 2)) < mx) {
                    resArr[0] = arr[i];
                    resArr[1] = arr[j];
                    mx = Math.abs(a - ((arr[i] + arr[j]) / 2));
                }
            }
            if (mx == 0)
                break;
        }
        System.out.println("Два числа, среднее арифметическое которых ближе всего к X: " + printArr(resArr));
        //-----------------------------------------------------------------------------------------
        //1.22
        resArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            resArr[i] = random.nextInt(-10, 10);

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == resArr[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Массив A: " + printArr(arr) +
                "\nМассив B: " + printArr(resArr) +
                "\nКоличество совпадающих элементов: " + count);
    }

    public static String printArr(int[] arr) {
        String res = "";
        for (int n : arr)
            res += String.valueOf(n) + " ";
        return res;
    }

    public static int[][] getDigitsList(int[] arr) {
        int[][] digits = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            int length = String.valueOf(arr[i]).length();
            digits[i] = new int[length];

            int mod = (int) Math.pow(10, length);
            int div = (int) Math.pow(10, length - 1);
            for (int j = 0; j < length; j++) {
                digits[i][j] = arr[i] % mod / div;
                mod /= 10;
                div /= 10;
            }
        }
        return digits;
    }

    public static boolean isSimple(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }
}

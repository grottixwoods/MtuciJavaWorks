public class Task1 {
    public static double remainder(double a, double b) {
        return a % b; // Реализация задания 1
    }

    public static double triArea(double a, double h) {
        return (a / 2) * h; // Реализация задания 2
    }

    public static int animals(int chicken, int cows, int pigs) {
        return chicken * 2 + cows * 4 + pigs * 4; // Реализация задания 3
    }

    public static boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay; // Реализация задания 4
    }

    public static String operation(int N, int a, int b) {
        if (a + b == N) {
            return "added";
        } else if (a - b == N) {
            return "subtracted";
        } else if (a * b == N) {
            return "multiplied";
        } else if (a / b == N) {
            return "divided";
        } else {
            return "none"; // Реализация задания 5
        }
    }

    public static int ctoa(char c) {
        return (int) c; // Реализация задания 6
    }

    public static int addUpTo(int a) {
        if (a == 1) {
            return 1;
        } else {
            return a + addUpTo(a - 1); // Реализация задания 7
        }
    }

    public static int nextEdge(int a, int b) {
        return a + b - 1; // Реализация задания 8
    }

    public static double sumOfCubes(double[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i] * arr[i];
        }

        return sum; // Реализация задания 9
    }

    public static boolean abcmath(double a, double b, double c) {
        for (int i = 0; i < b; i++) {
            a += a;
        }

        return a % c == 0; // Реализация задания 10
    }
}

class Main { // Реализация функции вывода для сокращения написания
    public static void Out(String str) {
        System.out.println(str);
    }

    public static void Out(double str) {
        System.out.println(str);
    }

    public static void Out(boolean str) {
        System.out.println(str);
    }

    public static void main(String[] args) { // Вывод результата заданий с 1 по 10
        Out(Task1.remainder(3, 5));
        Out(Task1.triArea(5, 4));
        Out(Task1.animals(3, 5, 2));
        Out(Task1.profitableGamble(0.8, 3, 10));
        Out(Task1.operation(25, 13, 12));
        Out(Task1.ctoa('A'));
        Out(Task1.addUpTo(10));
        Out(Task1.nextEdge(13, 25));
        Out(Task1.sumOfCubes(new double[]{10, 20, 30}));
        Out(Task1.abcmath(10, 3, 15));
    }
}

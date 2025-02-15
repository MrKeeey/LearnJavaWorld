package PracticeTasks;

public class LC2698_punishmentNumber {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (isValid(i, square)) {
                sum += square;
            }
        }

        return sum;
    }

    private boolean isValid(int num, int square) {
        if (num < 0 || square < num) return false;
        if (num == square) return true;

        return (
                isValid(num - (square % 10), square / 10) ||
                isValid(num - (square % 100), square / 100) ||
                isValid(num - (square % 1000), square / 1000)
        );
    }

    public static void main(String[] args) {
        System.out.println(new LC2698_punishmentNumber().punishmentNumber(10));
    }
}

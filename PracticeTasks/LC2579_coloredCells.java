package PracticeTasks;

public class LC2579_coloredCells {

    //ofc faster
    public long coloredCells(int n) {
        return 1 + n * (n - 1) * 2L;
    }

    public long coloredCells2(int n) {
        long result = 1;
        while (n > 1) {
            result += 4L * --n;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC2579_coloredCells().coloredCells(4));
        System.out.println(new LC2579_coloredCells().coloredCells2(4));
    }
}

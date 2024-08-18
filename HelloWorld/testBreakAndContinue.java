package HelloWorld;

public class testBreakAndContinue {
    public static void main(String[] args) {

        int count = 0;
        while (count <= 20) {
            count++;
            if ((count % 7) == 0) {
                continue;
            }
            System.out.print(count + " ");
        }
        System.out.println();

        count = 0;
        while (count <= 20) {
            count++;
            if ((count % 7) == 0) {
                break;
            }
            System.out.print(count + " ");
        }
        System.out.println();

        for (int i = 1; i <= 20; i++) {
            if (i % 7 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        for (int j = 1; j <= 20; j++) {
            if (j % 7 == 0) {
                break;
            }
            System.out.print(j + " ");
        }
    }
}

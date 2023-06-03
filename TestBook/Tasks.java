package TestBook;
public class Tasks {
    public static void main(String[] args) {
        int i = 3;

        while (i > 0){
            if (i > 2) System.out.print("a");
            i--;
            System.out.print("-");
            if (i == 2) System.out.print("b c");
            if (i == 1) {
                System.out.print("d");
                i--;
            }
        }
        System.out.println();
        int x = 0, y = 0;
        while (x < 5){
            y = x - y;
            System.out.print(x + "" + y + " ");
            x++;
        }
        System.out.println();
        x = 0;
        y = 0;
        while (x < 5){
            y = y + x;
            System.out.print(x + "" + y + " ");
            x++;
        }
        System.out.println();
        x = 0;
        y = 0;
        while (x < 5){
            y = y + 2;
            if (y > 4) y--;
            System.out.print(x + "" + y + " ");
            x++;
        }
        System.out.println();
        x = 0;
        y = 0;
        while (x < 5){
            x++;
            y = y + x;
            System.out.print(x + "" + y + " ");
            x++;
        }
        System.out.println();
        x = 0;
        y = 0;
        while (x < 5){
            if (y < 5){
                x++;
                if (y < 3) x--;
            }
            y = y + 2;
            System.out.print(x + "" + y + " ");
            x++;
        }
    }
}

public class WhileForIF {
    public static void main(String[] args) {
        int x = 15, y = 0;
        char[] arr = {'z', 'y', 'k'};

        //while
        while (x > 10){
            x--;
            y++;
        }
        System.out.println("Now x = " + x + ", y = " + y);

        //do while
        do {
            x--;
        } while (x != 0);
        System.out.println("Now x = " + x + ", y = " + y);

        //for + if else
        for ( int i = 0; i < 5 ; i++){
            System.out.print("i = " + i + "; ");
            if (i == 2){
                x++;
            } else {
                y--;
            }
        }
        System.out.println("\nNow x = " + x + ", y = " + y);

        //foreach + if else if
        for (char j : arr){
            System.out.print(j);
            if (j == 'y') {
                System.out.println("\nFound y");
                x--;
                y--;
            } else if (j == 'z') {
                System.out.println("\nFound z");
                x++;
                y++;
            } else {
                System.out.println("\nFound k");
                x = x * 5;
                y = y / 10;
            }
        }
        System.out.println("Now x = " + x + ", y = " + y);
    }
}

package HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        //HelloWorld + charAt / substring
        String HW = "Hello World";
        System.out.println("Hello World!");
        System.out.print("Hello World!".charAt(1) + " ");
        System.out.println("Hello World!".substring(10, 11));
        System.out.print(HW.charAt(1) + " ");
        System.out.println(HW.substring(10, 11));

        //Goodbye world backwards chartAt
        String GW = "Goodbye World!";
        for (int i = GW.length(); i > 0; i--){
            System.out.print(GW.charAt(i - 1));
        }
        System.out.println();
        StringBuilder str = new StringBuilder(GW);
        System.out.println(str.reverse());

        //HelloWorld backwards substring
        for (int i = "Hello World!".length(); i > 0; i--){
            System.out.print("Hello World!".substring(i - 1, i));
        }
        System.out.println();
        str = new StringBuilder("Hello World!");
        System.out.println(str.reverse());

        //HelloWorld + array + backwards
        char[] arrHW = "Hello World!".toCharArray();
        for (int i = arrHW.length; i > 0; i--){
            System.out.print(arrHW[i - 1]);
        }
        System.out.println();

        //foreach
        for (char i : arrHW){
            System.out.print(i);
        }
        System.out.println();

        //Test char array
        char[] arr = {'T','s','2'};
        System.out.print(arr);
    }
}

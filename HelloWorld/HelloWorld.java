package HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        //HelloWorld + charAt / substring
        String HW = "Hello World";
        System.out.println("Hello World!");
        System.out.print("Hello World!".charAt(1) + " ");
        System.out.println("Hello World!".substring(10,11));
        System.out.print(HW.charAt(1) + " ");
        System.out.println(HW.substring(10,11));

        //Goodbye world backwards chartAt
        String GW = "Goodbye World!";
        for (int i = GW.length(); i>0; i--){
            System.out.print(GW.charAt(i-1));
        }
        System.out.println();

        //HelloWorld backwards substring
        for (int i = "Hello World!".length(); i>0; i--){
            System.out.print("Hello World!".substring(i-1,i));
        }
        System.out.println();

        //HelloWorld + array
        char[] arrHW = "Hello World!".toCharArray();
        for (int c = arrHW.length; c>0; c--){
            System.out.print(arrHW[c-1]);
        }
        System.out.println();

        //foreach
        for (char j : arrHW){
            System.out.print(j);
        }
        System.out.println();

        //Test char array
        char[] arr = {'T','s','2'};
        System.out.print(arr);
    }
}

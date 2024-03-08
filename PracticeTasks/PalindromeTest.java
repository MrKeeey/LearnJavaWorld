package PracticeTasks;

public class PalindromeTest {

     private static boolean palindrome(String str) {

         int first = 0;
         int last = str.length() -1;

         while (first < last) {
             if(str.charAt(first) != str.charAt(last)) {
                 System.out.println("This isn't palindrome");
                 return false;
             }
             first++;
             last--;
         }

         System.out.println("It's a palindrome!");
         return true;

     }

    public static void main(String[] args) {
        System.out.println(palindrome("HelloolleH"));
    }

}

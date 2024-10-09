package PracticeTasks;

public class LC921_minAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int countOpen = 0;
        int countClose = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countOpen++;
            } else {
                countClose++;
            }
            if (countOpen < countClose) {
                count++;
                countClose--;
            }
        }
        return count + countOpen - countClose;
    }

    public int minAddToMakeValid2(String s) {
        int count = 0;
        int countOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countOpen++;
            } else {
                if (countOpen > 0) {
                    countOpen--;
                } else {
                    count++;
                }
            }
        }
        return count + countOpen;
    }

    public static void main(String[] args) {
        System.out.println(new LC921_minAddToMakeValid().minAddToMakeValid("()))(()"));
        System.out.println(new LC921_minAddToMakeValid().minAddToMakeValid2("()))(()"));
    }
}

package PracticeTasks;

public class LC1910_removeOccurrences {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s);

        while (str.indexOf(part) != -1) {
            int startIndex = str.indexOf(part);
            str.delete(startIndex, startIndex + part.length());
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC1910_removeOccurrences().removeOccurrences("axxxxyyyyb", "xy"));
    }
}

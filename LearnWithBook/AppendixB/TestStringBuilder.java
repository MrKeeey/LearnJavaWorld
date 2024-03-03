package LearnWithBook.AppendixB;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Winter");

        sb.delete(0, 3).deleteCharAt(0).insert(0, "Summ").append(" time!");
        System.out.println(sb);

        sb = new StringBuilder("Winter");
        sb.delete(0, 3);
        sb.deleteCharAt(0);
        sb.insert(0, "Summ");
        sb.append(" time!");

        System.out.println(sb);
    }
}

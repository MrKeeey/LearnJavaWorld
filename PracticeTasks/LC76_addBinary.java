package PracticeTasks;

public class LC76_addBinary {
    StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(new LC76_addBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int next = 0;

        while (aLen >= 0 && bLen >= 0) {
            int buff = Integer.parseInt(String.valueOf(a.charAt(aLen))) + Integer.parseInt(String.valueOf(b.charAt(bLen))) + next;
            next = makeResultString(buff);
            aLen--;
            bLen--;
        }

        if (aLen == -1 && bLen >= 0) {
            while (bLen >= 0) {
                int buff = Integer.parseInt(String.valueOf(b.charAt(bLen))) + next;
                next = makeResultString(buff);
                bLen--;
            }
        } else {
            while (aLen >= 0) {
                int buff = Integer.parseInt(String.valueOf(a.charAt(aLen))) + next;
                next = makeResultString(buff);
                aLen--;
            }
        }

        if (next == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    private int makeResultString(int buff) {
        int next;
        if (buff == 3) {
            result.append(1);
            next = 1;
        } else if (buff == 2) {
            result.append(0);
            next = 1;
        } else {
            result.append(buff);
            next = 0;
        }
        return next;
    }
}

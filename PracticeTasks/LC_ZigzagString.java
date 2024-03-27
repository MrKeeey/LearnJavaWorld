package PracticeTasks;

public class LC_ZigzagString {
    public static void main(String[] args) {
//        P   A   H   N
//        A P L S I I G
//        Y   I   R

//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows) {
        if(s.length() < 2 || numRows <= 1) {
            return s;
        }
        int numColumns = numRows - 2;
        StringBuilder[] buffer = new StringBuilder[numRows];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new StringBuilder();
        }
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < numRows && count < s.length(); i++, count++) {
                buffer[i].append(s.charAt(count));
            }
            for (int i = numColumns; i > 0 && count < s.length(); i--, count++) {
                buffer[i].append(s.charAt(count));
            }
        }
        //my version
//        for (int i = 0; i < s.length(); i += numRows + numColumns) {
//            for (int j = i; j < i + numRows + numColumns && j < s.length(); j++) {
//                if (j < numRows + i) {
//                    buffer[count].append(s.charAt(j));
//                    count++;
//                } else {
//                    buffer[count - 2].append(s.charAt(j));
//                    count--;
//                }
//            }
//            count = 0;
//        }
//        System.out.println(Arrays.toString(buffer));
        StringBuilder result = new StringBuilder();
        for (StringBuilder str : buffer) {
            result.append(str);
        }
        return result.toString();



    }
}

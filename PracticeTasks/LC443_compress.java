package PracticeTasks;

public class LC443_compress {
    public static void main(String[] args) {
        char[] array = {'a', 'a', 'b', 'b', 'c', 'c', 'f'};
        System.out.println(compress(array));
    }

    public static int compress(char[] chars) {
        if (chars.length == 0) return 0;
        StringBuilder result = new StringBuilder();
        System.out.println(chars);
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
                if (i == chars.length - 2) {
                    result.append(chars[i]);
                    if (count > 1) {
                        result.append(count);
                    }
                }
            } else {
                result.append(chars[i]);
                if (count > 1) {
                    result.append(count);
                }
                if (i == chars.length - 2) {
                    result.append(chars[i + 1]);
                }
                count = 1;
            }
        }
        chars = result.toString().toCharArray();
//        for (int i = 0; i < result.length(); i++) {
//            chars[i] = result.charAt(i);
//        }
        System.out.println(chars);
        return chars.length;
    }
}

package PracticeTasks;

public class LC838_pushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder(dominoes);
        int i = 0;
        int n = dominoes.length();
        int prev = -1;
        char prevChar = '.';

        while (i < n) {
            char c = result.charAt(i);

            if (c != '.') {
                if (prevChar == 'R' && c == 'L') {
                    int left = prev + 1;
                    int right = i - 1;
                    while (left < right) {
                        result.setCharAt(left++, 'R');
                        result.setCharAt(right--, 'L');
                    }
                    if (left == right) result.setCharAt(left, '.');

                } else if (prevChar == 'R' && c == 'R') {
                    for (int k = prev + 1; k < i; k++) {
                        result.setCharAt(k, 'R');
                    }

                } else if (prevChar == 'L' && c == 'L') {
                    for (int k = prev + 1; k < i; k++) {
                        result.setCharAt(k, 'L');
                    }
                }
                prev = i;
                prevChar = c;
            }
            i++;
        }

        if (prevChar == 'R') {
            for (int k = prev + 1; k < n; k++) {
                result.setCharAt(k, 'R');
            }
        }

        i = 0;
        while (i < n && result.charAt(i) == '.') i++;
        if (i < n && result.charAt(i) == 'L') {
            for (int k = 0; k < i; k++) {
                result.setCharAt(k, 'L');
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LC838_pushDominoes().pushDominoes(".L.R...LR..L.."));
    }
}

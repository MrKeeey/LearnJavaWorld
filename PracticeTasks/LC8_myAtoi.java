package PracticeTasks;

import java.math.BigInteger;


public class LC8_myAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-5-"));
    }

    public static int myAtoi(String s) {
        String result = "";
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                if (result != "") {
                    i = s.length();
                } else {
                    i++;
                    if (i >= s.length()) {
                        return 0;
                    }
                }
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (result != "") {
                    i = s.length();
                } else {
                    result = String.valueOf(s.charAt(i));
                    i++;
                    if (i >= s.length() || s.charAt(i) < 48 || s.charAt(i) > 57) {
                        return 0;
                    }
                    while (s.charAt(i) == 48) {
                        i++;
                        if (i >= s.length() || s.charAt(i) < 48 || s.charAt(i) > 57) {
                            return 0;
                        }
                    }
                    while (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                        result += s.charAt(i);
                        i++;
                        if (i >= s.length() || s.charAt(i) < 48 || s.charAt(i) > 57) {
                            break;
                        }
                    }
                }
            } else if ((s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                while (s.charAt(i) == 48) {
                    i++;
                    if (i >= s.length() || s.charAt(i) < 48 || s.charAt(i) > 57) {
                        return 0;
                    }
                }
                while (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    result += s.charAt(i);
                    i++;
                    if (i >= s.length() || s.charAt(i) < 48 || s.charAt(i) > 57) {
                        break;
                    }
                }
            } else {
                if (result == "") {
                    return 0;
                } else {
                    break;
                }
            }
        }
        BigInteger number = new BigInteger(result);
        if (result.charAt(0) == '-') {
            int numMin = number.compareTo(BigInteger.valueOf(Integer.MIN_VALUE));
            if (numMin == -1) {
                return Integer.MIN_VALUE;
            }
        } else {
            int numMax = number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE));
            if (numMax == 1) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.parseInt(result);
    }
}

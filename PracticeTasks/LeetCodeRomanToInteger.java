package PracticeTasks;

public class LeetCodeRomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt2("LVIII"));
    }

    public static int romanToInt2(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public static int romanToInt(String s) {
        int result = 0;
        int count = 0;
        while (count < s.length()) {
            if (s.charAt(count) == 'M') {
                result += 1000;
                count++;
                if (count >= s.length()) {
                    break;
                }
            }
            if (s.charAt(count) == 'C') {
                if (count + 1 >= s.length()) {
                    result += 100;
                    count++;
                    if (count >= s.length()) {
                        break;
                    }
                } else {
                    if (s.charAt(count + 1) == 'M') {
                        result += 900;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else if (s.charAt(count + 1) == 'D') {
                        result += 400;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else {
                        result += 100;
                        count++;
                        if (count >= s.length()) {
                            break;
                        }
                    }
                }
            }
            if (s.charAt(count) == 'D') {
                result += 500;
                count++;
                if (count >= s.length()) {
                    break;
                }
            }
            if (s.charAt(count) == 'X') {
                if (count + 1 >= s.length()) {
                    result += 10;
                    count++;
                    if (count >= s.length()) {
                        break;
                    }
                } else {
                    if (s.charAt(count + 1) == 'C') {
                        result += 90;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else if (s.charAt(count + 1) == 'L') {
                        result += 40;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else {
                        result += 10;
                        count++;
                        if (count >= s.length()) {
                            break;
                        }
                    }
                }
            }
            if (s.charAt(count) == 'L') {
                result += 50;
                count++;
                if (count >= s.length()) {
                    break;
                }
            }
            if (s.charAt(count) == 'I') {
                if (count + 1 >= s.length()) {
                    result += 1;
                    count++;
                    if (count >= s.length()) {
                        break;
                    }
                } else {
                    if (s.charAt(count + 1) == 'X') {
                        result += 9;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else if (s.charAt(count + 1) == 'V') {
                        result += 4;
                        count += 2;
                        if (count >= s.length()) {
                            break;
                        }
                    } else {
                        result += 1;
                        count++;
                        if (count >= s.length()) {
                            break;
                        }
                    }
                }
            }
            if (s.charAt(count) == 'V') {
                result += 5;
                count++;
                if (count >= s.length()) {
                    break;
                }
            }
        }
        return result;
    }
}


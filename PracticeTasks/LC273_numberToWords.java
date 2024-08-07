package PracticeTasks;

public class LC273_numberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(12345));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        int[] val = {
                1000000000, 1000000, 1000, 100, 90, 80, 70,
                60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14,
                13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        };
        String[] words = {
                "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty",
                "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty",
                "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen",
                "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine",
                "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"
        };
        StringBuilder result = new StringBuilder();

        for (int i = 0; num > 0; i++) {
            int count = 0;
            
            while (num >= val[i]) {
                count++;
                num = num - val[i];
            }
            
            if (count != 0) {
                if (count == 1 && i < 4) {
                    if (num == 0) {
                        result.append("One ").append(words[i]);
                    } else {
                        result.append("One ").append(words[i]).append(" ");
                    }
                }
                if (count == 1 && i >= 4) {
                    if (num == 0) {
                        result.append(words[i]);
                    } else {
                        result.append(words[i]).append(" ");
                    }
                }
                if (count > 1) {
                    if (num == 0) {
                        result.append(numberToWords(count)).append(" ").append(words[i]);
                    } else {
                        result.append(numberToWords(count)).append(" ").append(words[i]).append(" ");
                    }
                }
            }
        }
        return result.toString();
    }
}

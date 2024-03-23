package PracticeTasks;

public class LeetCodeIntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman2(2994));
        System.out.println(intToRoman(2994));
    }


    public static String intToRoman2(int num) {
        final int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        final String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder ans = new StringBuilder();
        for(int i=0; num>0; i++){
            while(num >= val[i]){
                ans.append(rom[i]);
                num = num - val[i];
            }
        }

        return ans.toString();
    }

    public static String intToRoman(int num) {
        String[] result = new String[4];
        int buff = num % 10;

        switch (buff) {
            case (1) : result[0] = "I"; break;
            case (2) : result[0] = "II"; break;
            case (3) : result[0] = "III"; break;
            case (4) : result[0] = "IV"; break;
            case (5) : result[0] = "V"; break;
            case (6) : result[0] = "VI"; break;
            case (7) : result[0] = "VII"; break;
            case (8) : result[0] = "VIII"; break;
            case (9) : result[0] = "IX"; break;
        }
        if (num >= 10) {
            buff = num % 100 - num % 10;
            switch (buff) {
                case (10) -> result[1] = "X";
                case (20) -> result[1] = "XX";
                case (30) -> result[1] = "XXX";
                case (40) -> result[1] = "XL";
                case (50) -> result[1] = "L";
                case (60) -> result[1] = "LX";
                case (70) -> result[1] = "LXX";
                case (80) -> result[1] = "LXXX";
                case (90) -> result[1] = "XC";
            }
        }
        if (num >= 100) {
            buff = num % 1000 - num % 100;
            switch (buff) {
                case (100) -> result[2] = "C";
                case (200) -> result[2] = "CC";
                case (300) -> result[2] = "CCC";
                case (400) -> result[2] = "CD";
                case (500) -> result[2] = "D";
                case (600) -> result[2] = "DC";
                case (700) -> result[2] = "DCC";
                case (800) -> result[2] = "DCCC";
                case (900) -> result[2] = "CM";
            }
        }
        if (num >= 1000) {
            buff = num % 10000 - num % 1000;
            switch (buff) {
                case (1000) -> result[3] = "M";
                case (2000) -> result[3] = "MM";
                case (3000) -> result[3] = "MMM";
            }
        }
        StringBuilder val = new StringBuilder();
        for (int i = result.length - 1; i >= 0 ; i--) {
            if (result[i] != null) {
                val.append(result[i]);
            }
        }
        return val.toString();
    }
}
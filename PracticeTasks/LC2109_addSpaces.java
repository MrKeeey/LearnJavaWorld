package PracticeTasks;

public class LC2109_addSpaces {
    public static void main(String[] args) {
        String phrase = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        System.out.println(new LC2109_addSpaces().addSpaces(phrase, spaces));
        System.out.println(new LC2109_addSpaces().addSpaces2(phrase, spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = spaces.length - 1; i >= 0; i--) {
            stringBuilder.insert(spaces[i], ' ');
        }
        return stringBuilder.toString();
    }

    public String addSpaces2(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        for (int space : spaces) {
            stringBuilder.append(s, start, space).append(' ');
            start = space;
        }
//        stringBuilder.append(s, start, s.length());
        stringBuilder.append(s.substring(start));
        return stringBuilder.toString();
    }
}

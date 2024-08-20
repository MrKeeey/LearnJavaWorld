package PracticeTasks;

public class LC28_strStr {
    public static void main(String[] args) {
        System.out.println(new LC28_strStr().strStr("sadbutsad", "ad"));
        System.out.println(new LC28_strStr().strStr2("sadbutsad", "ad"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int count = 0;
                while (i + count < n && count < m && haystack.charAt(i + count) == needle.charAt(count)) {
                    count++;
                }
                if (count == m) {
                    return i;
                }
            }
        }
        return -1;
    }
}

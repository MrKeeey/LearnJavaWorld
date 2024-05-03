package PracticeTasks;

public class LC_CompareVersionString {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0000", "1.000.000.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int n = ver1.length;
        int m = ver2.length;
        int maxLength = Math.max(n, m);

        for (int i = 0; i < maxLength; i++) {
            int numVer1 = i < n ? Integer.parseInt(ver1[i]) : 0;
            int numVer2 = i < m ? Integer.parseInt(ver2[i]) : 0;

            if (numVer1 < numVer2) {
                return -1;
            }
            if (numVer1 > numVer2) {
                return 1;
            }
        }
        return 0;
    }
}

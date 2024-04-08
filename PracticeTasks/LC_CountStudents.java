package PracticeTasks;

public class LC_CountStudents {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
        System.out.println(countStudents2(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int countWell_fedStudents = 0;
        int count = 0;
        int n = students.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (students[i] != sandwiches[j]) {
                int buff = students[i];
                for (int k = i; k < n - 1; k++) {
                    students[k] = students[k + 1];
                }
                students[n - 1] = buff;
                count++;
                if (count >= n - countWell_fedStudents) {
                    return n - countWell_fedStudents;
                }
                i--;
            } else {
                countWell_fedStudents++;
                j++;
                count = 0;
            }
        }
        return n - countWell_fedStudents;
    }

    public static int countStudents2(int[] students, int[] sandwiches) {
        int countSquareS = 0;
        int countCircleS = 0;
        int n = students.length;
        for (int student : students) {
            if (student == 1) {
                countSquareS++;
            } else {
                countCircleS++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 1 && countSquareS > 0) {
                countSquareS--;
            } else if (sandwiches[i] == 0 && countCircleS > 0) {
                countCircleS--;
            } else {
                return countCircleS + countSquareS;
            }
        }
        return 0;
    }
}

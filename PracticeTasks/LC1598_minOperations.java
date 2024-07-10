package PracticeTasks;

public class LC1598_minOperations {

    public static void main(String[] args) {
        String[] folders = {"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"};
        System.out.println(minOperations(folders));
    }

    public static int minOperations(String[] logs) {
        int steps = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                steps--;
                steps = Math.max(steps, 0);
            } else if (log.equals("./")) {
                //steps += 0;
            } else {
                steps++;
            }
        }

        return steps;
    }
}

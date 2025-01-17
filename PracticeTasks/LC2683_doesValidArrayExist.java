package PracticeTasks;

public class LC_ {
    public boolean doesValidArrayExist(int[] derived) {
        int totalXOR = 0;
        for (int bit : derived) {
            totalXOR ^=bit;
        }
        return totalXOR == 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 0};
        System.out.println(new LC_().doesValidArrayExist(array));
    }
}

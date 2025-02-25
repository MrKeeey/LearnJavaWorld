package PracticeTasks;

public class LC1524_numOfSubarrays {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0;
        int evenCount = 1;
        int sum = 0;
        long count = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                evenCount++;
                count += oddCount;
            } else {
                oddCount++;
                count += evenCount;
            }
        }

        return (int) (count % 1_000_000_007);
    }

    //genius faster method
    public int numOfSubarrays2(int[] arr) {
        long oddCount = 0;
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            oddCount += prefixSum % 2;
        }
        oddCount += (arr.length - oddCount) * oddCount;
        return (int) (oddCount % 1_000_000_007);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5};
        System.out.println(new LC1524_numOfSubarrays().numOfSubarrays(array));
        System.out.println(new LC1524_numOfSubarrays().numOfSubarrays2(array));
    }
}

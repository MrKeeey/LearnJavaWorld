package PracticeTasks;

public class LC881_numRescueBoats {
    public static void main(String[] args) {
        int[] array = {3, 2, 3, 2, 2};
        System.out.println(numRescueBoats(array, 6));
        System.out.println(numRescueBoats2(array, 6));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int[] countPeopleWeight = new int[limit + 1];
        for (int elem : people) {
            countPeopleWeight[elem]++;
        }
        for (int i = countPeopleWeight.length - 1; i >= 0; i--) {
            if (countPeopleWeight[i] != 0) {
                if (i == limit) {
                    count++;
                    countPeopleWeight[i]--;
                }
                if (i < limit) {
                    count++;
                    countPeopleWeight[i]--;
                    for (int j = i; j >= 0; j--) {
                        if (j <= limit - i && countPeopleWeight[j] != 0) {
                            countPeopleWeight[j]--;
                            break;
                        }
                    }
                }
                if (countPeopleWeight[i] != 0) {
                    i++;
                }
            }
        }
        return count;
    }

    public static int numRescueBoats2(int[] people, int limit) {
        int[] buckets = new int[limit + 1];
        for(int weight : people ){
            buckets[weight]++;
        }
        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while(start<=end){
            while(start<=end && buckets[start] <= 0 ) start++;
            while(start<=end && buckets[end] <= 0 ) end--;

            if(buckets[start] <=0 && buckets[end] <=0) break;

            boats++;
            if(start + end <= limit){
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }
}
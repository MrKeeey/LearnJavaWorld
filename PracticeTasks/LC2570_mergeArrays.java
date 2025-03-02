package PracticeTasks;

import java.util.*;

public class LC2570_mergeArrays {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        List<int[]> resultList = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (nums1[i][0] == nums2[j][0]) {
                resultList.add(new int[]{nums1[i][0], nums1[i++][1] + nums2[j++][1]});
            } else if (nums1[i][0] < nums2[j][0]){
                resultList.add(nums1[i++]);
            } else {
                resultList.add(nums2[j++]);
            }
        }

        while (i < n1) {
            resultList.add(nums1[i++]);
        }

        while (j < n2) {
            resultList.add(nums2[j++]);
        }


        return resultList.toArray(new int[resultList.size()][]);
    }

    //slower
    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> resultArray = new TreeMap<>();
        for (int[] pair : nums1) {
            resultArray.put(pair[0], pair[1]);
        }

        for (int[] pair : nums2) {
            resultArray.put(pair[0], resultArray.getOrDefault(pair[0], 0) + pair[1]);
        }

        int[][] result = new int[resultArray.size()][2];
        int index = 0;
        for (var pair : resultArray.entrySet()) {
            result[index][0] = pair.getKey();
            result[index++][1] = pair.getValue();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.deepToString(new LC2570_mergeArrays().mergeArrays(nums1, nums2)));
        System.out.println(Arrays.deepToString(new LC2570_mergeArrays().mergeArrays2(nums1, nums2)));
    }
}

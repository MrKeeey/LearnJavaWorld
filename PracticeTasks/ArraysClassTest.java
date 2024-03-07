package PracticeTasks;

import JavaRush.ArrayAndScanner;

import java.util.Arrays;

public class ArraysClassTest {
    public static void main(String[] args) {

        int[] x = {1 ,2, -3, 4, -5, 6};
        int[] y = {1 ,2, -3, 4, -5, 6};

        int[][] x2 = {{1, 2, -3}, {4, -5, 6}};
        int[][] y2 = {{1, 2, -3}, {4, -5, 6}};

        System.out.println("Arrays.toString() for array[]");
        System.out.println("Standard: " + x);
        System.out.println("Arrays.toString(): " + Arrays.toString(x) + "\n");              //always use toString for int[]

        System.out.println("Arrays.deepToString() for array[][]");
        System.out.println("Standard: " + x2);
        System.out.println("Arrays.toString(): " + Arrays.toString(x2));
        System.out.println("Arrays.deepToString(): " + Arrays.deepToString(x2) + "\n");         //always use deepToString for int[][]

        System.out.println("Arrays.equals() for array[]");
        System.out.println("Standard: " + x.equals(y));
        System.out.println("Arrays.equals(): " + Arrays.equals(x, y) + "\n");             //always use Arrays.equals for int[]

        System.out.println("Arrays.deepEquals() for array[][]");
        System.out.println("Standard: " + x2.equals(y2));
        System.out.println("Arrays.equals(): " + Arrays.equals(x2, y2));
        System.out.println("Arrays.deepEquals(): " + Arrays.deepEquals(x2, y2) + "\n");       //always use Arrays.deepEquals for int[][]

        System.out.println("Arrays.fill() for array[]");
        int[] x3 = new int[10];
        Arrays.fill(x3, 15);
        System.out.println(Arrays.toString(x3));
        Arrays.fill(x3, 3, 8, 8);
        System.out.println(Arrays.toString(x3) + "\n");

        System.out.println("Arrays.copyOf() for array[]");
        int[] x4 = Arrays.copyOf(x, 5);
        System.out.println(Arrays.toString(x4));
        System.out.println("Arrays.copyOfRange() for array[]");
        int[] x5 = Arrays.copyOfRange(x, 1, 10);
        System.out.println(Arrays.toString(x5) + "\n");

        System.out.println("Arrays.sort() for array[]");
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        Arrays.sort(y, 1, 5);
        System.out.println(Arrays.toString(y) + "\n");

        System.out.println("Arrays.binarySearch() for array[]");
        int index = Arrays.binarySearch(x, 1);
        int index2 = Arrays.binarySearch(x, -5);
        int index3 = Arrays.binarySearch(x, 0);
        System.out.println(index + " " + index2 + " " + index3 + "\n");     //return index element in sort array, if don't have element return -number

        System.out.println("less array = bigger array is work!");
        int[] array = { 1, 2, 3, 4, 5 };
        int[] mass = new int[3];
        mass = array;
        System.out.println(Arrays.toString(mass));
    }
}

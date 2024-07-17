package HelloWorld;

import java.util.Arrays;
import java.util.List;

public class testArrayToList {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        long[] array2 = {2, 3, 4, 5, 6};
        double[] array3 = {3.3, 4.4, 5.5, 6.6};
        intArrayToIntegerList(array1, array2, array3);

        //типы byte, short, float и char нельзя преобразовать с помощью stream.
        //нужно использовать forEach.

    }

    //boxed for int -> Integer, long -> Long, double -> Double;
    private static void intArrayToIntegerList(int[] array1, long[] array2, double[] array3) {
        List<Integer> list1 = Arrays.stream(array1).boxed().toList();
        System.out.println(list1);
        List<Long> list2 = Arrays.stream(array2).boxed().toList();
        System.out.println(list2);
        List<Double> list3 = Arrays.stream(array3).boxed().toList();
        System.out.println(list3);
    }
}

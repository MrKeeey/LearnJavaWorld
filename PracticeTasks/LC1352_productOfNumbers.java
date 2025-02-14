package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC1352_productOfNumbers {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.getProduct(2);
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}

class ProductOfNumbers {
    private int product;
    private final List<Integer> stream;

    public ProductOfNumbers() {
        product = 1;
        stream = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            stream.clear();
            product = 1;
        } else {
            product *= num;
            stream.add(product);
        }
    }

    public int getProduct(int k) {
        int size = stream.size();
        if (size < k) return 0;
        if (size == k) return product;

        return product / stream.get(size - 1 - k);
    }
}
import java.util.Random;
public class Food {
    public static void main(String[] args) {
        //Test how work random
        Random rand = new Random();
        int r = 0, i = 0;

        while (r != 5){
            r = rand.nextInt(10);
            System.out.print(r);
            if (r==0) i++;
        }
        System.out.println();
        System.out.println("Found zero " + i + " times");

        //Random all food + without repeats
        char[] brkfst = {'o', 'p', 'm', 'f', 'r'};
        char[] havka = new char[brkfst.length];
        //int[] last = new int[brkfst.length];
        int k = 0, rnd=0, last=0;

        while (k != brkfst.length) {
            if (last==0) {
                rnd = rand.nextInt(brkfst.length);
                havka[k] = brkfst[rnd];
                last = rnd;
                k++;
            }else {
                if (last == rnd) {
                    rnd = rand.nextInt(brkfst.length);
                } else {
                    havka[k] = brkfst[rnd];
                    last = rnd;
                    k++;
                }
            }
        }
        //if for repeat + switch for choice
        //for (char i : havka)
        //    System.out.print(i);
        System.out.print(havka);
    }
}
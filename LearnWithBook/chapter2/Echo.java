package LearnWithBook.chapter2;

public class Echo {
    int count = 0;

    void hello(){
        System.out.println("Helloooo...");
    }
}

class EchoTest{
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2 = new Echo();
        int x = 0;

        while (x < 4){
            e1.hello();
            e1.count++;

            if (x > 0){                                //x == 3
                e2.count++;
            }

            if (x > 1){                                // x > 0
                e2.count = e2.count + e1.count;
                System.out.println(e2.count);
            }
            /*if (x > 1){
                if (x == 3){
                    e2.count = e2.count * e1.count;
                } else {
                    e2.count = e2.count + e1.count;
                }
            } */
            x++;
        }
        System.out.println(e2.count);
    }
}
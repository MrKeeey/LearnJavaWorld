package LearnWithBook.chapter3;
public class indexTest {
    int id = 0;
    public static void main(String[] args) {

        int x = 0;
        indexTest[] it = new indexTest[5];

        while (x < 3){
            it[x] = new indexTest();
            it[x].id = x;
            x++;
        }

        it[3] = it[1];
        it[4] = it[1];
        it[3] = null;
        it[4] = it[0];
        it[0] = it[3];
        it[3] = it[2];
        it[2] = it[0];

        for (int count = 0; count < 5; count++) {
            try {
                System.out.println(it[count].id);
            } catch (NullPointerException e) {
                System.out.println("null");
            }
        }
    }
}

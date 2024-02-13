package LearnWithBook.chapter5;

public class Output {
    public static void main(String[] args) {
        Output o = new Output();
        o.go();
        o.MultiFor();
    }

    void go(){
        int y = 7;
        for (int x = 1; x < 8; x++){
            y++;
            if (x > 4){
                System.out.print(++y + " ");
            }
            if (y > 14){
                System.out.println(" x = " + x);
                break;
            }
        }
    }

    void MultiFor(){
        for (int x = 0; x < 4; x++) {
            for (int y = 4; y > 2; y--) {
                System.out.println(x + " " + y);
            }
            if (x == 1) x ++;
        }
    }
}
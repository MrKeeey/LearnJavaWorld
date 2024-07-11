package HeadFirst.chapter4;

class SumTest {
    public static void main(String[] args) {

        int firstnumber = 234, secondnumber = -92;
        Sum summa = new Sum();

        summa.go();
        summa.SummResult(-2343, 2863);
        summa.SummResult(firstnumber, secondnumber);
    }
}

public class Sum {

    void go (){
        SummResult(12, 24);
    }

    void SummResult (int firstnumber, int secondnumber){
        int result = firstnumber + secondnumber;
        System.out.println("Summ your numbers is " + result);
    }
}
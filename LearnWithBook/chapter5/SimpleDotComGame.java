import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom[] play = new SimpleDotCom[3];
        //Scanner scanner = new Scanner(System.in);
        //System.out.println(play.checkYourself(scanner.nextLine()));
        for (int count = 0; count < 3; count++){
            play[count] = new SimpleDotCom();
        }
    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String checkYourself (String guess) {

        locationCells[0] = (int) guess;
        while (numOfHits !=3){
            if (guess == "1"){
                numOfHits++;
                if (numOfHits == 3) return "Potopil";
                else return "Popal";
            } else return "Mimo";
        }
        return "1";
    }

    void setLocationCells (int[] loc){

    }
}
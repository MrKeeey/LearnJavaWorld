import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        //Scanner scanner = new Scanner(System.in);
        //System.out.println(play.checkYourself(scanner.nextLine()));
        int[] locations = {2,3,4};
        play.setLocationCells(locations);
        String userGuest = "2";
        String result = play.checkYourself(userGuest);
        System.out.println(result);
    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String checkYourself (String guess) {

        while (numOfHits !=3){
            if (guess == "2"){
                numOfHits++;
                if (numOfHits == 3) return "Potopil";
                else return "Popal";
            } else return "Mimo";
        }
        return "1";
    }

    void setLocationCells (int[] loc){
        locationCells = loc;
    }
}
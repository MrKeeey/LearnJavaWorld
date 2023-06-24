import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        Scanner scanner = new Scanner(System.in);
        //System.out.println(play.checkYourself(scanner.nextLine()));
        int[] locations = {2,3,4};
        play.setLocationCells(locations);
        String userGuest = "2";
        while (play.numOfHits != 3){
            String result = (String) play.checkYourself(scanner.nextLine());
            //String result = play.checkYourself(userGuest);
            System.out.println(result);
        }

    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String checkYourself (String guess) {
            if (guess == "2"){
                numOfHits++;
                if (numOfHits == 3) return "Potopil";
                else return "Popal";
            } else return "Mimo";
    }

    void setLocationCells (int[] loc){
        locationCells = loc;
    }
}
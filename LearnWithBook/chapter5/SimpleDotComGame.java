import java.util.EmptyStackException;
import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        Scanner scanner = new Scanner(System.in);
        int[] locations = {2,3,4};
        //String userGuest = "2";

        play.setLocationCells(locations);
        while (play.numOfHits != locations.length){
            try {
                play.checkYourself(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Wrong symbol. You can enter only numbers. Try again...");
            }
            //String result = play.checkYourself(userGuest);
        }

    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String checkYourself (String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Miss";

        for (int count = 0; count < locationCells.length; count++) {
            if (guess == locationCells[count]){
                locationCells[count] = -1;
                result = "Hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) result = "Kill";
        System.out.println(result);
        return result;
    }

    void setLocationCells (int[] loc){
        locationCells = loc;
    }
}
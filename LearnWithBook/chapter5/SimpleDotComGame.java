import java.util.EmptyStackException;
import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        Scanner scanner = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 6);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        int count = 0;

        play.setLocationCells(locations);
        while (play.numOfHits != locations.length){
            System.out.print("Enter a number: ");
            try {
                play.checkYourself(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Wrong symbol. You can enter only numbers. Try again...");
            }
            count++;
        }
        if (count == locations.length) {
            System.out.print("You took " + count + " guesses. Great, this is the minimum number of attempts.");
        } else System.out.print("You took " + count + " guesses.");
    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String checkYourself (String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Miss";

        for (int count = 0; count < locationCells.length; count++) {
            //int lastguess = 0;
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

    void setLocationCells (int[] locs){
        locationCells = locs;
    }
}
import com.sun.source.tree.ClassTree;

import java.util.EmptyStackException;
import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        Scanner scanner = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 6);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        int count = 0;
        String userGuess;

        play.setLocationCells(locations);
        while (play.numOfHits != locations.length){
            System.out.print("Enter a number: ");
            try {
                userGuess = scanner.nextLine();
                if (Integer.parseInt(userGuess) == play.lastGuess) {
                    System.out.println("You already use this number. Try again.");
                } else {
                    play.checkYourself(userGuess);
                    count++;
                }
            } catch(NumberFormatException e) {
                System.out.println("Wrong symbol. You can enter only numbers. Try again...");
            }
        }
        if (count == locations.length) {
            System.out.print("You took " + count + " guesses. Great, this is the minimum number of attempts.");
        } else System.out.print("You took " + count + " guesses.");
    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0, lastGuess = -1;
    String checkYourself (String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Miss";
        lastGuess = guess;
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

    void setLocationCells (int[] locs){
        locationCells = locs;
    }
}
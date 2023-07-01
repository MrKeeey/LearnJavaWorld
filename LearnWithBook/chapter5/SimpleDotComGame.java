import java.util.Scanner;
public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom play = new SimpleDotCom();
        Scanner scanner = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        int count = 0;
        int[] hitarr = {0, 1, 2, 3, 4, 5, 6};
        boolean[] flag = new boolean[7];
        String userGuess;

        play.setLocationCells(locations);
        while (/*play.numOfHits != locations.length*/ !play.result.equals("Kill")){
            System.out.print("Enter a number: ");
            try {
                userGuess = scanner.nextLine();
                int intuserGuess = Integer.parseInt(userGuess);
                if (intuserGuess == hitarr[intuserGuess] && flag[intuserGuess]) {
                    System.out.println("You already use this number. Try again.");
                } else {
                    play.checkYourself(userGuess);
                    flag[intuserGuess] = true;
                    count++;
                }
            } catch(NumberFormatException e) {
                System.out.println("Wrong symbol. You can enter only numbers. Try again...");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You can only use numbers from 0 to 6. Try again...");
            }
        }
        if (count == locations.length) {
            System.out.println("You took " + count + " guesses. Great, this is the minimum number of attempts.");
        } else System.out.println("You took " + count + " guesses.");
    }
}

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    String result = " ";
    String checkYourself (String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        result = "Miss";
        for (int count = 0; count < locationCells.length; count++) {
            if (guess == locationCells[count]){
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
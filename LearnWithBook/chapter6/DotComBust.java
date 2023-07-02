package LearnWithBook.chapter6;
import java.util.ArrayList;
import java.util.Scanner;
public class DotComBust {
    Scanner scanner = new Scanner(System.in);
    String userGuess;
    int[] hitarr = {0, 1, 2, 3, 4, 5, 6};
    boolean[] flag = new boolean[7];

    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    int numOfGuesses = 0;
    private void setUpGame() {
        DotCom firstsite = new DotCom();
        DotCom secondsite = new DotCom();
        DotCom thirdsite = new DotCom();

        int randomNum = (int)(Math.random() * 5);
        ArrayList<String> one = new ArrayList<String>();
        one.add(String.valueOf(randomNum));
        one.add(String.valueOf(randomNum + 1));
        one.add(String.valueOf(randomNum + 2));
        int randomNum2 = (int)(Math.random() * 5);
        ArrayList<String> two = new ArrayList<String>();
        two.add(String.valueOf(randomNum2));
        two.add(String.valueOf(randomNum2 + 1));
        two.add(String.valueOf(randomNum2 + 2));
        int randomNum3 = (int)(Math.random() * 5);
        ArrayList<String> three = new ArrayList<String>();
        three.add(String.valueOf(randomNum3));
        three.add(String.valueOf(randomNum3 + 1));
        three.add(String.valueOf(randomNum3 + 2));

        firstsite.setName("Pets.com");
        secondsite.setName("eToys.com");
        thirdsite.setName("Go2.com");
        dotComList.add(firstsite);
        dotComList.add(secondsite);
        dotComList.add(thirdsite);
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = one;
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while (!dotComList.isEmpty()){
            System.out.print("Enter a number: ");
            try {
                userGuess = scanner.nextLine();
                int intuserGuess = Integer.parseInt(userGuess);
                if (intuserGuess == hitarr[intuserGuess] && flag[intuserGuess]) {
                    System.out.println("You already use this number. Try again.");
                } else {
                    checkUserGuess(userGuess);
                    flag[intuserGuess] = true;
                    numOfGuesses++;
                }
            } catch(NumberFormatException e) {
                System.out.println("Wrong symbol. You can enter only numbers. Try again...");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You can only use numbers from 0 to 6. Try again...");
            }
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        //numOfGuesses++;
        String result = "Miss";
        for (DotCom dotComToTest : dotComList){
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Hit")) break;
            if (result.equals("Kill")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses == dotComList.size()) {
            System.out.println("You took " + numOfGuesses + " guesses. Great, this is the minimum number of attempts.");
        } else if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}

class DotCom{
    private ArrayList<String> locationCells;
    public String Name;
    public void setLocationCells (ArrayList<String> locs){
        locationCells = locs;
    }
    public void setName(String name) {
        Name = name;
    }

    String checkYourself (String userInput) {
        String result = "Miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Kill";
                System.out.println("Ouch! You sunk " + Name + " :(");
            } else result = "Hit";
        }
        return result;
    }
}
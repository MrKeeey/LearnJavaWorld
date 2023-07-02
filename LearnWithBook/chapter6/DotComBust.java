package LearnWithBook.chapter6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class DotComBust {
    Scanner scanner = new Scanner(System.in);
    String userGuess;

    boolean[] flag = new boolean[7];

    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    int numOfGuesses = 0;

    private ArrayList<String> genaratesite(){
        ArrayList<String> point = new ArrayList<String>();
        int vertOrgoriz = (int)(Math.random() * 2);
        int symbol = (int)((Math.random() * 5) + 'A');
        int number = (int)(Math.random() * 5);
        String firstpoint = (char)symbol + "" + number;
        String thirdpoint;
        String secondpoint;
        if (vertOrgoriz == 1){
            secondpoint = (char)(symbol + 1) + "" + number;
            thirdpoint = (char)(symbol + 2) + "" + number;
        } else {
            secondpoint = (char)symbol + "" + (number + 1);
            thirdpoint = (char)symbol + "" + (number + 2);
        }
        point.add(firstpoint);
        point.add(secondpoint);
        point.add(thirdpoint);
        System.out.println(point);
        return point;
    }
    private void setUpGame() {
        DotCom firstsite = new DotCom();
        DotCom secondsite = new DotCom();
        DotCom thirdsite = new DotCom();

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
            ArrayList<String> newLocation = genaratesite();
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while (!dotComList.isEmpty()){
            System.out.print("Enter a number: ");
            try {
                userGuess = scanner.nextLine();
                /*int intuserGuess = Integer.parseInt(userGuess);
                if (intuserGuess == hitarr[intuserGuess] && flag[intuserGuess]) {
                    System.out.println("You already use this number. Try again.");
                } else {*/
                    checkUserGuess(userGuess);
                    //flag[intuserGuess] = true;
                    numOfGuesses++;
                //}
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
        ArrayList <String> hitarr = new ArrayList<String>();
        for (int symbol = 0; symbol < 7; symbol++ ){
            for (int number = 0; number < 7; number++){
                hitarr.add((char)(symbol + 65) + "" + number);
            }
        }
        System.out.println(hitarr);
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
package LearnWithBook.chapter6;
import java.util.ArrayList;
import java.util.Scanner;

public class DotComGame {
    public static void main(String[] args) {
        DotCom play = new DotCom();
        Scanner scanner = new Scanner(System.in);
        int randomNum = (int)(Math.random() * 5);

        ArrayList<String> locations = new ArrayList<String>();
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum + 1));
        locations.add(String.valueOf(randomNum + 2));

        int count = 0;
        int[] hitarr = {0, 1, 2, 3, 4, 5, 6};
        boolean[] flag = new boolean[7];
        int sizearr = locations.size();
        String userGuess;

        play.setLocationCells(locations);
        while (!play.result.equals("Kill")){
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
        if (count == sizearr) {
            System.out.println("You took " + count + " guesses. Great, this is the minimum number of attempts.");
        } else System.out.println("You took " + count + " guesses.");
    }
}
class DotCom {
    private ArrayList<String> locationCells;
    //int numOfHits = 0;
    public String result = " ";
    public void setLocationCells (ArrayList<String> locs){
        locationCells = locs;
    }
    String checkYourself (String stringGuess) {
        result = "Miss";
        int index = locationCells.indexOf(stringGuess);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Kill";
            } else result = "Hit";
        }
        System.out.println(result);
        return result;
    }
}
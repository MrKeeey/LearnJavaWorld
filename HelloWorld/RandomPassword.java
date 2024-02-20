package HelloWorld;

import java.util.ArrayList;

public class RandomPassword {
    ArrayList<String> meow = new ArrayList<>();

    int minLength = 0;
    String minElement;
    public static void main(String[] args) {
        StringBuilder symbols = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+{}");
        StringBuilder generatePassword = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            generatePassword.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        System.out.println(generatePassword);

        ArrayList<String> mass = new ArrayList<>();
        mass.add("Possenger");
        mass.add("Piddnkb");
        mass.add("Passengercw");
        mass.add("Passengerc");
        mass.add("Piddnka");
        mass.add("Ponkal");
        mass.add("Ponkaw");
        new RandomPassword().go(mass, 1);
    }

    public void go(ArrayList<String> massiv, int elementForSort) {
        StringBuilder symb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        ArrayList<String> second = new ArrayList<>();

        int count = 0;
        String str = "";
        for (int i = 0; i < symb.length(); i++) {
            for (int j = 0; j < massiv.size(); j++) {
                if (symb.charAt(i) == massiv.get(j).charAt(elementForSort)) {
                    count++;
                    str = massiv.get(j);
                    second.add(massiv.get(j));
                    System.out.println(str);
                }
            }

            if (count == 1) {
                meow.add(str);
                massiv.remove(str);
                //second.clear();
            }
            if (count >= 2) {
                //System.out.println(second);
                elementForSort++;
                lengthElement(second);
                if (elementForSort > (minLength - 1)) {
                    System.out.println(elementForSort + " oh no " + minLength);
                    if (second.size() == 2) {
                        meow.add(minElement);
                        second.remove(minElement);
                        meow.add(second.get(0));
                        //second.clear();
                    }
                    if (second.size() > 2) {
                        meow.add(minElement);
                        second.remove(minElement);
                    }
                    break;
                } else {
                    for (String s : second) {
                        massiv.remove(s);
                    }
                    go(second, elementForSort);
                    //second.clear();
                }
            }
            count = 0;
        }
        //System.out.println(meow);
        //System.out.println(massiv);

    }

    public void lengthElement(ArrayList<String> searchMinLength) {
        minElement = searchMinLength.get(0);
        minLength = searchMinLength.get(0).length();
        for (int i = 1; i < searchMinLength.size(); i++) {
            if (minLength > searchMinLength.get(i).length()) {
                minLength = searchMinLength.get(i).length();
                minElement = searchMinLength.get(i);
            }
        }
    }
}

package LearnWithBook.chapter1;

public class SongOfBeer {
    public static void main(String[] args) {

        int BeerNum = 99, remainder;
        String Bottle = "Бутылок";

        while (BeerNum > 0){
            System.out.println(BeerNum + " " + Bottle + " пива на стене");
            System.out.println(BeerNum + " " + Bottle + " пива!");
            System.out.println("Возьми одну. Пусти по кругу.");
            BeerNum--;
            remainder = BeerNum % 10;
            if (remainder == 1 && BeerNum != 11) {
                Bottle = "Бутылка";
            } else if (remainder >= 2 && remainder <= 4 && BeerNum != 12 && BeerNum != 13 && BeerNum != 14) {
                Bottle = "Бутылки";
            } else {
                Bottle = "Бутылок";
            }
            if (BeerNum > 0) {
                System.out.println(BeerNum + " " + Bottle + " пива на стене");
            } else {
                System.out.println("Нет бутылок пива на стене");
            }
        }
    }
}

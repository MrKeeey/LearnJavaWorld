public class Tasks {
    public static void main(String[] args) {
        int counter = 0, bottle5 = 5;
        double bottle55 = 5.5, costbottle5 = 2.1, costbottle55 = 2.68;

        System.out.println("");
        while (counter < 10){
            System.out.println(bottle5 + " = " + String.format("%.2f",costbottle5) + " | " + bottle55 + " = " + String.format("%.2f",costbottle55));
            bottle5 = bottle5 + 5;
            costbottle5 = costbottle5 + 2.1;
            bottle55 = bottle55 + 5.5;
            costbottle55 = costbottle55 + 2.68;
            counter++;
        }
    }
}

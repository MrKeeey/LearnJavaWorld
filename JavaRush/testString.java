package JavaRush;

public class testString {
    public static void main(String[] args) {
        String line = "Hello world";
        String charLine = "Pspvvve";
        String byteLine = "3";
        String shortLine = "113";
        String intLine = "442";
        String floatLine = "43.88f";
        String doubleLine = "12345678901.333";
        String booleanLine = "true";

        System.out.println(line.length());
        System.out.println(line.toLowerCase());
        System.out.println(line.toUpperCase());
        System.out.println(charLine.toCharArray());
        System.out.println(Byte.parseByte(byteLine));
        System.out.println(Short.parseShort(shortLine));
        System.out.println(Integer.parseInt(intLine));
        System.out.println(Float.parseFloat(floatLine));
        System.out.println(Double.parseDouble(doubleLine));
        System.out.println(Boolean.parseBoolean(booleanLine));

    }
}

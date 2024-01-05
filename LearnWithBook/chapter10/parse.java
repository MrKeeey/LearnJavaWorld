package LearnWithBook.chapter10;

public class parse {
    public static void main(String[] args) {
        String str = "2";
        int x = Integer.parseInt(str);
        double d = Double.parseDouble("420.24");
        boolean b = new Boolean("true").booleanValue();

        String strB = "false";
        boolean bb = Boolean.parseBoolean(strB);

        System.out.println(str + " " + x + " " + d + " " + b + " " + bb);

        double strD = 42.5;
        String doubleStr = "" + strD;

        double strD2 = 42.6;
        String doubleStr2 = Double.toString(strD2);

        System.out.println(doubleStr + " " + doubleStr2);
    }
}

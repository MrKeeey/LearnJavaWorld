import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ScannerandBufferedReader {
    public static void main(String[] args) throws IOException {
        String[] TestString = new String[3];

        //input with scanner
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) TestString[i] = scanner.nextLine();
        System.out.println(Arrays.toString(TestString));

        //input with reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) TestString[i] = reader.readLine();
        System.out.println(Arrays.toString(TestString));
        //System.out.println(scanner);
        //int chislo = Integer.parseInt(TestString[0]);
    }
}

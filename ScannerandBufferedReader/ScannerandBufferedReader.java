import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class ScannerandBufferedReader {
    String[] TestString = new String[3];

    Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) TestString[i] = scanner.nextLine();
        System.out.println(Arrays.toString(TestString));

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) TestString[i] = reader.readLine();
        System.out.println(Arrays.toString(TestString));
    //int chislo = Integer.parseInt(TestString[0]);
}

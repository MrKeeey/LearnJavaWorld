package HelloWorld;

public class RandomPassword {
    public static void main(String[] args) {
        StringBuilder symbols = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+{}");
        StringBuilder generatePassword = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            generatePassword.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        System.out.println(generatePassword);

    }
}

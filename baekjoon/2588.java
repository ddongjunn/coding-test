import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = scan.nextLine();
        String y = scan.nextLine();

        System.out.println(Integer.parseInt(x)*Integer.parseInt(String.valueOf(y.charAt(2))));
        System.out.println(Integer.parseInt(x)*Integer.parseInt(String.valueOf(y.charAt(1))));
        System.out.println(Integer.parseInt(x)*Integer.parseInt(String.valueOf(y.charAt(0))));
        System.out.println(Integer.parseInt(x)*Integer.parseInt(y));
    }
}

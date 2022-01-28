import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        LocalDate date = LocalDate.of(2007,Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());

    }
}

import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        String ticket = "623123";
        System.out.println(isMyTicketLucky(ticket));

    }
    //Здесь не предусматривается никакая дополнительная обработка типа ограничений на символы
    public static boolean isMyTicketLucky (String ticketNumber){
        return String.valueOf(ticketNumber.chars()
                .mapToObj(i -> (char) i).limit(3)
                .mapToInt(x -> Integer.parseInt(x.toString())).sum())
                .equals(String.valueOf(ticketNumber.chars()
                        .mapToObj(i->(char)i).skip(3)
                        .mapToInt(x-> Integer.parseInt(x.toString())).sum()));
    }
}

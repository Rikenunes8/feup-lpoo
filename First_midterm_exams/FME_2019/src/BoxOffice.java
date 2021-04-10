import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concert, int i) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();

        for (int _=0; _ < i; _++) {
            tickets.add(new Ticket(concert.buyTicket(), concert));
        }
        return tickets;
    }
}

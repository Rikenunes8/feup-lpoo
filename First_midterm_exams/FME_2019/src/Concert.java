import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private List<Act> acts;

    private int nTickets = 1;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.acts = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void addAct(Act a) {
        acts.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) && Objects.equals(country, concert.country) && Objects.equals(date, concert.date) && Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist) {
        for (Act a:acts) {
            if (a.participates(artist))
                return true;
        }
        return false;
    }

    public int buyTicket() {
        return this.nTickets++;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> persons = new ArrayList<>();

    public  Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
    }
    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }
    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }
    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setTitle(String talkALot) {
        this.title = talkALot;
    }

    public void setDate(String s) {
        this.date = s;
    }

    public void setDescription(String s) {
        this.description = s;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return this.title.equals(event.title) && this.date.equals(event.date) && this.description.equals(event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public void addPerson(Person p) {
        for (Person person:persons) {
            if (person.getName().equals(p.getName())) {
                return;
            }
        }
        persons.add(p);
    }

    public int getAudienceCount() {
        return persons.size();
    }

    public void addEvent(Event e) {
        for (Person p:e.getPersons()) {
            this.addPerson(p);
        }
    }
}

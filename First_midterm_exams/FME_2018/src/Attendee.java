public class Attendee extends Person {
    public Attendee(String name) {
        super(name);
    }
    public Attendee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Attendee " + this.getName() + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }

    public boolean hasPaid() {
        return false;
    }
}

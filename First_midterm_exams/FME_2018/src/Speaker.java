public class Speaker extends Person {

    public Speaker(String name) {
        super(name);
    }
    public Speaker(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Speaker " + this.getName() + " has a fee value of " + getFee() + ".";
    }

    public int getFee() {
        return 0;
    }
}

public class InvalidTicket extends Exception {
    int number;
    public InvalidTicket(int number) {
        this.number = number;
    }
}

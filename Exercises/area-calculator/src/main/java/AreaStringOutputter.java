public class AreaStringOutputter {
    private SumProvider sumer;
    public AreaStringOutputter(SumProvider sumer) {
        this.sumer = sumer;
    }
    public String output() {
        return "Sum of areas: " + sumer.sum();
    }

}

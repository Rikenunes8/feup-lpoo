public class AreaXMLOutputter {
    private SumProvider sumer;
    public AreaXMLOutputter(SumProvider agg) {
        this.sumer = agg;
    }
    public String output() {
        return "<area>"+ sumer.sum()+"</area>";
    }
}

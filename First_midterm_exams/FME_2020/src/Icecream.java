import java.util.ArrayList;
import java.util.List;

public class Icecream {
    List<Flavor> scoops;
    public Icecream() {
        this.scoops = new ArrayList<>();
    }

    public void addScoop(Flavor scoop) {
        this.scoops.add(scoop);
    }
    public  void remScoop() {
        this.scoops.remove(this.scoops.size()-1);
    }

    public int getScoopCount() {
        return scoops.size();
    }

    public boolean contains(String scoop) {
        return contains(scoop, this.scoops);
    }

    private boolean contains(String scoop, List<Flavor> flavors) {
        for (Flavor f:flavors) {
            if (f.getName().equals(scoop))
                return true;
        }
        return false;
    }

    public int getFlavorCount() {
        List<Flavor> flavors = new ArrayList<>();

        for (Flavor f:scoops) {
            if (!contains(f.getName(), flavors))
                flavors.add(f);
        }
        return flavors.size();
    }
}

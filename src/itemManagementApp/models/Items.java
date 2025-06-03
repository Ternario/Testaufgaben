package itemManagementApp.models;

public class Items {
    private final String name;
    private final double weight;

    public Items(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getFullInfo() {
        return "%s, %.2f kg".formatted(name, weight);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}

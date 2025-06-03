package itemManagementApp.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final List<Items> items = new ArrayList<>();
    private double totalWeight;

    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    private void setTotalWeight() {
        double newTotalWeight = 0;

        if (!items.isEmpty()) {
            for (Items item : items) {
                newTotalWeight += item.getWeight();
            }
        }

        totalWeight = newTotalWeight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return ("%s %s".formatted(firstName, lastName));
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public List<Items> getItems() {
        return items;
    }

    public void addItem(Items item) {
        items.add(item);
        setTotalWeight();
    }

    public void removeItem(Items item) {
        items.remove(item);
        setTotalWeight();
    }
}

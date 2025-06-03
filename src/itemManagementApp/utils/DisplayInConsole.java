package itemManagementApp.utils;

import itemManagementApp.models.Items;
import itemManagementApp.models.Person;

import java.util.List;

public class DisplayInConsole {

    private final List<Person> persons;

    public DisplayInConsole(List<Person> persons) {
        this.persons = persons;
    }

    public void personsInformation() {
        for (Person person : persons) {
            String firstName = person.getFirstName();
            String lastName = person.getLastName();
            String gender = person.getGender();
            int age = person.getAge();

            System.out.printf("First Name: %s, Last Name: %s%n", firstName, lastName);
            System.out.println("Gender: " + gender);
            System.out.println("Age: " + age);

            System.out.println(addSeparator());
        }
    }

    public void objectsDistribution() {
        String formatWithNamePattern = "%-22s %s%n";
        String weightInfoPattern = "Gesamtgewicht: %.2f kg%n";

        for (Person person : persons) {
            String name = person.getFullName();
            List<Items> items = person.getItems();


            if (items.isEmpty()) {
                System.out.printf("%s: %s%n", name, "Keine Gegenstände");
                System.out.println(addSeparator());
                continue;
            }

            double totalWeight = person.getTotalWeight();

            if (items.size() == 1) {
                String firstItem = items.getFirst().getFullInfo();

                System.out.printf(formatWithNamePattern, name + ":", firstItem);
                System.out.printf(weightInfoPattern, totalWeight);
                System.out.println(addSeparator());
                continue;
            }

            for (int i = 0; i < items.size(); i++) {
                String itemInfo = items.get(i).getFullInfo();

                if (i > 0) {
                    System.out.printf("%23s%s%n", "", itemInfo);
                } else {
                    System.out.printf(formatWithNamePattern, name + ":", itemInfo);
                }
            }

            System.out.printf(weightInfoPattern, totalWeight);
            System.out.println(addSeparator());
        }
    }

    private String addSeparator() {
        return "-------------------------------------------";
    }
}

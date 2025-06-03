package itemManagementApp.utils;

import itemManagementApp.models.Person;

import java.util.List;
import java.util.Scanner;

public class PersonSelector {
    private final Scanner scanner;

    public PersonSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public Person selectPerson(List<Person> persons, boolean checkItems) {
        String emptyObjectsInfoText = "Dieser Mensch hat keine Gegenstände, wählen Sie einen anderen.";

        while (true) {
            for (int i = 0; i < persons.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, persons.get(i).getFullName());
            }

            String selectedPerson = scanner.nextLine();

            if (selectedPerson.isEmpty()) {
                System.out.println("Eingabe ist leer. Bitte erneut eingeben.");
                continue;
            }

            try {
                int index = Integer.parseInt(selectedPerson);

                if (index > 0 && index - 1 < persons.size()) {
                    Person person = persons.get(index - 1);

                    if (checkItems) {
                        if (person.getItems().isEmpty()) {
                            System.out.println(emptyObjectsInfoText);
                            continue;
                        } else {
                            return person;
                        }
                    }

                    return person;
                } else {
                    System.out.println("Ungültige Nummer.");
                }
            } catch (NumberFormatException e) {
                try {
                    for (Person person : persons) {
                        if (person.getFullName().equalsIgnoreCase(selectedPerson)) {

                            if (checkItems) {
                                if (person.getItems().isEmpty()) {
                                    System.out.println(emptyObjectsInfoText);
                                    continue;
                                } else {
                                    return person;
                                }
                            }

                            return person;
                        }
                    }

                    throw new IllegalArgumentException("Ungültiger Name.");
                } catch (IllegalArgumentException error) {
                    System.out.println(error.getMessage());
                }
            }
        }
    }
}

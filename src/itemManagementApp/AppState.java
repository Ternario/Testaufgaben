package itemManagementApp;

import itemManagementApp.models.Items;
import itemManagementApp.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Es wird eine Klasse erstellt, die die Anwendungszustände und -daten speichert.
public class AppState {
    private final Scanner scanner = new Scanner(System.in);
    private int transfersCounter = 0;
    private final List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("Anna", "Schmidt", 28, "weiblich"));
        persons.add(new Person("Lars", "Müller", 34, "männlich"));
        persons.add(new Person("Sophie", "Becker", 22, "weiblich"));
        persons.add(new Person("Tom", "Klein", 40, "männlich"));
        persons.add(new Person("Lea", "Hoffmann", 30, "weiblich"));

        persons.get(0).addItem(new Items("Tasche", 2.5));
        persons.get(0).addItem(new Items("Bücher", 1.5));
        persons.get(0).addItem(new Items("Regenschirm", 1.0));

        persons.get(1).addItem(new Items("Laptop", 3.0));
        persons.get(1).addItem(new Items("Maus", 0.2));
        persons.get(1).addItem(new Items("Ladegerät", 1.5));

        persons.get(2).addItem(new Items("Kamera", 1.2));
        persons.get(2).addItem(new Items("Stativ", 2.0));
        persons.get(2).addItem(new Items("Speicherkarte", 0.1));

        persons.get(3).addItem(new Items("Sporttasche", 4.0));
        persons.get(3).addItem(new Items("Trinkflasche", 1.0));
        persons.get(3).addItem(new Items("Handtuch", 1.0));

        persons.get(4).addItem(new Items("Tablet", 0.7));
        persons.get(4).addItem(new Items("Stift", 0.1));
        persons.get(4).addItem(new Items("Notizbuch", 0.5));
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void closeScanner() {
        scanner.close();
    }

    public List<Person> getPersonsList() {
        return persons;
    }

    public int getTransfersCounter() {
        return transfersCounter;
    }

    public void increaseTransferCounter() {
        transfersCounter++;
    }
}

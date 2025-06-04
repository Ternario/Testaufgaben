package itemManagementApp.service;

import itemManagementApp.models.Items;
import itemManagementApp.models.Person;
import itemManagementApp.utils.PersonSelector;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Es wird eine Klasse eingerichtet, um den Vorgang der Umverteilung von Artikeln zu bearbeiten,
//  die Anzahl der Umtauschvorgänge zu verfolgen und die Einhaltung der festgelegten Grenzwerte zu überwachen.
public class TransferManager {
    private final Scanner scanner;
    private final List<Person> persons;
    private final Runnable increaseTransferCounter;
    private final PersonSelector personSelector;

    public TransferManager(Scanner scanner, List<Person> persons, Runnable increaseTransferCounter) {
        this.scanner = scanner;
        this.persons = persons;
        this.increaseTransferCounter = increaseTransferCounter;
        this.personSelector = new PersonSelector(scanner);
    }

    public void objectManager() {
        System.out.println("""
                Wählen Sie in der Liste die Person mit voller Name oder\s
                Nummer aus, von der Sie das Objekt verschieben möchten.
                \s""");

        //  Erhalt der ersten ausgewählten Persona
        Person firstPerson = personSelector.selectPerson(persons, true);

        //  Erstellung einer neuen Liste von Personen, ohne die Person, von der der Gegenstand übertragen wird.
        List<Person> newPersonList = new ArrayList<>(persons);
        newPersonList.remove(firstPerson);

        //  Ruft eine Liste mit den Items der ausgewählten Persona ab.
        List<Items> items = firstPerson.getItems();

        int itemIndex;
        boolean isContinueThingTransfer = true;

        while (isContinueThingTransfer) {
            System.out.println("""
                    Wählen Sie die Nummer der zu übertragenden Position oder\s
                    schreiben Sie das Wort „Exit“, um die Übertragung abzubrechen.
                    \s""");

            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, items.get(i).getFullInfo());
            }

            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Feld kann nicht leer sein.");
                continue;
            }

            if (input.equalsIgnoreCase("exit")) {
                isContinueThingTransfer = false;
            }

            try {
                if (Integer.parseInt(input) > 0 && Integer.parseInt(input) - 1 < items.size()) {
                    itemIndex = Integer.parseInt(input) - 1;
                } else {
                    System.out.println("Ungültige Nummer.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Für die Eingabe stehen nur Zahlen oder das Wort „Exit“ zur Verfügung.");
                continue;
            }

            System.out.println("""
                    Wählen Sie in der Liste die Person mit voller Name oder \s
                    Nummer aus, zu der Sie das Objekt verschieben möchten.
                    \s""");

            //  Erhalt der zweiten ausgewählten Persona
            Person secondPerson = personSelector.selectPerson(newPersonList, false);

            //  Abruf eines Elements nach Index
            Items selectedItem = items.get(itemIndex);

            if (secondPerson.getItems().size() >= 5) {
                System.out.println("Eine Person kann nicht mehr als 5 Gegenstände auf einmal haben.");
                continue;
            }

            double personTotalWeight = secondPerson.getTotalWeight();

            if (personTotalWeight + selectedItem.getWeight() > 10) {
                System.out.println("Das Gesamtgewicht darf 10 Kilogramm nicht überschreiten.");
                continue;
            }

            secondPerson.addItem(selectedItem);
            firstPerson.removeItem(selectedItem);
            increaseTransferCounter.run();

            isContinueThingTransfer = false;
        }
    }
}

package itemManagementApp.utils;

import itemManagementApp.AppState;
import itemManagementApp.service.TransferManager;

import java.util.Scanner;

public class Menu {
    private final AppState appState = new AppState();
    private final Scanner scanner = appState.getScanner();
    private final DisplayInConsole displayInConsole = new DisplayInConsole(appState.getPersonsList());
    private final TransferManager transferManager = new TransferManager(scanner, appState.getPersonsList(),
            appState::increaseTransferCounter);

    public void start() {
        String firstIfoString = "1 - Ein kurzer Überblick über die Personen.";
        String secondInfoString = "2 - Übersicht über die Anordnung der Objekte.";
        String exitInfoString = "Beenden der Arbeit.";

        String numberInputErrorText = "Ungültige Nummer.";
        String emptyInputErrorText = "Feld kann nicht leer sein.";

        boolean isContinueAppFlag = true;

        while (isContinueAppFlag) {
            if (appState.getTransfersCounter() >= 6) {
                System.out.println("Sie haben Ihr Limit für die Übertragung von Artikeln erreicht.");
                System.out.println(firstIfoString);
                System.out.println(secondInfoString);
                System.out.println("3 - " + exitInfoString);

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            displayInConsole.personsInformation();
                            break;
                        case 2:
                            displayInConsole.objectsDistribution();
                            break;
                        case 3:
                            isContinueAppFlag = false;
                            break;
                        default:
                            System.out.println(numberInputErrorText);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(emptyInputErrorText);
                }
            } else {
                System.out.println(firstIfoString);
                System.out.println(secondInfoString);
                System.out.println("3 - Umverteilung der Gegenstände.");
                System.out.println("4 - " + exitInfoString);

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            displayInConsole.personsInformation();
                            break;
                        case 2:
                            displayInConsole.objectsDistribution();
                            break;
                        case 3:
                            transferManager.objectManager();
                            break;
                        case 4:
                            isContinueAppFlag = false;
                            break;
                        default:
                            System.out.println(numberInputErrorText);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(emptyInputErrorText);
                }
            }
        }

        appState.closeScanner();
    }
}

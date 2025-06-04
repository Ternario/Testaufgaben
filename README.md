1. Stabilität und Korrektheit des Codes:
   Die folgenden Maßnahmen wurden ergriffen, um einen stabilen Betrieb des Programms zu sichern:

    - Fehlerbehandlung bei Benutzereingaben:

   Bei der Eingabe von Daten (Zahlen oder Zeichenketten) kann es vorkommen, dass der Benutzer falsche Daten eingibt
   (Zeichenkette anstelle einer Zahl, Angabe einer Zahl, die außerhalb der für die Auswahl vorgesehenen Grenzen liegt).
   Die folgenden Fehlerbehandlungsmethoden werden verwendet, um einen Programmabbruch zu verhindern:

       - try-catch zur Behandlung von Ausnahmen,
       - if , if - else Operatoren,
       - Typkonvertierung in Fällen, in denen der Benutzer das Ergebnis nicht nur durch Eingabe einer Zahl, 
         sondern auch einer Zeichenkette erhalten könnte.

   Dies verhindert, dass das Programm abstürzt und gibt dem Benutzer die Möglichkeit, den richtigen Wert erneut
   einzugeben.

   Beispiele:

         1. Überprüfung der Division durch Null.
            Alle Operationen, bei denen eine Division möglich ist (einschließlich Modulo), enthalten eine Prüfung: 
            - Wenn die zweite Zahl Null ist, wird eine ArithmeticException-Ausnahme ausgelöst und der Benutzer wird 
              aufgefordert, einen anderen Wert einzugeben.

         2. Beschränkungen für die Anzahl der Artikel und das Gewicht.
            Im 3 Projekt sind Beschränkungen für die Übertragung von Gegenständen implementiert:
            - Maximal 5 Gegenstände pro Person.
            - Gesamtgewicht nicht mehr als 10kg pro Person.
            - Maximal 6 Transfers pro Sitzung.

    - Testen aller Funktionen:

   Jede Operation in allen Aufgaben wurde manuell mit verschiedenen Werten getestet, z.B.:

         1. In der zweiten Aufgabe (Taschenrechner) kann der Benutzer eine von 6 mathematischen Operationen
            (1, 2, 3, 4, 5, 6) auswählen, indem er eine Zahl aus der Liste eingibt. Wenn der Benutzer versucht,
            0 oder 7 einzugeben, erhält er die Meldung „Der ausgewählte Vorgang existiert nicht oder ist nicht 
            vorhanden. Bitte wählen Sie einen der verfügbaren Vorgänge: 1 - 6“.

         2. Beim Versuch, eine Zeichenkette einzugeben, erhält der Benutzer eine Meldung: „Nur Nummern sind zur Eingabe
            verfügbar. Bitte wählen Sie einen der verfügbaren Vorgänge: 1 - 6“.

2. Wie das Material erlernt wurde und wie der Entwicklungsprozess verlief
   Der Entwicklungsprozess wurde in Etappen organisiert:

   Etappen:

    - Das Lernen erfolgte durch Dokumentation, Video-Tutorials und Übung.

            - Java-Grundlagen
            - OOP: Klassen, Objekte, Konstruktoren in Java
            - Arbeiten mit Sammlungen (List, Map)
            - Eingabe/Ausgabe-Verarbeitung (Scanner, System.out.println, printf)

    - Aufgabenanalyse und Architekturplanung.

           - Festlegung der Struktur der Anwendung, Feststellung der Notwendigkeit der Aufteilung der Anwendung in 
             Klassen nach Aufgabenbereichen.
           - Durchdenken von Zusammenhängen zwischen Klassen, Methoden, Übergabe von Argumenten im OOP-Stil.
           - Erstellung von Basisklassen.

    - Implementierung der Funktionalität.

           - Hinzufügen von Menü, Programmschleife, Aktionsauswahl.
           - Implementierung von Eingabe-/Ausgabemethoden, Datenvalidierung, Fehlerbehandlung.
           - Implementierung der Änderung von Objekten (Übertragung von Objekten) unter Berücksichtigung von
             Randbedingungen.

    - Code-Verbesserung und Refactoring.

           - Code-Duplizierung wurde entfernt.
           - Verbesserte Interaktion zwischen den Klassen.

    - Abschließende Tests.

           - Alle Funktionen wurden auf ihre Funktionsfähigkeit getestet.
           - Getestet wurden die Tastatureingabe, die Ausgabe der Ergebnisse, die Arbeit mit Zahlen mit Komma und Punkt,
             die Arbeit mit Strings und die Ausgabe der entsprechenden Informationen.
           - Die Korrektheit der Erhöhung des Gangzählers, die Überprüfung des Gesamtgewichts der Artikel und der Anzahl
             derArtikel wurde überprüft.

3. Software-Tools und Instrumente:

         - IDE: IntelliJ IDEA - wird zum Schreiben, Ausführen und Debuggen des Programms verwendet.
         - Programmiersprache: Java.
         - Versionskontrolle: Git.
         - Standard-Java-Bibliotheken: Scanner, ArrayList, HashMap, Math.
         - Konsole: Standard-Java-Konsole (System.in/out).
         - Testen: manuell, durch Ausführen des Programms und Überprüfen aller Skripte.
         - Anwendung von OOP-Prinzipien: Kapselung, Trennung von Verantwortlichkeiten, Dependency Injection.

4. Zeitaufwand für die Fertigstellung:

    - Die Gesamtzeit für die Erledigung aller Aufgaben betrug etwa 25 - 26 Stunden, die sich wie folgt verteilen:

          - Die Grundlagen der Information: 3 Stunden.
          - Erste Aufgabe: 3.5 - 4 Stunden.
          - Zweite Aufgabe: 5 Stunden.
          - Dritte Aufgabe: 9 - 10 Stunden.
          - Prüfen, Einstellen, Reinigen, Verbessern und abschließendes Testen: 2 Stunden.
          - Bericht schreiben: 2 - 2.5 Stunden.       

5. Eine kurze Beschreibung der Umsetzung der dritten Aufgabe und Annahmen für Verbesserungen.

    - Alle Bedingungen und Anforderungen für die Aufgabe sind erfüllt. Die Anwendung ist in Klassen unterteilt,
      von denen jede bestimmte Aufgaben erfüllt. Die Klassen Person und Gegenstand wurden entsprechend
      den Anforderungen der Aufgabe erstellt. Das Menü ist etwas umfangreicher gestaltet,
      es umfasst nicht 2, sondern 4 Punkte:

            - Der 1 Menüpunkt ist für die Anzeige der Liste der Personen mit ihren vollständigen Informationen 
              (Vorname, Nachname, Geschlecht und Alter) zuständig. Ich habe diese Informationen nicht mit den Informationen 
              über die Verteilung der Objekte kombiniert, da dies die Arbeit mit der Konsole und die Anzeige in ihr 
              visuell und technisch überfordert.

            - Der 2 Menüpunkt ist für die Anzeige der Gegenstände zwischen den Personen zuständig, 
              die Konsole zeigt den Vor- und Nachnamen der Person, die Liste der Gegenstände (jeder Gegenstand ist 
              nummeriert und sein Name und Gewicht werden angezeigt), das Gesamtgewicht der Gegenstände.

            - Der 3 Menüpunkt ist für die Verteilung der Gegenstände zuständig. Zunächst muss der Benutzer die Person 
              anhand der Nummer aus der Liste oder des Vor- und Nachnamens der Person auswählen. Dann wird dem Benutzer 
              angeboten, den zu übertragenden Gegenstand auszuwählen. Und zum Schluss wird angeboten, die Person 
              auszuwählen, an die dieser Gegenstand übertragen werden soll (ebenfalls nach Nummer aus der Liste oder 
              Vor- und Nachname).

            - Der 4 Menüpunkt ist für das Verlassen des Programms zuständig.

    - Ich habe die Auswahl von Elementen nach ihrer Nummer in der Liste implementiert, um die Implementierung und
      die Fehlerprüfung zu vereinfachen und um es dem Benutzer zu erleichtern, sie in der Konsole auszuwählen (indem
      er eine Nummer statt eines Namens schreibt).

    - Ich habe es möglich gemacht, Personen beim Übertragen von Dingen auch nach ihrem vollen Namen auszuwählen,
      falls die Liste zu groß wird und die Suche in der Konsole nicht sehr bequem ist.

    - Um diese Anwendung zu verbessern (zu erweitern), würde ich die folgenden Punkte umsetzen:

            - Hinzufügen eines neuen Feldes zur Personenklasse zur Identifizierung bei der Anzeige in der Liste (falls 
              es mehrere Personen mit demselben Vor- und Nachnamen gibt), z. B. Position, Abteilung und andere.

            - Hinzufügen einer Login-Funktionalität zum Verteilen von Gegenständen, da jetzt in der Anwendung 
              das Verschieben von Gegenständen anonym ist.

            - Protokollierung des Verschiebens von Gegenständen (wer hat den Gegenstand verschoben, was wurde 
              verschoben, von wem und an wen).

            - Funktionalität zum Hinzufügen neuer Personen und Gegenstände nach dem „Login“.

            - Zugangsbeschränkungen für das Verschieben von Gegenständen. Zum Beispiel kann nur der Administrator 
              Dinge verschieben, und nur der Administrator kann Gegenstände oder Personen hinzufügen oder entfernen.
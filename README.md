# CUIE Abschlussprojekt

## Custom Control für HydroPowerFX

Entwerfen und implementieren Sie ein Custom Control für das OOP2-Projekt 'HydroPowerFX' auf Basis JavaFX.
 - Das Custom Control soll eines (oder mehrere) der im OOP2-Projekt verwendeten Standard-Controls 
 (insbesondere `TextField`, `Label`, `Button`, `TableView`) ersetzen.
 - Das Custom Control soll den jeweiligen Arbeitsschritt optimal unterstützen, beispielsweise durch eine hochspezialisierte Anzeige oder eine 
effiziente Eingabemöglichkeit für einen/mehrere der Werte.
 - Falls ihr Custom Control ein _'einfaches, interaktives Anzeigeelement'_ ist, verwenden Sie bei der Implementierung die Struktur 
 wie im package `ch.fhnw.cuie.project.template_simplecontrol`.
 - Falls ihr Custom Control ein _'Business Control'_ ist, das z.B. eines der `TextFields` ersetzen soll, 
 verwenden Sie bei der Implementierung die Struktur wie im package `ch.fhnw.cuie.project.template_businesscontrol`.

## Bearbeitet von
 - Simon, Wächter

## Integriert in die OOP2-Projekte von
- _**Ergänzen Sie hier welche OOP2-Teams Ihr Custom Control erfolgreich integriert haben.**_


## Präsentation
- **Montag, 4.6.2018**, 19:00 bis 19:45 Uhr, Raum 1.047

- Die Custom Controls werden der OOP2-Klasse im Rahmen einer **Poster-Session** präsentiert.
 - Die Postersession startet mit einer Kurzpräsentation (1 bis 2 Minuten) aller Custom-Controls.
 - Danach werden die Custom-Controls gleichzeitig ausgestellt und Gelegenheit gegeben auf Detailfragen einzugehen.

- Erarbeiten Sie eine geeignete Präsentationsform, so dass das Interesse möglichst vieler OOP2-Teams 
an Ihrem Custom Control geweckt und ihr CustomControl in die jeweiligen OOP2-Projekte integrieren wird. 
Es stehen Stellwände zur Verfügung.

- Im Anschluss an die Postersession besteht die Möglichkeit Ihr Control zusammen mit dem OOP2-Team
in die jeweiligen OOP2-Projekte zu integrieren. Dies ist eine Gemeinschafts-Aufgabe von CUIE- und OOP2-Team.


## Abgabe
- **Mittwoch, 6.6.2017**, 20:42 Uhr

- Die Abgabe erfolgt durch einen "Push" auf den Master-Branch Ihres GitHub-Repositories.


## Bewertung
- Mit einer gut wahrnehmbaren Präsentation Ihres Custom Control an der Postersession haben Sie mindestens 
  eine 4.0 erreicht.

- **Nicht genügend** ist es wenn Sie an der Postersession nicht oder überwiegend passiv teilnehmen. 
**Das Spielen von Videospielen** wird zum Beispiel als passive Teilnahme angesehen.

- Durch eine gute Code-Qualität des Custom Control, d.h. insbesondere eine klare Struktur des Codes entsprechend der
 im Unterricht erarbeiteten Konzepte, können Sie eine 5.0 erreichen. Mit nicht compilierbarem Code kann keine bessere Note erreicht werden.

- Die Qualität des Controls aus Benutzersicht wird daran gemessen wie oft das Control in ein OOP2-Projekt integriert 
 wird. Jede Integration wird mit +0.5 bewertet.


## Bitte beachten Sie
 - Tragen Sie ihren Namen unter "Bearbeitet von" ein.

 - Tragen Sie die Namen der OOP2-Teilnehmer ein in dessen OOP2-Projekte ihr Custom-Control erfolgreich integriert wurde.

 - Es wird empfohlen das Projekt in 2-er Teams zu bearbeiten. 
   - Es wird erwartet, dass die Lösung gemeinsam erarbeitet und implementiert wird (Stichwort 'Pair-Programming').

 - Falls Sie das Assignment zu zweit bearbeiten:
   - tragen Sie beide Namen unter "Bearbeitet von" ein
   - arbeiten Sie ausschliesslich in einem Repository
   - falls sie beide Zugang zu diesem Repository wollen: tragen Sie die zweite Person als "Collaborator" ein (auf GitHub unter "Settings - > Collaborators & teams")
   - löschen Sie das nicht benötigte Repository (auf GitHub unter "Settings")
   - arbeiten Sie gemeinsam und gleichzeitig an den Aufgaben (Stichwort: Pair-Programming)
   - das Aufteilen und separate Bearbeiten von Aufgaben ist nicht erwünscht

 - Ausdrücklich erlaubt und erwünscht ist, dass Sie sich gegebenenfalls Hilfe holen.
 Das Programmierzentrum ist geöffnet und Nachfragen werden zum Beispiel über den im Repository integrierten 
 Issue Tracker oder per Mail gerne beantwortet. 


## Bei Problemen mit dem IntelliJ-Setup
Es kommt immer wieder mal vor, dass der Setup des IntelliJ-Projekts nicht auf Anhieb funktioniert oder "plötzlich"
nicht mehr funktioniert.

Sie brauchen in so einem Fall NICHT nochmal den Invitation-Link annehmen oder das Projekt via “Check out from Version Control” nochmal anlegen.

Statt dessen ist es am besten den IntelliJ-Setup neu generieren zu lassen. Dazu verwendet man den File "build.gradle", der eine 
komplette und IDE-unabhängige Projektbeschreibung enthält.

Die einzelnen Schritte:

- Schliessen Sie alle geöffneten Projekte (File -> Close Project)

- Wählen Sie “OPEN” 

- Es erscheint ein Finder-Fenster mit dem Sie zu ihrem Projekt navigieren.

- Dort wählen Sie den File “build.gradle” aus.

- Beim nächsten Dialog “Open as Project” wählen.

- Beim nächsten Dialog kontrollieren ob Java 9 ausgewählt ist.

- Dann “File already exists” mit YES bestätigen.

- ACHTUNG: Jetzt “Delete existing Project and Import” anklicken.

- Warten, warten, warten.

Wenn alles gut gegangen ist sollte im Project-View der Java-Ordner unter src/main blau sein und der Java-Ordner unter src/test grün.

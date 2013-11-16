# Bevor es richtig los geht

Bevor wir mit der eigentlichen Erstellung der Software beginnen, sollten wir kurz innehalten und darüber nachsinnen, womit wir es zu tun haben.  

Da wäre eine Black Box in der Mitte, an welcher ein Display und eine Tastatur hängen.

Dabei werden die Tasten-Anschläge in die Black Box geschickt und, in Abhängigkeit der Tasten-Anschläge, Resultate auf dem Display sichtbar.

Diese Resulate können sein

- der fortlaufende Aufbau einer Zahl
- nach Drücken von +, -, *, ÷, C das Löschen des Displays
- nach Drücken von = die Anzeige des Rechen-Ergebnisses   

Andererseits passiert noch etwas anderes in der Black Box.

Nach Eingabe des ersten Zahlenwertes scheint die Box sich diesen Wert _irgendwie_ zu merken.  
Dies passiert nach Drücken von +, -, *, ÷.  
Danach hofft die Box auf die Eingabe eines zweiten Zahlenwertes.  
Wird der zweite Zahlenwert mittels +, -, *, ÷, = abgeschlossen, steht ein Ergebnis zur Verfügung, welches zur Anzeige kommen kann.  

Heißt, die Box trägt eine Art Rechen-Maschinerie in sich, für zwei Operanden, welche je nach gewünschter Operation die beiden Operanden verknüpft.

Damit diese Rechen-Maschinerie _fehlerfrei_ rechnen kann, sind mathematisch korrekte Zahlenwerte erforderlich. Erste Anforderung.

Die Rechen-Maschinerie muß wie folgt arbeiten 

- Aufbewahren des ersten Zahlenwertes
- Aufbewahren der Art der gewünschten Operation
- Aufbewahren des zweiten Zahlenwertes
- Ausführen der gewünschten Operation mit erstem und zweiten Zahlenwert wenn wiederum eine Operations-Taste gedrückt wurde
- Beim Erkennen von +, -, *, ÷ als letzte Operations-Taste, wird das Ergebnis zusätzlich als _neuer_ erster Zahlenwert gemerkt.

(Manch einer wird hier eine Art Zustands-Maschine erkennen...)
  


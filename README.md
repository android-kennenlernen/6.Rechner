# 6. Rechner

Mittels der bisher erlangten Kenntnisse ist es nun möglich, ein erstes Projekt zu realisieren.  

Dies wird ein simpler Rechner nach Werbegeschenk-Art sein.  
Und zwar von der Sparkasse, weswegen es auch wichtig sein wird, negative Zahlen einzugeben.  
Von unsereins Minus lebt schließlich die Sparkasse.

**Hilfestellung**

Mittels des _Graphical Layout_ soll zunächst das Rechner-Layout erschaffen werden.

Dazu ist zunächst ein Ziffern-Block 

- mit den Tasten 0-9
- mit einer Dezimal-Punkt-Taste	(.)	
- mit einer Vorzeichen-Wechsel-Taste (±)

zu erstellen.  

Desweiteren sind mathematische Operations-Tasten zum

- Addieren (+)
- Subtrahieren (-)
- Multiplizieren (*)
- Dividieren (÷)

notwendig.

Letztendlich kommen noch jeweils 

- eine Lösch-Taste (C)
- Ergebnis-Taste (=)

hinzu.

Fangen wir an.

Zunächst ein neues Android-Projekt erstellen.  
Dann diese 'Hello world!'-TextView löschen.

![Image](./readme-img/1-dity-up.png)

Nun auf der linken Seite 'Layouts' öffnen.  
Dort auf das 'GridLayout' klicken, festhalten und auf die Oberfläche ziehen.

Nun in die **activity_main.xml** wechseln.  
Dann die beiden letzten Zeilen mit 'columnCount' und 'rowCount' einbringen.  

Normalerweise, normalerweise sollte dies per 'Properties'-Editor möglich sein.  
Ich habe es nicht geschafft, die gewünschten Zahlenwerte wurden einfach nicht übernommen.

```xml
    <GridLayout
		.
		.
        android:columnCount="4"
        android:rowCount="5" >

	</GridLayout>
```
Als nächstes wurden aus 'Form Widgets' Buttons vom Typ 'Small' in das 'GridLayout' übernommen.  
Dies kann durchaus zur Fummelei werden, bis man die Buttons in die richtige Position gebracht hat. Zum Teil möchten diese ausserhalb des 'GridLayout's einrasten.  
Hilfreich ist dabei, stets einen Blick auf die 'Outline' rechts neben dem Haupt-Fenster zu werfen, ob der Button auch im 'GridLayout' angekommen ist und nicht außerhalb dessen zur Ablage gelangte.  

Zum Schluß ist über dem 'GridLayout' eine 'EditText' einzubringen.
Ihr findet diese unter 'TextFields'. Runter-Scrollen bis zu 'Number (Decimal)'.  Dies ist dann das Richtige.  

Nun sollte das jungfräuliche Design fertig sein.

![Image](./readme-img/2-calc-virgin.png)

(Für heute ist zunächst Schluß)

![Image](./readme-img/4-calc-renamed.png)


![Image](./readme-img/3-rename-resource.png)
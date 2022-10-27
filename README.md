# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Ahmad Mohammad Debsouzeit, S362074, s362074@oslomet.no

Jeg fikk mest hjelp fra kompendiet og har samarbeidet med andre for noen oppgaver.

# Oppgavebeskrivelse

I oppgave 1 kopierte jeg programkode 5.2.3 a) fra kompendiet, og fikk feil på p = new Node<>(verdi), på konstruktøren til Node<T> på kildekode er det to parametre, verdi og forelderen. På programkode er q forelder, og prøvde å teste oppgaven så fikk jeg riktig på den.
På koden brukes to nodereferanser p og q. Referansen p starter i rotnoden. den flyttes så nedover i treet (venstre om verdi er mindre, og høyre om verdi er større), så brukte jeg Compare-metoden for å sammenligne. q skal passere p og blir siste noden, da skal den nye verdi legges og sammenlignes med q og setter som barn, enten til høyre eller venstre.

I oppgave 2 Koden skal sjekke om en gitt verdi er i treet og skal telle den opp hvis den er gjentatt. Jeg brukte inneholder() for å sjekke at verdi er i treet, så opprettet p som starter i roten og skal passere hele treet for å sjekke verdier. Jeg har også brukte litt samme som er på inneholde(), Komperator skal sammenligne verdier og gir oss 0 hvis de lignet. Hvis ikke så skal p går mot venstre og blir til null. Den tilslutt skal returnere antall verdier.

I oppgave 3 på førstepostorden, jeg har tatt koden fra Kompendiet programkode 5.1.7 h) og sjekket p er null ved å bruke Objects.requireNonNull metode, jeg kunne ikke bruke som koden har brukt, altså tom() metode, det er fordi førstPostOrden er private. og på nestepostorden Her brukte jeg mest kompendiet som hjelpet meg mye på å finne koden. koden er kommentert.

I oppgave 4 på postorden uten rekursjonen, her begynte jeg med å finne første noden i postOrden ved hjelp av førstepostorden() metode, og utførte oppgaven av dens verdi. Så brukte jeg while løkke for å gå gjennom hele treet, altså til p blir siste, jeg prøvde å skrive p != null og får at dette er "always true", på nestePostorden() som er brukt i postorden() er p sist hvis foreldren er null. Deretter finner koden neste node av q ved hjelp av nestePostorden, og utføre oppgaven hver gang det fant. 
På den andre metode her kallte jeg på postordenRecursiv for å gå gjennom hele treet, så utfører oppgaven for hver verdi i treet...

I oppgave 5..

I oppgave 6 Jeg kopierte programkoden 5.2.8 d) som sagt i oppagve for fjern() metode, og legget til b.forelder er q (b er barn som fikk den nye verdien som over) i tilfellet at den som fjernes er rot eller er barn til venstre. og S er forelder til r i tilfelle den som fjernes er barn til høyre...
På fjernAlle() kallte jeg på fjern() metode for å fjerne den gitte verdien, jeg brukte while løkke for å fjerne alle gjentatte verdier, og returnerer hvor mange er det fjernet...
Og på nullstill metode er laget ved hjelp av Kompendiet oppagver 5.2.8 5) der alle pekerne er satt til null...

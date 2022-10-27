package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) { // skal ligge i class SBinTre

            Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

            Node<T> p = rot, q = null;               // p starter i roten
            int cmp = 0;                             // hjelpevariabel

            while (p != null)       // fortsetter til p er ute av treet
            {
                q = p;                                 // q er forelder til p
                cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
                p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
            }

            // p er nå null, dvs. ute av treet, q er den siste vi passerte

        //Det er bare dette nede som endret fra kompendiet, ettersom vi legger en ny node på vårt prosjekt
        // så konstruktøren til Node skal ha q som forelder variabel, og slik at den får riktig verdi i hver gang
            p = new Node<>(verdi, q);                   // oppretter en ny node

            if (q == null) rot = p;                  // p blir rotnode
            else if (cmp < 0) q.venstre = p;         // venstre barn til q
            else q.høyre = p;                        // høyre barn til q

            antall++;                                // én verdi mer i treet
            return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        if (inneholder(verdi)) {//sjekker om verdi er i treet først...
            Node<T> p = rot; //p som passerer alle noder i treet...
            int antall = 0; //antall verdi...

            while (p != null) {
                int cmp = comp.compare(verdi, p.verdi);//bruker komperatoren...
                if (cmp < 0) p = p.venstre;
                else p = p.høyre;
                if (cmp == 0) {
                    antall++;
                }
                }
            return antall;
            }
        else return 0;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        Objects.requireNonNull(p);//sjekker p ikke er null...

       // Node<T> p = rot;
        while (true)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node <T> f = p.forelder;//oppretter forelder...
        if (f == null) return null;//hvis p er siste i postorden, skal returnere null...
       else if (f.høyre == null) return f;//hvis p er enebarn, er f den neste...
       else if (f.høyre == p) return f;//hvis p er høyre barn til sin forelder, er f den neste...
       else return førstePostorden(f.høyre);//Hvis p ikke er enebarn, så er den neste den noden som kommer
        // først i postorden i subtreet med f.høyre som rot.
    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> q = rot; //oppretter en hjelper q som begynner fra roten...
        Node<T> p = førstePostorden(q); //Finner første node av q...
        oppgave.utførOppgave(p.verdi); //utføre oppgave etter vi funnet førstePostorden...
        while (p.forelder != null) { //p skal passere hele treet...
            p = nestePostorden(q);//gi den neste...
            oppgave.utførOppgave(Objects.requireNonNull(p).verdi);//utføre oppgave hver gang vi finner nestePostorden...
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p != null) {
            postordenRecursive(p.venstre, oppgave); //går gjennom treet for p sitt venstre barn og utføre oppgave...
            postordenRecursive(p.høyre, oppgave);  //går gjennom treet for p sitt høye barn og utføre oppgave...
            oppgave.utførOppgave(p.verdi); //utfør oppgaven for hvert steg...
        }
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre

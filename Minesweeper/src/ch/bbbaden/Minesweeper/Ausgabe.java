package ch.bbbaden.Minesweeper;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.Scanner;

public class Ausgabe {


    private int reihe;
    private int spalte;
    private int markieren;
    private long timeElapsed;
    public long start;


    private Random rand = new Random();
    private int upperbound = 5;
    private int anzahlBomben = 0;
    private char[][] feld = new char[upperbound][upperbound];
    private char[][] verdecktesFeld = new char[upperbound][upperbound];
    private Scanner eingabewert = new Scanner(System.in);

    public void verdecktesArrayBefüllen() {
        for (int x = 0; x < verdecktesFeld.length; x++) {
            for (int y = 0; y < verdecktesFeld[x].length; y++) {
                verdecktesFeld[x][y] = '*';
                System.out.print(verdecktesFeld[x][y]);

            }
            System.out.println();
        }
    }

    public void ueberschreiben() {
        verdecktesFeld[reihe][spalte] = feld[reihe][spalte];
    }

    public void bombenPlatzieren() {
        while (anzahlBomben < 5) {

            int x = rand.nextInt(upperbound);
            int y = rand.nextInt(upperbound);


            if (feld[x][y] != 'x') {
                feld[x][y] = 'x';
                anzahlBomben++;
            }
        }

    }

    public void feldBefuellen() {

        for (int x = 0; x < feld.length; x++) {
            for (int y = 0; y < feld[x].length; y++) {
                if (feld[x][y] != 'x') {
                    feld[x][y] = '-';
                }
                System.out.print(feld[x][y]);

            }
            System.out.println();
        }

    }

    public void eingabeSpalte() {

        System.out.println("Geben Sie die Spalte ein: ");
        spalte = eingabewert.nextInt();
        if (spalte >= upperbound) {
            System.out.println("Falsche Eingabe");
            eingabeSpalte();
        }


    }

    public void eingabeReihe() {

        System.out.println("Geben Sie die Reihe ein: ");

        reihe = eingabewert.nextInt();
        if (reihe >= upperbound) {
            System.out.println("Falsche Eingabe");
            eingabeReihe();
        }


    }

    public void verdecktesFeldAusgabe() {
        for (int x = 0; x < verdecktesFeld.length; x++) {
            for (int y = 0; y < verdecktesFeld[x].length; y++) {

                System.out.print(verdecktesFeld[x][y]);

            }
            System.out.println();
        }
    }

    public void benutzerInteraktion() {

        while (verdecktesFeld[reihe][spalte] != 'x') {

            eingabeReihe();
            eingabeSpalte();
            markierenEingabe();
            ueberschreiben();
            verdecktesFeldAusgabe();
           // beenden();


        }
        if (verdecktesFeld[reihe][spalte] == 'x') {
            System.out.println("Oh-Oh! KABOOOOOOOM Bombe getroffen");
        }

    }


    public void markierenEingabe() {

        System.out.println("Wollen Sie das Feld Markieren? 0 für Ja | 1 für Nei: ");
        markieren = eingabewert.nextInt();
        if (markieren > 1) {
            System.out.println("Falsche Eingabe");
            markierenEingabe();
        }

        if (markieren == 0) {
            feld[reihe][spalte] = 'M';

        }


    }

    public void beenden() {
        int verdeckteBomben = 0;
        for (int x = 0; x < verdecktesFeld.length; x++) {
            for (int y = 0; y < verdecktesFeld[x].length; y++) {
                if (verdecktesFeld[x][y] == 'x') {
                    verdeckteBomben++;
                }

            }

        }
        if (verdeckteBomben == 0) {
            timerStop();
            System.out.println("Sie haben gewonnen! Ihre Zeit: " + timeElapsed + " Sek");
            System.exit(0);
        }
    }

    public void zahlenHinzufügen() {
        for (int x = 0; x < verdecktesFeld.length; x++) {
            for (int y = 0; y < verdecktesFeld[x].length; y++) {
                int anzahlBomben = 0;

                try {
                    if (feld[x - 1][y - 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x][y - 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x + 1][y - 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x - 1][y] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x + 1][y] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x - 1][y + 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x][y + 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }
                try {
                    if (feld[x + 1][y + 1] == 'x') {

                        anzahlBomben++;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {

                }

                feld[x][y] = Integer.toString(anzahlBomben).charAt(0);


            }
        }

    }

    public void timerStart() {
         start = System.currentTimeMillis();

    }

    public void timerStop() {
        long finish = System.currentTimeMillis();
        timeElapsed = (finish - start) / 1000 ;

    }
}





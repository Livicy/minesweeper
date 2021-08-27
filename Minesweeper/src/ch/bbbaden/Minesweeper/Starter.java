package ch.bbbaden.Minesweeper;

public class Starter {
    public static void main(String[] args) {
        Ausgabe ausgabe= new Ausgabe();
        ausgabe.bombenPlatzieren();
        ausgabe.feldBefuellen();
        ausgabe.zahlenHinzufügen();
       ausgabe.verdecktesArrayBefüllen();
       ausgabe.timerStart();
        ausgabe.benutzerInteraktion();


    }

}

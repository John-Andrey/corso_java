package it.alfasoft.corso.astratto.tictoe;

public class MainTicToe {
    public static void main(String[] args) {
        Partita partita = new Partita();
        while (!partita.partitaPersa()) {
            partita.stampaTabella();
            partita.faiUnaMossa();
        }
        partita.stampaTabella();
        if (partita.Vincitore()) {
            System.out.println("Partita vinta da: " + (partita.getGiocatoreAttuale() == Giocatori.PLAYER ? "Computer" : "Player"));
        } else {
            System.out.println("La partita è un pareggio.");
        }
    }
}

package it.alfasoft.corso.astratto.tictoe;

import java.util.Scanner;

public abstract class TicToe {
    protected char[][] tabella;
    protected Giocatori giocatoreAttuale;
   //creo la tabella
    public TicToe() {
        tabella = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabella[i][j] = ' ';
            }
        }
        giocatoreAttuale = Giocatori.PLAYER;
    }
    public abstract boolean Vincitore();
    public abstract boolean partitaPersa();
    public char[][] getTabella() {
        return tabella;
    }
    public Giocatori getGiocatoreAttuale() {
        return giocatoreAttuale;
    }
    public void cambioTurno() {
        if (giocatoreAttuale == giocatoreAttuale.PLAYER) {
            giocatoreAttuale = giocatoreAttuale.COMPUTER;
        } else {
            giocatoreAttuale = giocatoreAttuale.PLAYER;
        }
    }

    public boolean faiUnaMossa() {
        if (partitaPersa()) {
            return false;
        }
        int riga, colonna;
        if (giocatoreAttuale == Giocatori.PLAYER) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Scegliere la riga");
                riga = scanner.nextInt();
                System.out.print("Scegliere la colonna");
                colonna = scanner.nextInt();
                if (riga >= 0 && riga <= 2 && colonna >= 0 && colonna <= 2 && tabella[riga][colonna] == ' ') {
                    tabella[riga][colonna] = 'X';
                    cambioTurno();
                    return true;
                } else {
                    System.out.println("Posizione occupata o non valida, riprova.");
                }
            }
        } else {
            do {
                riga = (int) (Math.random() * 3);
                colonna = (int) (Math.random() * 3);
            } while (tabella[riga][colonna] != ' ');

            tabella[riga][colonna] = 'O';
            cambioTurno();
            return true;
        }
    }
}

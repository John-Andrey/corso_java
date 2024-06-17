package it.alfasoft.corso.astratto.tictoe;

public class Partita extends TicToe {
    public boolean Vincitore() {
        // riga
        for (int i = 0; i < 3; i++) {
            if (tabella[i][0] != ' ' && tabella[i][0] == tabella[i][1] && tabella[i][1] == tabella[i][2]) {
                return true;
            }
        }
        // colonna
        for (int j = 0; j < 3; j++) {
            if (tabella[0][j] != ' ' && tabella[0][j] == tabella[1][j] && tabella[1][j] == tabella[2][j]) {
                return true;
            }
        }
        // controllo diagonale
        if ((tabella[0][0] != ' ' && tabella[0][0] == tabella[1][1] && tabella[1][1] == tabella[2][2]) ||
                (tabella[0][2] != ' ' && tabella[0][2] == tabella[1][1] && tabella[1][1] == tabella[2][0])) {
            return true;
        }
        return false;
    }
    public boolean partitaPersa() {
        if (Vincitore()) {
            return true;
        }
        // controllo se le celle sono tutte esaurite
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabella[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    // stampa tabella
    public void stampaTabella() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabella[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package main.java;

class Main {

    private static boolean possible(int[][] board, int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value || board[i][x] == value) {
                return false;
            }
        }
        int x0 = (int) Math.floor(x / 3) * 3;
        int y0 = (int) Math.floor(y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print_board(int[][] board) {
        System.out.println("=========================================");
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                if(x % 3 == 0) {
                    System.out.print("||");
                }
                else {
                    System.out.print("|");
                }
                if(board[y][x] == 0) {
                    System.out.print("   ");
                }
                else {
                    System.out.print(" " + board[y][x] + " ");
                }
            }
            System.out.println("||");
            if((y + 1) % 3 == 0) {
                System.out.println("=========================================");
            }
            else {
                System.out.println("-----------------------------------------");
            }
        }
    }

    private static void solve(int[][] board) {
        // Loopa igenom alla rader och kolumner
        //    Kolla om det är en nolla på aktuell pos
        //       Loopa igenon alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värde på aktuell pos
        //              Om ja, placera aktuellt värde
        //              Anropa solve
        //              Ta bort aktuellt värde
        //        Gör return
        // Skriv ut lösning

        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                if(board[y][x] == 0) {
                    for(int n = 1; n <= 9; n++) {
                        if(possible(board, x, y, n)) {
                            board[y][x] = n;
                            solve(board);
                            
                            board[y][x] = 0;
                        }
                    }
                    return;
                }
            }
        }
        print_board(board);
    }

    public static void main2(String[] args) {
       /* int[][] board = { 
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };*/
        int[][] board = {
            {0, 0, 8, 3, 0, 1, 4, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 7, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 9},
            {8, 0, 0, 7, 0, 5, 0, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 8, 0, 4, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 8},
            {0, 2, 0, 0, 0, 0, 0, 3, 0},
            {0, 0, 4, 2, 0, 3, 1, 0, 0}
        };

        solve(board);
    }
}
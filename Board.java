/**
 * @author MrByte8
 *
 */

public class Board {
	public static void printBoard(byte[] board, byte[] capturedS) { 
        /* PRINT BOARD. 
          
                  11  10  9   8   7   6
                  -   -   -   -   -   -
                | 4 | 4 | 4 | 4 | 4 | 4 |   <-P2
                  -   -   -   -   -   -
             (*)                         (*)
              0          MANCALA          0
             (*)                         (*)
                  -   -   -   -   -   -
         P1->   | 4 | 4 | 4 | 4 | 4 | 4 |
                  -   -   -   -   -   -
                  1   2   3   4   5   6
	    */
		
		System.out.println("           11  10  9   8   7   6");
        System.out.println("           -   -   -   -   -   -");
        System.out.println("         | "+ board[11] +" | "+ board[10] +" | "+ board[9] +" | "+ board[8] +" | "+ board[7] +" | "+ board[6] + " |   <-P2   ");
        System.out.println("           -   -   -   -   -   -");
        System.out.println("      (*)"+"                         (*)");
        System.out.println("       "+capturedS[0] + "          MANCALA          "+ capturedS[1]);
        System.out.println("      (*)"+"                         (*)");
        System.out.println("           -   -   -   -   -   -");
        System.out.println("  P1->   | "+ board[0] +" | "+ board[1] +" | "+ board[2] +" | "+ board[3] +" | "+ board[4] +" | "+ board[5] + " |");
        System.out.println("           -   -   -   -   -   -");
        System.out.println("           0   1   2   3   4   5");
    }
	
	public static void printFinalScore(byte[] capturedS, String player) {
		/* TO PRINT THE FINAL SCORE.
		 
		  	--------------------------
			|       FINAL SCORE      |
			--------------------------
			|     P1: 26 - P2: 16    |
			|                        |
			| J1 A GANADO LA PARTIDA |
	 		 ------------------------ 
	     		
		 */
		
		 System.out.println();
		 System.out.println("\t--------------------------");
		 System.out.println("\t|       FINAL SCORE      |");
		 System.out.println("\t--------------------------");
		 System.out.println("\t|     P1: "+capturedS[1]+" - "+"P2: "+capturedS[0]+"    |");
		 System.out.println("\t|                        |");
		 System.out.println("\t|     "+player+" WON THE GAME    |");
		 System.out.println("\t ------------------------ ");
	}
}
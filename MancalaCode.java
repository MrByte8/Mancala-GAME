/**
 * @author MrByte8
 *
 */

import java.util.Scanner;

public class MancalaCode {
	public static void main(String[] args){
		
		byte[] board = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
		byte[] capturedS = {0, 0};
		
		String player1 = "P1", player2 = "P2";
		byte position = 0, stones = 0, limit = 0, limitSecondR = 0, finalPosition = 0;
		boolean end = false;
		
		try(Scanner readKeys = new Scanner(System.in)){
			System.out.println("\tPLAYER 1 = P1 / PLAYER 2 = P2 ");
			System.out.println();
			Board.printBoard(board, capturedS);
			
			while(end == false) {
				
				//PLAYER 1.
				if(capturedS[0] <= 24 || capturedS[1] <= 24) {
					System.out.print("P1: ");
					position = readKeys.nextByte();
					
				//LOOP FOR WHEN THE POSITION ENTER IS NOT FROM THE PART OF THE PLAYER'S BOARD 1.
					while (!(position >= 0 && position <=5)){
						System.out.print("The position entered is not valid. Enter another: ");
						position = readKeys.nextByte();
					}
					 
					stones = board[position];
					 
				//LOOP FOR WHEN THE POSITION IS ALREADY EMPTY AND ANOTHER HAS TO BE CHOSEN.
					while(stones == 0) {
						System.out.print("This position is empty, enter another position: ");
						position = readKeys.nextByte();	
						stones = board[position];
					}
					 
				//CONDITION TO SPECIFY THE LIMIT.
					limit = (byte) (stones + position);
					 
					if(limit >= 11) {
						limit = 11;
					}
					 
				//LOOP TO GO THROUGH THE BOARD AND DISTRIBUTE THE STONES OF THE SELECTED POSITION.
					for(byte i = (byte) (position +1); i <=limit;i++) {
						board[i] = (byte) (board[i] +1);
						stones --;
						finalPosition = i;
					}
					 
				//LOOP IN CASE THAT PLACING STONES GOES THAN THE LIMIT OF THE ARRAY (WHICH IS 11).
					board[position] = 0;
					 
					for(byte i = 0; i < stones;i++) {
						board[i] = (byte) (board[i] +1);
						finalPosition = i;
					}
					 
				//CAPTURE STONES PLAYER 1.
					limit = (byte) (finalPosition -1);
					 
					if(limit == 5) {
						limit = 6;
					}
					 
					for(byte i = finalPosition; i >= limit; i--) {
						if((board[i] == 2 || board[i] == 3) && finalPosition >= 6) {
							capturedS[1] += board[i];
							System.out.println("P1 captures "+board[i]+" from position "+i);
							board[i] = 0;
						} else {break;}
					}
				}
				 
				//PRINT THE FINAL RESULT IF PLAYER 1 WINS AND EXIT THE WHILE LOOP.
				if(capturedS[1] > 24){
					Board.printFinalScore(capturedS, player1);
					end = true;
					break;
				}
				 
				Board.printBoard(board, capturedS);
				 
				//PLAYER 2.
				if(capturedS[0] <= 24 || capturedS[1] <= 24) {
					System.out.print("P2: ");
					position = readKeys.nextByte();
					 
				//LOOP FOR WHEN THE POSITION ENTER IS NOT FROM THE PART OF THE PLAYER'S BOARD 2.
					while (!(position >= 6 && position <=11)){
						System.out.print("The position entered is not valid. Enter another: ");
						position = readKeys.nextByte();
					}
					 
					stones = board[position];
					
				//LOOP FOR WHEN THE POSITION IS ALREADY EMPTY AND ANOTHER HAS TO BE CHOSEN.
					while(stones == 0) {
						System.out.print("This position is empty, enter another position: ");
						position = readKeys.nextByte();
						
						stones = board[position];
					}
					
				//CONDITION TO SPECIFY THE LIMIT.
					limit = (byte) (stones + position);
						 
					if(limit >= 11) {
						limit = 11;
					}
					
				//LOOP TO GO THROUGH THE BOARD AND DISTRIBUTE THE STONES OF THE SELECTED POSITION.
					for(byte i = (byte) (position +1); i <=limit;i++) {
						board[i] = (byte) (board[i] +1);
						stones --;
						finalPosition = i;
					}
					
				//LOOP IN CASE THAT PLACING STONES GOES THAN THE LIMIT OF THE ARRAY (WHICH IS 11).
					board[position] = 0;
					
					limitSecondR = stones;
					
					for(byte i = 0; i < limitSecondR;i++) {
						if(i <= 11) {
							board[i] = (byte) (board[i] +1);
							finalPosition = i;
							stones --;
						} else {
							for(byte t = 0; t < stones; t++) {
								board[t] = (byte) (board[t] +1);
								finalPosition = t;
							}
						}
					}
					
				//CAPTURE STONES PLAYER 2.
					limit = (byte) (finalPosition -1);
					
					if(limit < 0) {
						limit = 0;
					}
						 
					for(byte i = finalPosition; i >= limit; i--) {
						if((board[i] == 2 || board[i] == 3) && finalPosition <= 5) {
							capturedS[0] += board[i];
							System.out.println("P2 captures "+board[i]+" from position "+i);
							board[i] = 0;
						} else {break;}
					}
				 }
				 
				 //PRINT THE FINAL RESULT IF PLAYER 1 WINS AND EXIT THE WHILE LOOP.
				 if(capturedS[0] > 24){
					 Board.printFinalScore(capturedS, player2);
					 end = true;
					 break;
				 }
				 
				 Board.printBoard(board, capturedS); 
			}
		}
	}
}
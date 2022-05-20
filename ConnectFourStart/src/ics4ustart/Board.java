package ics4ustart;

import java.util.Random;

/**
 * Represents a 2 dimensional Board for Grid based games.
 * @author Rainey Hunt
 * @version 1.0
 *
 */
public class Board {
	
	private Cell[][] board;
	private int rows;
	private int cols;
	private int row;

	/**
	 * Constructor for Boards.
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		row = aRows-1;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}
	
	/**
	 * Obtain the current number of rows.
	 * @return number of rows
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Obtain the current number of columns.
	 * @return number of columns
	 */
	public int getCols(){
		return cols;
	}
	
	
	public boolean validCol(int col) {
		if(board[0][col-1].getState() == CellState.EMPTY) {
			return true;
		}
		
		return false;
	}
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}

	public void placePiece(int column, CellState player) {
		if(validCol(column)) {
			row = row(column);
			if(row!=-1) {
			board[row][column-1].setState(player);
			row = rows-1;
			}
		}
		
	}

	public int row(int column) {
		boolean valid= false;
		while(!valid) {
			if(row == -1) {
				row = rows-1;
				return -1;
			}
			if(board[row][column-1].getState() == CellState.EMPTY) {
				valid = true;
			}
			else {
				row -=1;
			}
			if(row<0) {
				row = rows-1;
				valid = true;
				return -1;
			}

		}
		int ans = row;
		row = rows -1;
		return ans;
	}

	public boolean isWinner() {
		if(vWin()) {
			return true;
		}
		if(dWin()) {
			return true;
		}
		if(hWin()) {
			return true;
		}
		return false;
	}

	private boolean hWin() {
		for(int i=0; i<4;i++) {
			if(row == -1) {
				return false;
			}
			if(board[row][i].getState() == board[row][i+1].getState() && board[row][i+2].getState() == board[row][i].getState() && board[row][i+3].getState() == board[row][i].getState()) {
				if(board[row][i].getState() == CellState.P1) {
					System.out.println("Player 1 Wins !!!");
					return true;
				}
				if(board[row][i].getState() == CellState.P2) {
					System.out.println("Player 2 Wins !!!");
					return true;
				}
			}
		}
		return false;
	}

	private boolean dWin() {
		for(int n = 0; n<4;n++) {
			for(int i=rows-1; i>2;i--) {
				if(board[i][n].getState() ==board[i-1][n+1].getState() && board[i-2][n+2].getState() == board[i][n].getState() && board[i-3][n+3].getState() == board[i][n].getState()) {
					if(board[i][n].getState() == CellState.P1) {
						System.out.println("Player 1 Wins !!!");
						return true;
					}
					if(board[i][n].getState() == CellState.P2) {
						System.out.println("Player 2 Wins !!!");
						return true;
					}
				}
			}
			}
			return false;
	}

	private boolean vWin() {
		for(int n = 0; n<cols;n++) {
		for(int i=rows-1; i>2;i--) {
			if(board[i][n].getState() ==board[i-1][n].getState() && board[i-2][n].getState() == board[i][n].getState() && board[i-3][n].getState() == board[i][n].getState()) {
				if(board[i][n].getState() == CellState.P1) {
					System.out.println("Player 1 Wins !!!");
					return true;
				}
				if(board[i][n].getState() == CellState.P2) {
					System.out.println("Player 2 Wins !!!");
					return true;
				}
			}
		}
		}
		return false;
	}

	public boolean isFull() {
		for(int i=1;i<=cols; i++) {
			if(validCol(i)) {
				return false;
			}
		}
		return true;
	}
	public CellState getState(int i, int j) {
		if(i<0) {
			return CellState.EMPTY;
		}
		return board[i][j].getState();
		
	}
}

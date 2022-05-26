package ics4ustart;

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
	
	/**
	 * check if a column is still empty
	 * @param col
	 * @return boolean
	 */
	public boolean validCol(int col) {
		if(col>0) {
			if(board[0][col-1].getState() == CellState.EMPTY) {
				return true;
			}
		}
		
		return false;
	}
	/**
	 * display a board
	 */
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
	/**
	 * place a piece in a valid and indicated column
	 * @param column
	 * @param player
	 */
	public void placePiece(int column, CellState player) {
		if(validCol(column)) {
			row = row(column);
			//find row
			if(row!=-1) {
				//place piece
				board[row][column-1].setState(player);
				row = rows-1;
			}
		}
		
	}
	/**
	 * find the greatest possible row value that is empty
	 * @param column
	 * @return integer
	 */
	public int row(int column) {
		if(column <1) {
			return -1;
		}
		boolean valid= false;
		while(!valid) {
			if(row == -1) {
				row = rows-1;
				return -1;
			}
			//check if this row isn't filled
			if(board[row][column-1].getState() == CellState.EMPTY) {
				valid = true;
			}
			else {
				row -=1;
			}
		}
		int ans = row;
		row = rows -1;
		//give the available row
		return ans;
	}
	/**
	 * find out if the board has a winner vertically, horizontally, diagonally
	 * @return boolean 
	 */
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
	/**
	 * find if there is a win horizontally
	 * @return boolean 
	 */
	private boolean hWin() {
		for(int i=0; i<4;i++) {
			if(row == -1) {
				return false;
			}
			//check for a horizontal winner
			if(board[row][i].getState() == board[row][i+1].getState() && board[row][i+2].getState() == board[row][i].getState() && board[row][i+3].getState() == board[row][i].getState()) {
				//check if player 1 wins
				if(board[row][i].getState() == CellState.P1) {
					System.out.println("Player 1 Wins !!!");
					return true;
				}
				//check if player 2 wins
				if(board[row][i].getState() == CellState.P2) {
					System.out.println("Player 2 Wins !!!");
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * find if there is a win diagonally
	 * @return boolean 
	 */
	private boolean dWin() {
		for(int n = 0; n<4;n++) {
			for(int i=rows-1; i>2;i--) {
				//check for a diagonal winner
				if(board[i][n].getState() ==board[i-1][n+1].getState() && board[i-2][n+2].getState() == board[i][n].getState() && board[i-3][n+3].getState() == board[i][n].getState()) {
					//check if player 1 wins
					if(board[i][n].getState() == CellState.P1) {
						System.out.println("Player 1 Wins !!!");
						return true;
					}
					//check if player 2 wins
					if(board[i][n].getState() == CellState.P2) {
						System.out.println("Player 2 Wins !!!");
						return true;
					}
				}
			}
			}
			return false;
	}
	/**
	 * find if there is a win verticaly
	 * @return boolean 
	 */
	private boolean vWin() {
		for(int n = 0; n<cols;n++) {
			for(int i=rows-1; i>2;i--) {
				//check for a vertical winner
				if(board[i][n].getState() ==board[i-1][n].getState() && board[i-2][n].getState() == board[i][n].getState() && board[i-3][n].getState() == board[i][n].getState()) {
					//check if player 1 wins
					if(board[i][n].getState() == CellState.P1) {
						System.out.println("Player 1 Wins !!!");
						return true;
					}
					//check if player 2 wins
					if(board[i][n].getState() == CellState.P2) {
						System.out.println("Player 2 Wins !!!");
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * check is board is not completely full
	 * @return boolean
	 */
	public boolean isFull() {
		//check each column
		for(int i=1;i<=cols; i++) {
			if(validCol(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * find out the cellstate of a specific cell
	 * @param i
	 * @param j
	 * @return CellState
	 */
	public CellState getState(int i, int j) {
		if(i<0) {
			return CellState.EMPTY;
		}
		return board[i][j].getState();
		
	}
	/**
	 * give the board as a 2d array of cells
	 * @return the board
	 */
	public Cell[][] getBoard() {
		return board;
	}
}

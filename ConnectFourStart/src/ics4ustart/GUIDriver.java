package ics4ustart;

import java.awt.Color;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author Rainey Hunt
 *
 */

public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//initialize all board class needs
		Board board = new Board(6,7);
		CellState player = CellState.P1;
		board.display();
		//make font
		Font font = new Font("Verdana", 24);
		
		//title
		Label title = new Label("CONNECT FOUR");
		title.setFont(font);
		
		//make buttons for each column for ai
		HBox btns = new HBox(10);
		Button btnC1 = new Button("1");
		btnC1.setFont(font);
		Button btnC2 = new Button("2");
		btnC2.setFont(font);
		Button btnC3 = new Button("3");
		btnC3.setFont(font);
		Button btnC4 = new Button("4");
		btnC4.setFont(font);
		Button btnC5 = new Button("5");
		btnC5.setFont(font);
		Button btnC6 = new Button("6");
		btnC6.setFont(font);
		Button btnC7 = new Button("7");
		btnC7.setFont(font);
		btns.setAlignment(Pos.CENTER);
		btns.getChildren().addAll(btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7);
		
		//add the game board
		VBox pBoard = new VBox(10);
		HBox row1 = new HBox(10);
		HBox row2 = new HBox(10);
		HBox row3 = new HBox(10);
		HBox row4 = new HBox(10);
		HBox row5 = new HBox(10);
		HBox row6 = new HBox(10);
		
		//Initialize each game place 
		Button[][] boardGame = new Button[6][7];
		for(int i= 0; i<6; i++) {
			for(int j =0; j<7; j++) {
				boardGame[i][j] = new Button();
				boardGame[i][j].setFont(font);
				boardGame[i][j].setMinSize(48, 48);
				if(i==0) {
					row1.getChildren().add(boardGame[i][j]);
					row1.setAlignment(Pos.CENTER);
				}
				else if(i==1) {
					row2.getChildren().add(boardGame[i][j]);
					row2.setAlignment(Pos.CENTER);
				}
				else if(i==2) {
					row3.getChildren().add(boardGame[i][j]);
					row3.setAlignment(Pos.CENTER);
				}
				else if(i==3) {
					row4.getChildren().add(boardGame[i][j]);
					row4.setAlignment(Pos.CENTER);
				}
				else if(i==4) {
					row5.getChildren().add(boardGame[i][j]);
					row5.setAlignment(Pos.CENTER);
				}
				else if(i==5) {
					row6.getChildren().add(boardGame[i][j]);
					row6.setAlignment(Pos.CENTER);
				}
			}
			
		}
		//place all rows on to the game board
		pBoard.getChildren().addAll(row1,row2,row3,row4,row5,row6);
		pBoard.setAlignment(Pos.CENTER);
		
		Label msg = new Label();
		msg.setFont(font);
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(title, btns, pBoard, msg);
		
		//create buttons to change modes
		Button btnAI = new Button("Human vs Computer");
		Button btn2Player = new Button("Two Player");
		btnAI.setFont(font);
		btnAI.setAlignment(Pos.CENTER);
		btn2Player.setFont(font);
		btn2Player.setAlignment(Pos.CENTER);
		VBox v = new VBox(10);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(btnAI, btn2Player);
		
		//create buttons for player 1
		HBox play1 = new HBox(10);
		Button col1 = new Button("1");
		col1.setFont(font);
		Button col2 = new Button("2");
		col2.setFont(font);
		Button col3 = new Button("3");
		col3.setFont(font);
		Button col4 = new Button("4");
		col4.setFont(font);
		Button col5 = new Button("5");
		col5.setFont(font);
		Button col6 = new Button("6");
		col6.setFont(font);
		Button col7 = new Button("7");
		col7.setFont(font);
		play1.setAlignment(Pos.CENTER);
		play1.getChildren().addAll(col1,col2,col3,col4,col5,col6,col7);
		
		//create buttons for player 2
		HBox play2 = new HBox(10);
		Button btnCol1 = new Button("1");
		btnCol1.setFont(font);
		Button btnCol2 = new Button("2");
		btnCol2.setFont(font);
		Button btnCol3 = new Button("3");
		btnCol3.setFont(font);
		Button btnCol4 = new Button("4");
		btnCol4.setFont(font);
		Button btnCol5 = new Button("5");
		btnCol5.setFont(font);
		Button btnCol6 = new Button("6");
		btnCol6.setFont(font);
		Button btnCol7 = new Button("7");
		btnCol7.setFont(font);
		play2.setAlignment(Pos.CENTER);
		play2.getChildren().addAll(btnCol1,btnCol2,btnCol3,btnCol4,btnCol5,btnCol6,btnCol7);
		Scene chooseMode = new Scene(v,450,600);
		Scene scene = new Scene(vbox, 450, 600);
		
		//open mode selector
		stage.setScene(chooseMode);
		stage.setTitle("Connect Four");
		stage.show();
		
		//open AI mode
		btnAI.setOnAction(e->{
			stage.setScene(scene);
			stage.show();
		});
		
		//open two player mode
		btn2Player.setOnAction(e->{
			vbox.getChildren().remove(btns);
			vbox.getChildren().add(play1);
			stage.setScene(scene);
			stage.show();
			
		});
		
		//place piece for ai mode
		btnC1.setOnAction(e ->{
			play(board, 1, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC2.setOnAction(e ->{
			play(board, 2, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC3.setOnAction(e ->{
			play(board, 3, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC4.setOnAction(e ->{
			play(board, 4, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC5.setOnAction(e ->{
			play(board, 5, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC6.setOnAction(e ->{
			play(board, 6, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		btnC7.setOnAction(e ->{
			play(board, 7, player, boardGame, msg, vbox, btns);
			winOtherWin(board,msg,vbox,btns,boardGame);
		});
		
		//place player 1's pieces
		col1.setOnAction(e ->{
			play(board, 1, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col2.setOnAction(e ->{
			play(board, 2, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col3.setOnAction(e ->{
			play(board, 3, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col4.setOnAction(e ->{
			play(board, 4, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col5.setOnAction(e ->{
			play(board, 5, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col6.setOnAction(e ->{
			play(board, 6, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		col7.setOnAction(e ->{
			play(board, 7, player, boardGame, msg, vbox, btns);
			changePlayer1(board,msg,vbox,btns,play2,play1);
		});
		
		//place player 2's pieces
		btnCol1.setOnAction(e ->{
			play(board, 1, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol2.setOnAction(e ->{
			play(board, 2, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol3.setOnAction(e ->{
			play(board, 3, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol4.setOnAction(e ->{
			play(board, 4, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol5.setOnAction(e ->{
			play(board, 5, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol6.setOnAction(e ->{
			play(board, 6, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		btnCol7.setOnAction(e ->{
			play(board, 7, CellState.P2, boardGame, msg, vbox, btns);
			changePlayer2(board,msg,vbox,btns,play2,play1);
		});
		

	}
	
	/**
	 * check if board is full, check for winners, play for AI and check winner again
	 * @param board
	 * @param msg
	 * @param vbox
	 * @param btns
	 * @param boardGame
	 */
	private void winOtherWin(Board board, Label msg, VBox vbox, HBox btns, Button[][] boardGame) {
		//check if board is full
		if(board.isFull()) {
			if(!board.isWinner()) {
				msg.setText("UNWINNABLE!!");
				vbox.getChildren().removeAll(btns);
			}
		}
		//check winner and place ai piece
		winner(board, msg, vbox, btns);
		otherPlayer(board, boardGame);
		winner(board, msg, vbox, btns);
	}

	/**
	 * change player to player 2
	 * @param board
	 * @param msg
	 * @param vbox
	 * @param btns
	 * @param play2
	 * @param play1
	 */
	private void changePlayer1(Board board, Label msg, VBox vbox, HBox btns, HBox play2, HBox play1) {
		//check if board is full
		if(board.isFull()) {
			if(!board.isWinner()) {
				msg.setText("UNWINNABLE!!");
				vbox.getChildren().removeAll(play1);
			}
		}
		
		//change player
		else if(!winner(board, msg, vbox, btns)) {
			vbox.getChildren().add(play2);
			msg.setText("Player 2's turn");
		}
		vbox.getChildren().remove(play1);
		
	}
	
	/**
	 * change player to player 1
	 * @param board
	 * @param msg
	 * @param vbox
	 * @param btns
	 * @param play2
	 * @param play1
	 */
	private void changePlayer2(Board board, Label msg, VBox vbox, HBox btns, HBox play2, HBox play1) {
		//check if board is full
		if(board.isFull()) {
			if(!board.isWinner()) {
				msg.setText("UNWINNABLE!!");
				vbox.getChildren().removeAll(play2);
			}
		}
		
		//change player
		else if(!winner(board, msg, vbox, btns)) {
			vbox.getChildren().add(play1);
			msg.setText("Player 1's turn");
		}
		vbox.getChildren().remove(play2);
		
	}

	/**
	 * place piece if column isn't full
	 * @param board
	 * @param i
	 * @param player
	 * @param boardGame
	 * @param msg
	 * @param vbox
	 * @param btns
	 */
	private void play(Board board, int i, CellState player, Button[][] boardGame, Label msg, VBox vbox, HBox btns) {
		//check if column isn't full
		if(board.validCol(i)) {
			//place piece
			board.placePiece(i, player);
			board.display();
			int row = board.row(i);
			changeColor(row, board, boardGame, i);
		}
		
	}
	
	/**
	 * play for AI
	 * @param board
	 * @param boardGame
	 */
	private void otherPlayer(Board board, Button[][] boardGame) {
		Random rand = new Random();
		CellState player = CellState.P2;
		//continue until a valid column is generated
		boolean notValid = true;
		while(notValid) {
			//find a column
			int col = rand.nextInt(8);
			if(board.validCol(col)) {
				//place piece
				board.placePiece(col, player);
				changeColor(board.row(col), board, boardGame, col);
				notValid = false;
			}
		}
		
	}
	
	/**
	 * check for a winner
	 * @param board
	 * @param msg
	 * @param vbox
	 * @param btns
	 * @return boolean
	 */
	private boolean winner(Board board, Label msg, VBox vbox, HBox btns) {
		if(board.isWinner()) {
			msg.setText("WINNER!!");
			vbox.getChildren().remove(btns);
			return true;
		}
		return false;
		
	}
	
	/**
	 * change the color of each place on the board to match the piece there
	 * @param row
	 * @param board
	 * @param boardGame
	 * @param i
	 */
	private void changeColor(int row, Board board, Button[][] boardGame, int i) {
		Cell[][] cells = board.getBoard();
		  for (int r = 0; r < cells.length; r++) {
		   for (int c = 0; c < cells[0].length; c++) {
		    if (cells[r][c].getState() == CellState.P1) {
		     boardGame[r][c].setStyle("-fx-background-color: #00ffff; ");

		    } else if (cells[r][c].getState() == CellState.P2) {
		     boardGame[r][c].setStyle("-fx-background-color: #ff00FF; ");

		    }

		   }

		  }
		 }

	public static void main(String[] args) {
		launch(args);

	}

}

package ics4ustart;

import java.awt.Color;

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
		Font font = new Font("Verdana", 24);
		Label title = new Label("CONNECT FOUR");
		title.setFont(font);
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
		
		VBox pBoard = new VBox(10);
		HBox row1 = new HBox(10);
		HBox row2 = new HBox(10);
		HBox row3 = new HBox(10);
		HBox row4 = new HBox(10);
		HBox row5 = new HBox(10);
		HBox row6 = new HBox(10);
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
		pBoard.getChildren().addAll(row1,row2,row3,row4,row5,row6);
		pBoard.setAlignment(Pos.CENTER);
		

		Label msg = new Label();
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(title, btns, pBoard, msg);
		Scene scene = new Scene(vbox, 450, 600);
		stage.setScene(scene);
		stage.setTitle("Connect Four");
		stage.show();
		
		btnC1.setOnAction(e ->{
			if(board.validCol(1)) {
				board.placePiece(1, player);
				board.display();
				int row = board.row(1);
				if(board.getState(row,1) == CellState.P1) {
					boardGame[row][1].setStyle("-fx-background-color: #00fff; ");
				}
				
				if(board.getState(row,1) == CellState.P2) {
					boardGame[row][1].setStyle("-fx-background-color: #ff00ff; ");
				}
				
				board.isWinner();
				
				
			}
		});
		btnC2.setOnAction(e ->{
			
			
		});
		btnC3.setOnAction(e ->{
			
		});
		btnC4.setOnAction(e ->{
			
		});
		btnC5.setOnAction(e ->{
			
		});
		btnC6.setOnAction(e ->{
			
		});
		btnC7.setOnAction(e ->{
			
		});

	}

	private CellState playerSwich(CellState player) {
		if (player == CellState.P1) {
			player = CellState.P2;
		}
		else if (player == CellState.P2) {
			player = CellState.P1;
		}
		return player;
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}

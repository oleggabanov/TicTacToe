package XO.controller;

import XO.model.Board;
import XO.model.Player;
import XO.view.BoardView;
import XO.view.ConsoleReaderInterface;

import static XO.model.Winner.isWinner;

public class GameController {
  private Player currentPlayer;
  private Player player1;
  private Player player2;
  private Board board;
  private BoardView boardView;
  private ConsoleReaderInterface reader;

  public GameController(Player player1, Player player2, ConsoleReaderInterface reader, Board board, BoardView boardView) {
    this.player1 = player1;
    this.player2 = player2;
    this.reader = reader;
    this.board = board;
    this.boardView = boardView;
  }


  public void startGame() {
    currentPlayer = player1;
    boardView.showRules();
    boardView.showDefaultBoard();
    board.boardFilling();
    while (true) {
      boardView.showCurrentPlayer(currentPlayer.getSymbolOfPlayer());
      try {
        int indexOfField = reader.readNumber();
        if (isIntegerRange(indexOfField)) {
          int[] coordinates = convertToCoordinates(indexOfField);
          int row = coordinates[0];
          int col = coordinates[1];
          if (board.isFree(row, col)) {
            board.setSymbol(row, col, currentPlayer.getSymbolOfPlayer());
          } else {
            boardView.showFieldIsBusy();
            switchPlayers();
          }
          boardView.showBoard(board);
          if (isWinner(board.getField(), currentPlayer.getSymbolOfPlayer())) {
            boardView.showWinner(currentPlayer.getSymbolOfPlayer());
            return;
          }
          if (isBoardFilled(board)) {
            boardView.showDraw();
            return;
          }
          switchPlayers();
        } else {
          boardView.showRules();
        }
      } catch (Exception e) {
        boardView.showError();
      }
    }
  }


  private void switchPlayers() {
    if (currentPlayer == player1) {
      currentPlayer = player2;
    } else {
      currentPlayer = player1;
    }
  }

  public static int[] convertToCoordinates(int number) {
    int row = (number - 1) / 3;
    int col = (number - 1) % 3;
    return new int[]{row, col};
  }

  private static boolean isBoardFilled(Board board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.getField()[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isIntegerRange(int number) {
    return number >= 1 && number <= 9;
  }
}

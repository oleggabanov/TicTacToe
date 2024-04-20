package XO.controller;

import XO.model.Board;
import XO.model.Player;
import XO.view.BoardView;
import XO.view.ConsolePrinter;
import XO.view.ConsoleReader;

public class StartGame {

  private static final char X_PLAYER = 'X';
  private static final char O_PLAYER = 'O';


  public static void main(String[] args) {
    Player player1 = new Player(X_PLAYER);
    Player player2 = new Player(O_PLAYER);
    Board board = new Board();
    ConsoleReader reader = new ConsoleReader();
    ConsolePrinter printer = new ConsolePrinter();
    BoardView boardView = new BoardView(printer);
    GameController game = new GameController(player1, player2, reader, board, boardView);
    game.startGame();
  }

}




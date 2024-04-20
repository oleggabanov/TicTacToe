package XO.view;

import XO.model.Board;

public class BoardView {
  ConsolePrinter printer;


  public BoardView( ConsolePrinter printer) {
    this.printer = printer;
  }

  private static final String BOARD = """
           Tic-Tac-Toe
            1 | 2 | 3
           •••••••••••
            4 | 5 | 6
           •••••••••••
            7 | 8 | 9
          """;
  private static final String RULES = "Введите число от 1 до 9: ";
  private static final String CURRENT_PLAYER = "Текущий игрок: ";
  private static final String WRONG_INPUT = "Неверный ввод, введите число";
  private static final String WINNER = "Победил игрок: ";
  private static final String DRAW = "Ничья, победила дружба!";
  private static final String FIELD_IS_BUSY = "Клетка занята, переходите";


  public void showDefaultBoard() {
    printer.print(BOARD);
  }

  public void showError() {
    printer.print(WRONG_INPUT);
  }

  public void showRules() {
    printer.print(RULES);
  }

  public void showDraw() {
    printer.print(DRAW);
  }

  public void showCurrentPlayer(char symbol) {
    printer.print(CURRENT_PLAYER + symbol);
  }

  public void showWinner(char symbolOfWinner) {
    printer.print(WINNER + symbolOfWinner);
  }

  public void showFieldIsBusy() {
    printer.print(FIELD_IS_BUSY);
  }


  public void showBoard(Board board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          System.out.print(" ");
        }
        char symbol = board.getParticularField(i, j);
        if (j == 2) {
          System.out.print(symbol);
        } else {
          System.out.print(symbol + " | ");
        }
      }
      if (i == 2) {
        System.out.println();
      } else {
        System.out.println();
        System.out.print("•••••••••••");
        System.out.println();
      }
    }
  }
}


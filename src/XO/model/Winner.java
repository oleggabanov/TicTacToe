package XO.model;

public class Winner {
  public static boolean isWinner(char[][] field, char symbol) {
    return checkRow(field, symbol) ||
            checkColumn(field, symbol) ||
            checkDiagonals(field, symbol);
  }


  private static boolean checkRow(char[][] field, char symbol) {
    for (int i = 0; i < field.length; i++) {
      if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol ||
              field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol ||
              field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkColumn(char[][] field, char symbol) {
    for (int i = 0; i < field.length; i++) {
      if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol ||
              field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol ||
              field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkDiagonals(char[][] field, char symbol) {
    for (int i = 0; i < field.length; i++) {
      if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol ||
              field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
        return true;
      }
    }
    return false;
  }
}
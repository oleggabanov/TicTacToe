package XO.model;

public class Board {
  private final static int DEFAULT_SIZE = 3;
  private final static char DEFAULT_CHAR = ' ';
  private char[][] field = new char[DEFAULT_SIZE][DEFAULT_SIZE];

  public void boardFilling() {
    for (int i = 0; i < DEFAULT_SIZE; i++) {
      for (int j = 0; j < DEFAULT_SIZE; j++) {
        field[i][j] = DEFAULT_CHAR;
      }
    }
  }

  public boolean isFree(int row, int col) {
    return field[row][col] == DEFAULT_CHAR;
  }

  public char[][] getField() {
    return field;
  }

  public void setSymbol(int row, int col, char symbol) {
    field[row][col] = symbol;
  }

  public char getParticularField(int row, int col) {
    return field[row][col];
  }
}

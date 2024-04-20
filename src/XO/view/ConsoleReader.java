package XO.view;

import java.util.Scanner;

public class ConsoleReader implements ConsoleReaderInterface {
  private Scanner scanner = new Scanner(System.in);

  public String read() {
    return scanner.nextLine();
  }

  public int readNumber() {
    return Integer.parseInt(scanner.nextLine());
  }
}

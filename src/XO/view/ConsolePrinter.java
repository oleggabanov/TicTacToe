package XO.view;

public class ConsolePrinter implements ConsolePrinterInterface {
  @Override
  public void print(String message) {
    System.out.println(message);
  }


}

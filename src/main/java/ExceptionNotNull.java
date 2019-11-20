
public class ExceptionNotNull extends Exception {
  private String value;
  private String exceptionMessage;

  public String get() {
    return this.exceptionMessage;
  }

  public ExceptionNotNull() {
    this.exceptionMessage = "My exception's text, input string cannot be null";
  }
}
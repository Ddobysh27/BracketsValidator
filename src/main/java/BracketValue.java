
public class BracketValue {
  @CheckBrakets(message = "field")
  private String value;

  @CheckBrakets(message = "constructor")
  public BracketValue() {
  }

  @CheckBrakets(message = "method")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
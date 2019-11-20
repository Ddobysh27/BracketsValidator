
import java.io.FileInputStream;
import java.io.IOException;

public class ReadText {
  public ReadText(String value) {
    this.value = value;
  }

  public String value;

  public static String read() {
    String out = "";
    try (FileInputStream fis = new FileInputStream("src//main//java//Str.txt")) {
      int i = -1;
      while ((i = fis.read()) != -1) {
        out += (char) i;
      }
    } catch (IOException ex) {
      System.out.println("IOExeption \n" + ex.getMessage());
    }
    return out;
  }

}
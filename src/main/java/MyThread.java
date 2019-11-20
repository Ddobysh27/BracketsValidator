
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyThread extends Thread {
  int counter;

  MyThread(int i) {
    this.counter = i;
  }

  public static List setBrakes(String input) throws ExceptionNotNull {
    String str1 = input;
    if (str1.length() < 1) throw new ExceptionNotNull();
    ArrayList<String> charList = new ArrayList<>();
    char[] arr1 = str1.toCharArray();
    for (int i = 0; i < arr1.length; i++) {
      charList.add("" + arr1[i]);
    }
    System.out.println(charList);
    List<String> list = charList.stream().filter((p) -> p.equals("<") || p.equals(">") || p.equals("(") || p.equals(")") || p.equals("{") || p.equals("}") || p.equals("[") || p.equals("]")).collect(Collectors.toList());
    //  System.out.println(list);
    return list;
  }

  public static String checkBrakes(List list) {
    try {
      do {
        for (int i = 0; i < list.size(); ) {

          if (list.get(i).equals(">")) {
            if (list.get(i - 1).equals("<")) {
              list.remove(i);
              list.remove(i - 1);
              break;
            } else {
              System.out.println("Скобки расставлены неверно >");
              break;
            }
          }

          if (list.get(i).equals(")")) {
            if (list.get(i - 1).equals("(")) {
              list.remove(i);
              list.remove(i - 1);
              break;
            } else {
              System.out.println("Скобки расставлены неверно )");
              break;
            }
          }

          if (list.get(i).equals("]")) {
            if (list.get(i - 1).equals("[")) {
              list.remove(i);
              list.remove(i - 1);
              break;
            } else {
              System.out.println("Скобки расставлены неверно ]");
              break;
            }
          }

          if (list.get(i).equals("}")) {
            if (list.get(i - 1).equals("{")) {
              list.remove(i);
              list.remove(i - 1);
              break;
            } else {
              System.out.println("Скобки расставлены неверно }");
              break;
            }
          }

          i++;
          //  System.out.println("Размер листа =" + list.size());
          // System.out.println(list);
        }
        if (list.size() == 0) {
          System.out.println("Скобки расставлены верно");
          return "";
        }
      } while (list.size() != 0);
    } catch (IndexOutOfBoundsException ex) {
      //  System.out.println("финальный лист = " + list);
      if (list.size() != 0) {
        System.out.println("Скобки расставлены неверно");
        return "неправильная строка";
      }
    }
    // System.out.println("финальный лист = " + list);
    if (list.size() == 0) return "";
    else return "неправильная строка";
  }

  public void run() {
    try {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      Validator validator = factory.getValidator();
      BracketValue br = new BracketValue();
      br.setValue(checkBrakes(setBrakes(ReadText.read())));
      //br.getValue();
      Set<ConstraintViolation<BracketValue>> violations = validator.validate(br);
      for (ConstraintViolation<BracketValue> violation : violations) {
        System.out.println(violation.getMessage());
      }
      System.out.println("Запущен поток " + this.counter);
    } catch (ExceptionNotNull ex) {
      System.out.println(ex.get());
    }
  }
}
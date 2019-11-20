
import javax.validation.*;

public class MyValidator implements ConstraintValidator<CheckBrakets, String> {
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    if (s.equals("")) {
      System.out.println("а-верно - "+s);
      return true;
    } else {
      System.out.println("а-неверно - "+s);
      return false;
    }
  }

  public void initialize(CheckBrakets constraintAnnotation) {

  }
}
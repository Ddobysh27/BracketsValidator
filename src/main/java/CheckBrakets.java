
import java.lang.annotation.*;
import javax.validation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyValidator.class)

public @interface CheckBrakets {
  String message() default "{}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
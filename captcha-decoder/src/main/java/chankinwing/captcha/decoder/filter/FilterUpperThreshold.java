package chankinwing.captcha.decoder.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@BindingAnnotation
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER, METHOD })
public @interface FilterUpperThreshold {
}

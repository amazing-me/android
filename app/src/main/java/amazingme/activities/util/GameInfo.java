package amazingme.activities.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import amazingme.model.Milestone;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GameInfo {
    String value();
    String instruction() default "";
    Milestone[] milestones() default {};
}

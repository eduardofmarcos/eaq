package org.solidbyte.editeaqui.infrastructure.web.security.annotation;

import jakarta.ws.rs.NameBinding;
import org.solidbyte.editeaqui.infrastructure.web.security.profile.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Secured {
    Role[] value() default {};

    boolean optional() default false;
}
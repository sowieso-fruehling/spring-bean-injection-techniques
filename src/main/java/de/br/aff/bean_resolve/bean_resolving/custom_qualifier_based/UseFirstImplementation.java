package de.br.aff.bean_resolve.bean_resolving.custom_qualifier_based;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface UseFirstImplementation {
}

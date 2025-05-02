package io.aprieto;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class MainFactory {

    @Singleton
    Person createPerson() {
        return new Person("John", "Doe");
    }
}

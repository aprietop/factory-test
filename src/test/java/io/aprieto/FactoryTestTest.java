package io.aprieto;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class FactoryTestTest {

    @Inject
    ApplicationContext applicationContext;

    @Inject
    MainFactory mainFactory;

    @Inject
    Person injectedPerson;
    @Inject
    Person injectedPerson2;

    @Test
    void testItWorks() {
        Assertions.assertTrue(applicationContext.isRunning());
    }

    @Test
    void mainFactoryWorks() {
        Person person = mainFactory.createPerson();
        Person person1 = mainFactory.createPerson();
        Assertions.assertSame(person, person1);
    }

    @Test
    void personInjection(){
        Assertions.assertSame(injectedPerson, injectedPerson2);
    }

    @Test
    void personFromApplicationContext(){
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        Assertions.assertSame(person1, person2);

    }

}

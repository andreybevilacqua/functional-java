package exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunctionalExercise {

  private final List<String> testList = new ArrayList<>();

  @Test
  public void attributesToFinalTest() {
    final Person person = new Person("test", 19);
    System.out.println(person.getAge());
    System.out.println(person.getName());

    final PersonWithSetter personWithSetter = new PersonWithSetter("another_test", 22);
    System.out.println(personWithSetter.getAge());
    System.out.println(personWithSetter.getName());
    personWithSetter.setAge(99);
    personWithSetter.setName("my-test");
    System.out.println(personWithSetter.getAge());
    System.out.println(personWithSetter.getName());

    // In the List case, it cannot be re-instantiated.
    //testList = new ArrayList();
    // But we can change the objects inside it:
    testList.add("some string 1");
    testList.add("some string 2");
    testList.add("some string 3");
    assertEquals(3, testList.size());

    testList.remove("some string 1");
    assertEquals(2, testList.size());

    testList.remove("some string 2");
    assertEquals(1, testList.size());

    // To be able to never change the values inside of a Collection, we should use the unmodifiable methods
    // inside of the util Collections class. With it, we provide to the users read-only access to the collections.
    final List<String> resultToBeSentAsResult = Collections.unmodifiableList(testList);
    assertEquals(1, resultToBeSentAsResult.size());

    try {
      resultToBeSentAsResult.add("aijnesdifaisdfiuasdfa");
      assertEquals(2, resultToBeSentAsResult.size());
    } catch (UnsupportedOperationException e) {
      System.out.println("You see...");
      assertEquals(1, resultToBeSentAsResult.size());
    }

    // Take the case of the SomePerson class.
    Person somePerson = new SomePerson("some-name", 35);
    somePerson = new SomePerson("another-name", 41);
  }
}

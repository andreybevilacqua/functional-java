package exercise;

import org.junit.Test;

public class FunctionalExercise {

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
  }
}

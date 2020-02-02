package exercise;

public class Person {

  private final String name;
  private final int age;

  public Person(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  // With the final, this method cannot be @Override
  public final int checkAge() {
    return 21;
  }
}

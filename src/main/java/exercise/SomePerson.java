package exercise;

public class SomePerson extends Person {

  public SomePerson(String name, int age) {
    super(name, age);
    System.out.println(getName());
    System.out.println(getAge());
  }

  // This can't happen because the method Person.checkAge() is final.
//  @Override
//  public final int checkAge() {
//    return 88;
//  }
}

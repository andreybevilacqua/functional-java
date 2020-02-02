package exercise;

import java.util.ArrayList;
import java.util.List;

public class Test {

  private final List foo; // the final here is to initialize the list only once.

  private final int testIntValue; // in primitive variables, the final make it be set only once

  private final String testStringValue;

  public Test(int a) {
    foo = new ArrayList ();
    foo.add("foo"); // Modification-1
    // foo = new ArrayList(); // As you can see here.

    this.testIntValue = a;
    this.testStringValue = "This is a first value for this object, but it will change";

    // In the String case, we cannot re-initiate it;
    //testStringValue = "Another value"; // This will generate compile error.
  }
  public static void main(String[] args) {
    Test t = new Test(1);
    t.foo.add("bar"); // Modification-2
    System.out.println("print - " + t.foo);
    // You still can change thinks inside of the object, but you cannot re-instantiate the object
    // or point it to another ArrayList, because it is a final object.
    // The final here is not about the content.
  }
}
